package com.reecedonovan.opendayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class videoActivity extends AppCompatActivity {

    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mediaC = new MediaController(this);

        // Setting the two buttons that I will use. Button5 and button6
        Button button3 = (Button) findViewById(R.id.btn3);
        Button button4 = (Button) findViewById(R.id.btn4);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // This is finding the video path to videoView
                VideoView videoView = (VideoView) findViewById(R.id.videoView);
                videoView.setVisibility(View.VISIBLE);
                // This locating where the video file is being stored and the name of the video clip
                String videoPath = "android.resource://com.reecedonovan.opendayapp/" + R.raw.class_vid;
                Uri uri = Uri.parse(videoPath);
                videoView.setVideoURI(uri);
                // This is setting the multimidea device on the video clip
                videoView.setMediaController(mediaC);
                mediaC.setAnchorView(videoView);
                // This is to start the video
                videoView.start();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You initilize the videoView
                VideoView videoView = (VideoView) findViewById(R.id.videoView);
                videoView.setVisibility(View.INVISIBLE);
                // If the stop is pressed the video will stop
                videoView.stopPlayback();
            }
        });



    }
}
