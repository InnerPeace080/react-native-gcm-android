package com.oney.gcm;

/**
 * @author phuongtq
 * @file ....java
 * @brief ....java source file.
 * <p/>
 * File/module comments.
 * @mobile 01684499886
 * @note No Note at the moment
 * @bug No known bugs.
 * <p/>
 * <pre>
 * MODIFICATION HISTORY:
 *
 * Ver   Who  	  Date       Changes
 * ----- --------- ---------- -----------------------------------------------
 * 1.00  phuongtq   12/1/2016 First release
 *
 *
 * </pre>
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class RNFcmListenerService extends FirebaseMessagingService {
    private static final String TAG = "RNFcmListenerService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : remoteMessage.getData().entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        sendNotification(bundle);
    }

    private void sendNotification(Bundle bundle) {
        Log.d(TAG, "sendNotification");

        Intent i = new Intent("com.oney.gcm.GCMReceiveNotification");
        i.putExtra("bundle", bundle);
        sendOrderedBroadcast(i, null);
    }
}
