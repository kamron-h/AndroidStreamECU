package com.example.android_stream_ecu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.android_stream_ecu.models.Movie;
import com.example.android_stream_ecu.VideoSubmission; // Adjust the package name as necessary

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VideoSubmission extends AppCompatActivity {

    private EditText editTextTitle, editTextThumbnailUrl, editTextVideoUrl, editTextBroadcaster, editTextDate, editTextDescription;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_submission);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextThumbnailUrl = findViewById(R.id.editTextThumbnailUrl);
        editTextVideoUrl = findViewById(R.id.editTextVideoUrl);
        editTextBroadcaster = findViewById(R.id.editTextBroadcaster);
        editTextDate = findViewById(R.id.editTextDate);
        editTextDescription = findViewById(R.id.editTextDescription);

        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> submitVideo());
    }

    private void submitVideo() {
        String title = editTextTitle.getText().toString();
        String thumbnailUrl = editTextThumbnailUrl.getText().toString();
        String videoUrl = editTextVideoUrl.getText().toString();
        String date = editTextDate.getText().toString();
        String description = editTextDescription.getText().toString();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            // Handle the case where there is no authenticated user
            Toast.makeText(this, "No authenticated user. Please log in.", Toast.LENGTH_LONG).show();
            return;
        }

        String broadcaster = currentUser.getDisplayName(); // or currentUser.getEmail();

        // Simple validation
        if (title.isEmpty() || thumbnailUrl.isEmpty() || videoUrl.isEmpty() || broadcaster.isEmpty() || date.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setThumbnailUrl(thumbnailUrl);
        movie.setVideoUrl(videoUrl);
        movie.setBroadcaster(broadcaster);
        movie.setDate(date);
        movie.setDescription(description);

        db.collection("movies").add(movie)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(VideoSubmission.this, "Video submitted successfully", Toast.LENGTH_SHORT).show();
                    // Optionally, clear the fields or navigate back to MainActivity
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(VideoSubmission.this, "Error submitting video: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
