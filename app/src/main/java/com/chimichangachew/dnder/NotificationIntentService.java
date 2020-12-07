package com.chimichangachew.dnder;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.preference.PreferenceManager;

public class NotificationIntentService extends IntentService {

    public NotificationIntentService(){
        super("DnDerIntentService");
    }

    private final int NOTIFICATION_ID = 0;
    private final String CHANNEL_ID_DNDER = "channel_DnDer";
    public static final String NOTIFY_LEFT ="com.chimichangachew.dnder.extra.NOTIFY_LEFT";
    @Override
    protected void onHandleIntent(Intent intent) {
        // Create notification channel
        String notif_mode = intent.getStringExtra(NOTIFY_LEFT);
        createHighNotificationChannel();
        boolean notifications = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("notif",false);
        if(notifications){
            if(notif_mode.contentEquals("Left"))
                createNotification("Thanks for testing the pre-alpha version of DnDer!");
        }

    }

    private void createHighNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26) return;

        CharSequence name = getString(R.string.channel_name);
        String description = getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID_DNDER, name, importance);
        channel.setDescription(description);

        // Register channel with system
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    private void createNotification(String text) {
        // Create notification with various properties
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID_DNDER)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        // Get compatibility NotificationManager
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // Post notification using ID.  If same ID, this notification replaces previous one
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
