package br.com.adalbertofjr.weardatalayerapp.services;

import android.net.Uri;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.concurrent.TimeUnit;

/**
 * WearDataLayerAppListenerService
 * Created by Adalberto Fernandes Júnior on 20/01/2018.
 * Copyright © 2016. All rights reserved.
 */

public class WearDataLayerAppListenerService extends WearableListenerService {
    private String LOG_TAG = WearDataLayerAppListenerService.class.getSimpleName();

    private static final String COUNT_PATH = "/count";
    private static final String COUNT_KEY = "count";

    private GoogleApiClient mGoogleApiClient;

    @Override
    public void onCreate() {
        super.onCreate();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        Log.d(LOG_TAG, "onDataChanged: " + dataEvents);
        if (!mGoogleApiClient.isConnected() || !mGoogleApiClient.isConnecting()) {
            ConnectionResult connectionResult = mGoogleApiClient
                    .blockingConnect(30, TimeUnit.SECONDS);
            if (!connectionResult.isSuccess()) {
                Log.e(LOG_TAG, "DataLayerListenerService failed to connect to GoogleApiClient, "
                        + "error code: " + connectionResult.getErrorCode());
                return;
            }
        }

        // Loop through the events and send a message back to the node that created the data item.
        for (DataEvent event : dataEvents) {
            Uri uri = event.getDataItem().getUri();
            String path = uri.getPath();
            if (COUNT_PATH.equals(path)) {
                // Get the node id of the node that created the data item from the host portion of
                // the uri.
                String nodeId = uri.getHost();
                // Set the data of the message to be the bytes of the Uri.
                byte[] payload = uri.toString().getBytes();

                // Send the rpc
                // Wearable.MessageApi.sendMessage(mGoogleApiClient, nodeId, DATA_ITEM_RECEIVED_PATH,
                //       payload);
            }
//            if (event.getType() == DataEvent.TYPE_CHANGED) {
//                DataMap dataMap = DataMapItem.fromDataItem(event.getDataItem()).getDataMap();
//                String path = event.getDataItem().getUri().getPath();
//
//                if (path.equals("/sunshine-forecast")) {
//                    String max = dataMap.getString(MAX_PATH);
//                    String min = dataMap.getString(MIN_PATH);
//                }
//            }
        }
    }
}
