package com.example.coroutines

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        notificationChannel()
    }

   private fun notificationChannel(){
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           val channel = NotificationChannel("APP_CHANNEL"
               ,"APP_CHANNEL"
               ,NotificationManager.IMPORTANCE_DEFAULT
           )
           channel.lightColor = Color.BLUE
           channel.shouldVibrate()
           channel.vibrationPattern = longArrayOf(100,200,300,400,500,400,300,200,400)

           val manager = getSystemService(NotificationManager::class.java)
           manager.createNotificationChannel(channel)

       }
    }






}