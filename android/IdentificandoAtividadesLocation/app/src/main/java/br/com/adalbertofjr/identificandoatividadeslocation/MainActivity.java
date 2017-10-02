package br.com.adalbertofjr.identificandoatividadeslocation;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.DetectedActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, ResultCallback<Status> {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    protected ActivityDetectionBroadcastReceiver broadcastReceiver;
    protected GoogleApiClient googleApiClient;
    private TextView statusActivity;
    private Button btnRequest;
    private Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusActivity = (TextView) findViewById(R.id.detectedActivities);
        btnRequest = (Button) findViewById(R.id.request_activity_updates_button);
        btnRemove = (Button) findViewById(R.id.remove_activity_updates_button);

        broadcastReceiver = new ActivityDetectionBroadcastReceiver();

        builGoogleApiClient();
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,
                new IntentFilter(Constants.BROADCAST_ACTION));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
        super.onStop();
    }

    public void requestActivityUpdatesButtonHandler(View view) {
        Log.i(LOG_TAG, "requestActivityUpdatesButtonHandler");

        if (!googleApiClient.isConnected()) {
            Toast.makeText(this, getString(R.string.not_connected), Toast.LENGTH_SHORT).show();
            return;
        }

        ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(
                googleApiClient,
                Constants.DETECTION_INTERVAL_IN_MILLISECONDS,
                getActivityDetectionPendingIntent())
                .setResultCallback(this);

        btnRequest.setEnabled(false);
        btnRemove.setEnabled(true);
    }

    public void removeActivityUpdatesButtonHandler(View view) {
        Log.i(LOG_TAG, "removeActivityUpdatesButtonHandler");

        if (!googleApiClient.isConnected()) {
            Toast.makeText(this, getString(R.string.not_connected), Toast.LENGTH_SHORT).show();
            return;
        }

        ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(
                googleApiClient,
                getActivityDetectionPendingIntent())
                .setResultCallback(this);

        btnRequest.setEnabled(false);
        btnRemove.setEnabled(true);

        btnRequest.setEnabled(true);
        btnRemove.setEnabled(false);
    }

    private void builGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(ActivityRecognition.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i(LOG_TAG, "onConnected");

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(LOG_TAG, "onConnectionSuspended");

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i(LOG_TAG, "onConnectionFailed");

    }

    public PendingIntent getActivityDetectionPendingIntent() {
        Intent intent = new Intent(this, DetectedActivitiesIntentService.class);
        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onResult(@NonNull Status status) {

        if (status.isSuccess()) {
            Log.i(LOG_TAG, "Sucesso ao adicionar detecção de atividade");
        } else {
            Log.i(LOG_TAG, "Falha ao adicionar detecção de atividade " + status.getStatusMessage());
        }
    }

    public class ActivityDetectionBroadcastReceiver extends BroadcastReceiver {
        protected final String LOG_TAG = ActivityDetectionBroadcastReceiver.class.getSimpleName();

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(LOG_TAG, "onReceive");

            ArrayList<DetectedActivity> detectedActivities = intent.getParcelableArrayListExtra(Constants.ACTIVITY_EXTRA);

            String statusStr = "";
            for (DetectedActivity activity : detectedActivities) {
                statusStr += getActivityString(activity.getType()) + " " + activity.getConfidence() + "%\n";
            }
            statusActivity.setText(statusStr);

        }

        private String getActivityString(int type) {
            switch (type) {
                case DetectedActivity.IN_VEHICLE:
                    return getResources().getString(R.string.in_vehicle);
                case DetectedActivity.ON_BICYCLE:
                    return getResources().getString(R.string.on_bicycle);
                case DetectedActivity.ON_FOOT:
                    return getResources().getString(R.string.on_foot);
                case DetectedActivity.RUNNING:
                    return getResources().getString(R.string.running);
                case DetectedActivity.STILL:
                    return getResources().getString(R.string.still);
                case DetectedActivity.TILTING:
                    return getResources().getString(R.string.tilting);
                case DetectedActivity.UNKNOWN:
                    return getResources().getString(R.string.unknown);
                case DetectedActivity.WALKING:
                    return getResources().getString(R.string.walking);
                default:
                    return getResources().getString(R.string.unidentifiable_activity);
            }
        }
    }
}
