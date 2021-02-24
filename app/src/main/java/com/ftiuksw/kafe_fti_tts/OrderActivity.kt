package com.ftiuksw.kafe_fti_tts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.order_activity.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_activity)
    }

    fun order(view: View) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("Order")
        val dialogLayout = inflater.inflate(R.layout.alert_dialog, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") {
                dialogInterface, i -> Toast.makeText(applicationContext, "Food Ordered: " + editText.text.toString(), Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    fun go2Checkout(view: View) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("Address")
        val dialogLayout = inflater.inflate(R.layout.alert_dialog, null)
        dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") {
                dialogInterface, i -> Toast.makeText(applicationContext, "Address Assigned!", Toast.LENGTH_SHORT).show()
                llProgressBar.visibility = View.VISIBLE
                Handler(Looper.getMainLooper()).postDelayed({
                    var intent = Intent(this,CheckoutActivity::class.java)
                    startActivity(intent)
            }, 1000)
        }
        builder.show()
    }
}