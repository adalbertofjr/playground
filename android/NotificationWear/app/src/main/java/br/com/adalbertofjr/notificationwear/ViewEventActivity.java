package br.com.adalbertofjr.notificationwear;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

/**
 * ViewEventActivity
 * Created by Adalberto Fernandes Júnior on 01/10/17.
 * Copyright © 2016. All rights reserved.
 */

class ViewEventActivity extends Activity {
    private static final String TAG = "ViewEventActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging_main);

        // Cancel Notification
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.cancel(MainActivity.NOTIFICATION_ID);

        // TODO: Handle and display message/conversation from your database
    }
}
