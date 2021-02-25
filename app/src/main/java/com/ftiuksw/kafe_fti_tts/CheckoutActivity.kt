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
import kotlinx.android.synthetic.main.order_activity.*
import java.util.Collections.list
import kotlin.system.exitProcess

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
        val intent = intent

        val mie = intent.getStringExtra("mie")
        val bakso = intent.getStringExtra("bakso")
        val teh = intent.getStringExtra("teh")
        val kopi = intent.getStringExtra("kopi")
        val rokok = intent.getStringExtra("rokok")
        val add = intent.getStringExtra("address")
        val pho = intent.getStringExtra("phone")
        val not = intent.getStringExtra("notes")

        val mie1 : Int? = mie?.toIntOrNull()?.times(8000)
        val bakso1 : Int? = bakso?.toIntOrNull()?.times(10000)
        val teh1 : Int? = teh?.toIntOrNull()?.times(2000)
        val kopi1 : Int? = kopi?.toIntOrNull()?.times(2500)
        val rokok1 : Int? = rokok?.toIntOrNull()?.times(10000)

        val total : List<Int> = listOfNotNull(mie1, bakso1, teh1, kopi1, rokok1)
        total.sum()

        val display = findViewById<TextView>(R.id.TEXTBOX)
        display.text = "Mie Ayam \nBakso \nTeh \nKopi \nRokok "

        val display2 = findViewById<TextView>(R.id.TEXTBOX2)
        display2.text = " "+ mie +" = " + mie1 + "\n " + bakso + " = " + bakso1 + "\n " + teh + " = " + teh1 + "\n " + kopi + " = " + kopi1 + "\n " + rokok + " = " + rokok1

        val display3 = findViewById<TextView>(R.id.TEXTBOX3)
        display3.text = "Subtotal =  " + total.sum() + "\nAddress: " + add + "\nPhone: " + pho + "\nNotes: " + not

    }

    fun quitApp(view: View) {
        this.finishAffinity()
        exitProcess(0)
    }
}