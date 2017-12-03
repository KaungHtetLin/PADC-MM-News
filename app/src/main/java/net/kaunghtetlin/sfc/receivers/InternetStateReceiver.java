package net.kaunghtetlin.sfc.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Kaung Htet Lin on 11/25/2017.
 */

public class InternetStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        /***
         * need to put permission ACCESS_NETWORK_STATE
         */

       /* NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo==null){
            Toast.makeText(context,"Your device is no longer connected to internet",Toast.LENGTH_SHORT).show();
        }
        else if(networkInfo.isConnected()){
            Toast.makeText(context, "Your device is connected to internet", Toast.LENGTH_SHORT).show();
        }*/
    }
}
