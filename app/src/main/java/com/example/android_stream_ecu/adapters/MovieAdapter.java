package com.example.android_stream_ecu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_stream_ecu.models.Movie;
import com.squareup.picasso.Picasso;
import java.util.List;

import com.example.android_stream_ecu.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Getter and setter for broadcaster

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_movie_item, parent, false);
        }
//        TextView thumbnail_url = convertView.findViewById(R.id.thumbnail_url);
        TextView title = convertView.findViewById(R.id.textViewTitle);
        TextView broadcaster = convertView.findViewById(R.id.broadcaster);
        TextView date = convertView.findViewById(R.id.date);
        TextView description = convertView.findViewById(R.id.textViewDescription);

        Movie movie = movieList.get(position);
        title.setText(movie.getTitle());
        broadcaster.setText(movie.getBroadcaster());
        date.setText(movie.getDate());
        description.setText(movie.getDescription());
//        Picasso.get().load(movie.getThumbnailUrl()).into(thumbnail);

        return convertView;
    }
}
