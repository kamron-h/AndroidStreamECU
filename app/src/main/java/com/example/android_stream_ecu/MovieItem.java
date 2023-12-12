package com.example.android_stream_ecu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.TextView;

public class MovieItem extends AppCompatActivity {

    private VideoView videoView;
    private TextView textViewTitle, textViewDescription;
    // Add fields for like/dislike if needed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_item);

        videoView = findViewById(R.id.videoView);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewDescription = findViewById(R.id.textViewDescription);
        // Initialize like/dislike

        // Get the data passed from the previous activity
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String videoUrl = getIntent().getStringExtra("videoUrl");
        // Set the data to the views
        textViewTitle.setText(title);
        textViewDescription.setText(description);

        // Set up the video player
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoPath(videoUrl);
        videoView.start();

        // Set up like/dislike button listeners and functionality
    }
}

