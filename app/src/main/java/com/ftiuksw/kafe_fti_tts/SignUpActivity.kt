package com.ftiuksw.kafe_fti_tts

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.signup_activity.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun go2secondActivity(view: View) {
        val UpdateAlert= AlertDialog.Builder(this)

        UpdateAlert.setTitle("Create Account")
        UpdateAlert.setMessage("Are you sure you want to save changes?")

        UpdateAlert.setPositiveButton("Yes") {
                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Created",
            Toast.LENGTH_LONG).show()
            val id = "create"

            val name = getString(R.string.abc_action_bar_home_description)

            val description = getString(R.string.abc_action_bar_home_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(id, name, importance)

            mChannel.description = description
            mChannel.enableLights(true)

            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)

            val CHANNEL_ID = "create"

            // Use NotificationCompat.Builder to add the notification objects
            val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon_background)
                .setContentTitle("Account Creation")
                .setContentText("Account has been created!")

            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            mNotificationManager.createNotificationChannel(mChannel)
            mNotificationManager.notify(1, mBuilder.build())

            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("name",FirstName_ID.text.toString())
            startActivity(intent)
        }
        UpdateAlert.setNegativeButton("No") {
                dialogInterface: DialogInterface?, which: Int -> Toast.makeText(applicationContext,"Canceled",
            Toast.LENGTH_LONG).show()
        }

        UpdateAlert.show()
    }

}