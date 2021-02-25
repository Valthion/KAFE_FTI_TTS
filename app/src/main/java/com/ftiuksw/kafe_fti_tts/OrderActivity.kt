package com.ftiuksw.kafe_fti_tts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.order_activity.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_activity)
        val mieet = findViewById<EditText>(R.id.angkamie)
        val baksoet = findViewById<EditText>(R.id.angkabakso)
        val tehet = findViewById<EditText>(R.id.angkateh)
        val kopiet = findViewById<EditText>(R.id.angkakopi)
        val rokoket = findViewById<EditText>(R.id.angkarokok)
        val address = findViewById<EditText>(R.id.address)
        val phone = findViewById<EditText>(R.id.phone)
        val notes = findViewById<EditText>(R.id.notes)
        val chkbtn = findViewById<Button>(R.id.chkbtn)


        chkbtn.setOnClickListener {
            val mie = mieet.text.toString()
            val bakso = baksoet.text.toString()
            val teh = tehet.text.toString()
            val kopi = kopiet.text.toString()
            val rokok = rokoket.text.toString()
            val add = address.text.toString()
            val ph = phone.text.toString()
            val nt = notes.text.toString()

            llProgressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this,CheckoutActivity::class.java)
                intent.putExtra("mie", mie)
                intent.putExtra("bakso", bakso)
                intent.putExtra("teh", teh)
                intent.putExtra("kopi", kopi)
                intent.putExtra("rokok", rokok)

                intent.putExtra("address", add)
                intent.putExtra("phone", ph)
                intent.putExtra("notes", nt)
                startActivity(intent) }, 1000)
        }
        }

    }