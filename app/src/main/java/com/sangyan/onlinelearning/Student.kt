package com.sangyan.onlinelearning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
    }

    fun VideoLectures(view: View) {
         startActivity(Intent(this,VideoLectures::class.java))
    }
    fun JoinClass(view: View) {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://meet.google.com/kyn-vsyt-dqw"))
        startActivity(intent)
    }

    fun Notes(view: View) {
        startActivity(Intent(this,Notes::class.java))
    }
}