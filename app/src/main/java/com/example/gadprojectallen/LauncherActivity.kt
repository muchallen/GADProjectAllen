package com.example.gadprojectallen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        val handler = Handler()
        val intent = Intent(this,MainActivity::class.java)

        handler.postDelayed({
            startActivity(intent);
        }, 3000)

    }


}