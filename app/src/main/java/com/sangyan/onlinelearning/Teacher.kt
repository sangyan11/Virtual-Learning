package com.sangyan.onlinelearning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class Teacher : AppCompatActivity() {
    val uriTxt: TextView? = null
    val PDF: Int = 0
    val Video: Int = 1

    lateinit var uri: Uri
    lateinit var mStorage: StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        val upload_pdf = findViewById<Button>(R.id.upload_notes)
        val upload_video = findViewById<Button>(R.id.videoUpload)
        mStorage = FirebaseStorage.getInstance().getReference("Uploads")
        upload_video.setOnClickListener{
            val intent = Intent()
            intent.setType ("video/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select Video"), Video)
        }


        upload_pdf.setOnClickListener{
            val intent = Intent()
            intent.setType("pdf/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select PDF"), PDF)
        }
        
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val uriTxt = findViewById<View>(R.id.uriTxt) as TextView
        if (resultCode == RESULT_OK) {
            if (requestCode == PDF) {
                uri = data!!.data!!
                uriTxt.text = uri.toString()
                uploadNotes()
            }
         else if (requestCode == Video) {
            uri = data!!.data!!
            uriTxt.text = uri.toString()
            uploadNotes()
        }
    }

        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun uploadNotes() {
        var mReference = uri.lastPathSegment?.let { mStorage.child(it) }
        try {
            mReference?.putFile(uri)!!
                .addOnSuccessListener { taskSnapshot: UploadTask.TaskSnapshot? ->
                    var url = taskSnapshot!!
                    val dwnTxt = findViewById<View>(R.id.dwnTxt) as TextView
                    dwnTxt.text = url.toString()
                    Toast.makeText(this, "Successfully Uploaded :)", Toast.LENGTH_LONG).show()
                }
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }
    }

    fun OnlineClass(view: View) {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://meet.google.com/kyn-vsyt-dqw"))
        startActivity(intent)
    }
}