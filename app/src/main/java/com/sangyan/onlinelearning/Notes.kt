package com.sangyan.onlinelearning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Notes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }

    fun Dbms(view: View) {

        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/online-learning-ea8c0.appspot.com/o/Uploads%2Fdbms_tutorial%20(1).pdf?alt=media&token=7e8a8500-5c94-4b03-a088-3b071d8b35e1"))
        startActivity(intent)
    }
    fun SqlNotes(view: View) {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/online-learning-ea8c0.appspot.com/o/Uploads%2FSQLNotesForProfessionals(1).pdf?alt=media&token=118e706a-fcb6-4c00-8ff9-6057813f41ef"))
        startActivity(intent)
    }
}