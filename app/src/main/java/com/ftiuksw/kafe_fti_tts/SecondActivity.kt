package com.ftiuksw.kafe_fti_tts


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var message = intent.getStringExtra("name")
        HelloMessage_ID.text = message
    }

    fun go2orderActivity(view: View) {
        var intent = Intent(this,OrderActivity::class.java)
        startActivity(intent)
    }

    fun go2aboutActivity(view: View) {
        var intent = Intent(this,AboutActivity::class.java)
        startActivity(intent)
    }

}