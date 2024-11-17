package com.example.coroutines.service

import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_LOCATION
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyServices : Service()  {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

//        val notificationBuilder = NotificationCompat.Builder(
//            this
//            , "channelId")
//        notificationBuilder.setContentTitle("Hello")
//        notificationBuilder.setContentText("Running...")
//        notificationBuilder.setPriority(NotificationCompat.PRIORITY_LOW)
//
//        notificationBuilder.setSmallIcon(android.R.drawable.ic_dialog_info)
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            startForeground(1, notificationBuilder.build(), FOREGROUND_SERVICE_TYPE_DATA_SYNC)
//        }else{
//            startForeground(1, notificationBuilder.build())
//        }


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


//        CoroutineScope(Dispatchers.IO).launch {
//            start()
//        }
        return START_STICKY
//    }

//    private suspend fun start(){
//
//        for (i in 0..1000){
//            delay(1000)
//            Log.e("TAG", "start: $i")
//        }
//    }

//    override fun onTaskRemoved(rootIntent: Intent?) {
//        Log.e("TAG", "onTaskRemoved: ")
//        super.onTaskRemoved(rootIntent)
//    }
        }

    override fun onDestroy() {
        Log.e("TAG", "onDestroy: ")
        super.onDestroy()
    }
}