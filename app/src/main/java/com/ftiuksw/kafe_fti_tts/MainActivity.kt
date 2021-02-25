package com.ftiuksw.kafe_fti_tts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun go2secondActivity(view: View) {
        var intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("name",FirstName_ID.text.toString())
        startActivity(intent)
    }

    fun go2signupActivity(view: View) {
        var intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }
}