package com.example.coroutines

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadcast : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.e("TAG", "onReceive: ", )
        Toast.makeText(p0, "dsfgdsdsfsfsdfdsfsdf", Toast.LENGTH_SHORT).show()

    }
}