package com.example.android_stream_ecu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import java.util.ArrayList;
import com.example.android_stream_ecu.adapters.MovieAdapter;
import com.example.android_stream_ecu.models.Movie;

//Firebase imports
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private FloatingActionButton addButton;
    private Button register_login_btn;
    private FirebaseFirestore db;
    private FirebaseAuth firebaseAuth;
    private List<Movie> movieList = new ArrayList<>();
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        addButton = findViewById(R.id.addButton);
        register_login_btn = findViewById(R.id.action_register_login);

        // Connect Firebase API
        db = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        adapter = new MovieAdapter(this, movieList);
        gridView.setAdapter(adapter);

        fetchMovies();

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Movie selectedMovie = movieList.get(position);
            Intent intent = new Intent(MainActivity.this, MovieItem.class); // Assuming VideoDetailActivity is the detail view
            intent.putExtra("title", selectedMovie.getTitle());
            intent.putExtra("description", selectedMovie.getDescription());
            intent.putExtra("videoUrl", selectedMovie.getVideoUrl());
            intent.putExtra("date", selectedMovie.getDate());
            intent.putExtra("thumbnailUrl", selectedMovie.getThumbnailUrl());
            startActivity(intent);
        });

        register_login_btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Register_Login.class); // Replace with your actual Login/Register activity class name
            startActivity(intent);
        });

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VideoSubmission.class); // Replace with your actual Video Submission activity class name
            startActivity(intent);
        });

        updateButtonVisibility();
    }

    private void updateButtonVisibility() {
        if (firebaseAuth.getCurrentUser() != null) {
            addButton.setVisibility(View.VISIBLE);
            register_login_btn.setVisibility(View.GONE);
        } else {
            addButton.setVisibility(View.GONE);
            register_login_btn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateButtonVisibility();
    }

    private void fetchMovies() {
        db.collection("movies")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        movieList.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Movie movie = document.toObject(Movie.class);
                            movieList.add(movie);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
