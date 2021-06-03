package com.sangyan.onlinelearning

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import tcking.github.com.giraffeplayer2.VideoView

class Adapter(data: ArrayList<Lesson>, internal var context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    internal var data: List<Lesson>



    init {
        this.data=data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_xml, parent, false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoItem = data[position]
        holder.title.text=videoItem.title
        holder.desc.text=videoItem.description
        holder.video.setVideoPath(videoItem.Video_URL)
        holder.download.setOnClickListener {
            var download= context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var videoUri = Uri.parse(videoItem.Video_URL)
            var getVideo = DownloadManager.Request(videoUri)
            getVideo.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(getVideo)
            Toast.makeText(context,"Download Started",Toast.LENGTH_LONG).show()
        }











    }



    override fun getItemCount(): Int {
        return data.size
    }




      class ViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView)
      {


         val title: TextView
         val desc: TextView
        var video: VideoView
        var download: Button


        init{
            title=itemView.findViewById(R.id.video_title)
            desc=itemView.findViewById(R.id.video_description)
            video=itemView.findViewById(R.id.lesson_video)
            download=itemView.findViewById(R.id.button)




        }



    }







}