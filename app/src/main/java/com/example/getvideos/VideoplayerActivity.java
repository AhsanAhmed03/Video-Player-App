package com.example.getvideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoplayerActivity extends AppCompatActivity {

    VideoView videoView;

    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);

        String video_path = getIntent().getStringExtra("videoPath");

        videoView = findViewById(R.id.video_view);

        mediaController = new MediaController(VideoplayerActivity.this);

        videoView.setVideoPath(video_path);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();
    }
}