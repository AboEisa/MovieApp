package com.example.coroutines.mvvm

import android.app.Notification.Action
import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.coroutines.MyBroadcast
import com.example.coroutines.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val receiver = MyBroadcast()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //dynamic BroadCast
        registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

//        binding.btn.setOnClickListener {
//           getNotification()
//        }
    }

//    private fun sendNotification(){
//        val notification = NotificationCompat.Builder(this, "APP_CHANNEL")
//        notification.setContentTitle("Hello")
//        notification.setContentText("adsadasdsadsadasdas")
//        notification.setSmallIcon(android.R.drawable.ic_dialog_info)
//        notification.setPriority(NotificationCompat.PRIORITY_HIGH)
//
//        val notificationManager = getSystemService(NotificationManager::class.java)
//        notificationManager.notify(1, notification.build())
//
//
//    }
    // this example for any permission
//    private fun getNotification() {
//        if (ContextCompat.checkSelfPermission(
//                this, android.Manifest.permission.POST_NOTIFICATIONS
//            ) != android.content.pm.PackageManager.PERMISSION_GRANTED
//        )
//            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 100)
//    else{
//        sendNotification()
//        }
//    }



    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}
















