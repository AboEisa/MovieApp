package com.example.coroutines

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        notificationChannel()

    }

    private fun notificationChannel(){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = android.app.NotificationChannel(
                "channelId",
                "channelName",
                android.app.NotificationManager.IMPORTANCE_HIGH

            )
            channel.lightColor = android.graphics.Color.BLUE
            val manager = getSystemService(android.app.NotificationManager::class.java)
            manager.createNotificationChannel(channel)

        }
    }




}