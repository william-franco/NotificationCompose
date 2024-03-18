package br.com.williamfranco.notificationcompose.src.features.notification.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import br.com.williamfranco.notificationcompose.R

interface NotificationService {
    fun showBasicNotification()
    fun showSoundNotification()
    fun showExpandableNotification()
}

class NotificationServiceImpl(private val context: Context) : NotificationService {
    private val channelId = "my_channel_id"
    private val title = "App"
    private val description = "Description for channel"
    private val messageBasic = "Test basic notification"
    private val messageSound = "Test sound notification"
    private val messageExpandable = "Test expandable notification"

    private val priority = NotificationCompat.PRIORITY_HIGH
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    override fun showBasicNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(channelId, description, importance)

            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(messageBasic)
            .setSmallIcon(R.drawable.ic_cellphone)
            .setPriority(priority)
            .setAutoCancel(true) // in test
            .build()

        notificationManager.notify(1, notificationBuilder)
    }

    override fun showSoundNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(channelId, description, importance)

            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(messageSound)
            .setPriority(priority)
            .setSmallIcon(R.drawable.ic_cellphone)
            // .setSound(Uri.parse("android.resource://$packageName/${R.raw.meu_som}")) // som
            .setAutoCancel(true) // in test
            .build()

        notificationManager.notify(2, notificationBuilder)
    }

    override fun showExpandableNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(channelId, description, importance)

            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(messageExpandable)
            .setSmallIcon(R.drawable.ic_cellphone)
            .setPriority(priority)
            .setAutoCancel(true) // in test
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(
                        context.bitmapFromResource(
                            R.drawable.ic_cellphone
                        )
                    )
            )
            .build()
        notificationManager.notify(3, notificationBuilder)
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId:Int
    )= BitmapFactory.decodeResource(
        resources,
        resId
    )
}
