package com.sangyan.onlinelearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Student(view: View) {
        var intent = Intent(this,Student::class.java)
        startActivity(intent)
    }

    fun Teacher(view: View) {

        var intent = Intent(this,Teacher::class.java)
        startActivity(intent)

    }
}