//package com.example.projetoatp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//public class YouTubePlayerActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {
//
//    private static final String TAG = "YouTubePlayerActivity";
//    private static final String API_KEY = "AIzaSyCHjqr0Kfo-e3Y471bP5yIrRwnHrXP_tGw"; // Substitua com a sua chave da API
//    public static final String VIDEO_ID_KEY = "VIDEO_ID";
//
//    private YouTubePlayerView youTubePlayerView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_youtube_player);
//
//        youTubePlayerView = findViewById(R.id.youtube_player_view);
//        youTubePlayerView.initialize(API_KEY, this);
//    }
//
//    @Override
//    public void onInitializationSuccess(@NonNull YouTubePlayer.Provider provider, @NonNull YouTubePlayer youTubePlayer, boolean wasRestored) {
//        Intent intent = getIntent();
//        String videoId = intent.getStringExtra(VIDEO_ID_KEY);
//
//        if (videoId != null && !videoId.isEmpty()) {
//            if (!wasRestored) {
//                youTubePlayer.cueVideo(videoId); // Cues the video to play
//            }
//        } else {
//            Log.e(TAG, "Video ID is null or empty");
//            Toast.makeText(this, "Error: Video ID is missing", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onInitializationFailure(@NonNull YouTubePlayer.Provider provider, @NonNull YouTubeInitializationResult error) {
//        Log.e(TAG, "Error initializing YouTube player: " + error.toString());
//        Toast.makeText(this, "Error initializing YouTube player", Toast.LENGTH_LONG).show();
//    }
//}
