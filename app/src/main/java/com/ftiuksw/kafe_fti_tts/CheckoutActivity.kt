package com.ftiuksw.kafe_fti_tts

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.checkout_activity.*

class CheckoutActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout_activity)

        val id = "done"

        val name = getString(R.string.abc_action_bar_home_description)

        val description = getString(R.string.abc_action_bar_home_description)
        val importance = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(id, name, importance)

        mChannel.description = description
        mChannel.enableLights(true)

        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)

        val CHANNEL_ID = "done"

        // Use NotificationCompat.Builder to add the notification objects
        val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_icon_background)
            .setContentTitle("Order Success")
            .setContentText("Foods will be delivered!")

        val mNotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        mNotificationManager.createNotificationChannel(mChannel)
        mNotificationManager.notify(1, mBuilder.build())
        var message2 = intent.getStringExtra("name")
        TEST.text = message2
    }

    fun go2secondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }