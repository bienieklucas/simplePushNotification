package com.bieniek.pushnotification.service

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import com.bieniek.pushnotification.R
import com.bieniek.pushnotification.util.ConstantUtil
import com.bieniek.pushnotification.view.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * @author Lucas Bieniek
 */
class PushNotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        val body: String? = remoteMessage?.notification?.body
        val title: String? = remoteMessage?.notification?.title

        createNotification(title, body)
    }

    private fun createNotification(title: String?, body: String?) {
        //create new intent with title and body notification
        val intent: Intent = Intent(this, MainActivity::class.java)
                .putExtra(ConstantUtil.PUSH_TITLE_EXTRA, title)
                .putExtra(ConstantUtil.PUSH_BODY_EXTRA, body)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        val pendindIntent: PendingIntent = PendingIntent
                .getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        //sound for notification
        val sound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder: Notification.Builder = Notification.Builder(this)
        builder.setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_push_notification)
                .setSound(sound)
                .setContentIntent(pendindIntent)

        val manager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())
    }
}