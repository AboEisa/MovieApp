package com.example.coroutines.mvvm

import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.coroutines.broadcast.MyBroadcast
import com.example.coroutines.databinding.ActivityMainBinding
import com.example.coroutines.workmanager.MyWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.concurrent.TimeUnit

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
//        handleWorkManager()
//        }
    }
//
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
//     this example for any permission
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



    private fun handleWorkManager(){


//        val calender = Calendar.getInstance()
//        calender.set(Calendar.DAY_OF_MONTH, 10)



        //type one
        val myWorker1 = PeriodicWorkRequestBuilder<MyWorker>(15, TimeUnit.DAYS)


        val constrain = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        //type two
        val myWorker2 = OneTimeWorkRequestBuilder<MyWorker>()
            .setConstraints(constrain)
            .setBackoffCriteria(BackoffPolicy.LINEAR, 1, TimeUnit.SECONDS)
//            .setBackoffCriteria(BackoffPolicy.LINEAR, 15, TimeUnit.MINUTES)
            .setInitialDelay(3, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(this).enqueue(myWorker2)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}
















