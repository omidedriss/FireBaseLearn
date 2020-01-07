package ir.orbitsoft.firebase.PushNotification;

import android.content.Intent;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;


import static ir.orbitsoft.firebase.Attribuites.FCM_Registered;


/**
 * Created by Sadra Isapanah Amlashi on 10/21/17.
 */

public class FCMInstanceIDService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
//            super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();



        // sending reg id to your server
        sendRegistrationToServer(refreshedToken);

        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent("registrationComplete");
        registrationComplete.putExtra("token", refreshedToken);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }
    private void sendRegistrationToServer(final String token) {
        // sending gcm token to server
        Log.e("", "sendRegistrationToServer: " + token);
    }
}