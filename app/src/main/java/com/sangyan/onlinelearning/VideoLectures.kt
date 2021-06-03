package com.sangyan.onlinelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VideoLectures : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_lectures)
        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/online-learning-ea8c0.appspot.com/o/1.%20Skeleton%20of%20C%2B%2B%20Program.mp4?alt=media&token=25274310-ef52-4e47-b425-01376e4c1f08"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/online-learning-ea8c0.appspot.com/o/4.%20(Challenge)%20Writing%20a%20C%20program%20that%20displays%20your%20nam"
         var item = ArrayList<Lesson>()
        var recyler_view = findViewById<RecyclerView>(R.id.videos_list)
        item.add(Lesson("C++","Abdul Bari",lesson1))
        item.add(Lesson("Arrays","GFG",lesson2))

      var adapter = Adapter(item,applicationContext)
        recyler_view.layoutManager=LinearLayoutManager(applicationContext)
        recyler_view.adapter=adapter

    }
}