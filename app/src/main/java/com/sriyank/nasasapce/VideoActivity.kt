package com.sriyank.nasasapce

import android.net.Uri
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_profile.*

class VideoActivity : AppCompatActivity() {

    // declaring a null variable for VideoView
    var simpleVideoView: VideoView? = null

    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        simpleVideoView = findViewById<View>(R.id.videoView) as VideoView

        if (mediaControls == null) {
            // creating an object of media controller class
            mediaControls = MediaController(this@VideoActivity)

            // set the anchor view for the video view
            mediaControls!!.setAnchorView(this.simpleVideoView)
        }

        // set the media controller for video view
        simpleVideoView!!.setMediaController(mediaControls)

        Log.d("tag","${intent.getStringExtra("videoName")}")

        // set the absolute path of the video file which is going to be played
        when (intent.getStringExtra("link")) {
            "Semsem" -> {
                simpleVideoView!!.setVideoURI(
                Uri.parse("android.resource://"
                        + packageName + "/" + R.raw.semssem)
            )}
            "Doctor" -> {
                simpleVideoView!!.setVideoURI(
                    Uri.parse("android.resource://"
                            + packageName + "/" + R.raw.doc)
                )
            }
            "Rosa" -> {
                simpleVideoView!!.setVideoURI(
                    Uri.parse("android.resource://"
                            + packageName + "/" + R.raw.rose)
                )
            }
            else -> {
                simpleVideoView!!.setVideoURI(
                    Uri.parse("android.resource://"
                            + packageName + "/" + R.raw.daboor)
                )
            }
        }


        simpleVideoView!!.requestFocus()

        // starting the video
        simpleVideoView!!.start()

        // display a toast message
        // after the video is completed
        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video completed",
                Toast.LENGTH_LONG).show()
        }

        // display a toast message if any
        // error occurs while playing the video
        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }

    }
}