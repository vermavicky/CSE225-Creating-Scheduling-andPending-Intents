package com.BeforeMidTerm;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.ok.cse225.R;

public class PendingIntentBroadcast extends BroadcastReceiver {

    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context, R.raw.shapeofyou);

        mp.start();
        Toast.makeText(context, "Message", Toast.LENGTH_SHORT).show();

    }
}
