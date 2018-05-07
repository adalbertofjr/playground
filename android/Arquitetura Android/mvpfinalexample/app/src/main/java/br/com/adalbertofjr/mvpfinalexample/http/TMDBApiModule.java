package br.com.adalbertofjr.mvpfinalexample.http;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * TMDBApiModule
 * Created by Adalberto Fernandes Júnior on 06/05/2018.
 * Copyright © 2018. All rights reserved.
 */
@Module
public class TMDBApiModule {
    public final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    public final String API_KEY = "your_api_key_here";


    @Provides
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl url = request.url().newBuilder().addQueryParameter(
                                "api_key",
                                API_KEY
                        ).build();
                        request = request.newBuilder().url(url).build();
                        return chain.proceed(request);
                    }
                }).build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public TMDBApiService provideApiService() {
        return provideRetrofit(BASE_URL, provideClient()).create(TMDBApiService.class);
    }
}
