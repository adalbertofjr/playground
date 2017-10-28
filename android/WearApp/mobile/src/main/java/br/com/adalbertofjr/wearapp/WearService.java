package br.com.adalbertofjr.wearapp;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class WearService extends WearableListenerService {


    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        for (DataEvent dataEvent : dataEventBuffer) {
            if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
                String path = dataEvent.getDataItem().getUri().getPath();
                if (path.equals("/step-counter")) {
                    int steps = dataMap.getInt("step-count");
                    long time = dataMap.getLong("timestamp");
                }
            }
        }
    }

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        if (messageEvent.getPath().equals("/path/message")) {
            // Do something with byte array from messageEvent.getData()
        }
    }
}
