package com.example.pushtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.nio.file.Files.size
import com.google.firebase.messaging.RemoteMessage



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


fun onMessageReceived(remoteMessage: RemoteMessage) {
    // ...

    // TODO(developer): Handle FCM messages here.
    // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
    Log.d(TAG, "From: " + remoteMessage.from!!)

    // Check if message contains a data payload.
    if (remoteMessage.data.size > 0) {
        Log.d(TAG, "Message data payload: " + remoteMessage.data)

        if (/* Check if data needs to be processed by long running job */ true) {
            // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
            scheduleJob()
        } else {
            // Handle message within 10 seconds
            handleNow()
        }

    }

    // Check if message contains a notification payload.
    if (remoteMessage.notification != null) {
        Log.d(TAG, "Message Notification Body: " + remoteMessage.notification!!.body!!)
    }

    // Also if you intend on generating your own notifications as a result of a received FCM
    // message, here is where that should be initiated. See sendNotification method below.
}