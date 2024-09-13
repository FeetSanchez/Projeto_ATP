package com.example.projetoatp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private final List<VideoItem> videoList = new ArrayList<>();
    private static final String TAG = "VideoListActivity";
    private static final String API_KEY = "AIzaSyCHjqr0Kfo-e3Y471bP5yIrRwnHrXP_tGw"; // Substitua com sua chave da API do YouTube

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new VideoAdapter(this, videoList, this::onVideoItemClick); // Passa o callback
        recyclerView.setAdapter(videoAdapter);

        // Carregar vídeos com base na query selecionada
        String query = getIntent().getStringExtra("QUERY");
        if (query != null && !query.isEmpty()) {
            fetchVideosFromYouTube(query);
        } else {
            Log.e(TAG, "Query is null or empty");
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void fetchVideosFromYouTube(String query) {
        new Thread(() -> {
            try {
                YouTube youtubeService = YouTubeService.getService();
                YouTube.Search.List request = youtubeService.search().list("snippet");
                request.setKey(API_KEY);
                request.setQ(query + " questões resolvidas de ensino médio");
                request.setMaxResults(10L);
                request.setType("video");

                SearchListResponse response = request.execute();
                List<SearchResult> results = response.getItems();

                List<String> videoIds = new ArrayList<>();
                for (SearchResult result : results) {
                    videoIds.add(result.getId().getVideoId());
                }

                // Filtrar os vídeos com base na duração
                filterVideosByDuration(videoIds);

            } catch (Exception e) {
                Log.e(TAG, "Erro ao buscar vídeos", e);
            }
        }).start();
    }

    private void filterVideosByDuration(List<String> videoIds) {
        try {
            YouTube youtubeService = YouTubeService.getService();
            YouTube.Videos.List videoRequest = youtubeService.videos().list("contentDetails,snippet");
            videoRequest.setKey(API_KEY);
            videoRequest.setId(String.join(",", videoIds));

            VideoListResponse videoResponse = videoRequest.execute();
            List<Video> videos = videoResponse.getItems();

            videoList.clear();
            for (Video video : videos) {
                String duration = video.getContentDetails().getDuration();
                if (isDurationWithinLimit(duration)) {
                    String title = video.getSnippet().getTitle();
                    String thumbnailUrl = video.getSnippet().getThumbnails().getHigh().getUrl();
                    String videoId = video.getId();
                    videoList.add(new VideoItem(title, thumbnailUrl, videoId));
                }
            }

            runOnUiThread(() -> videoAdapter.notifyDataSetChanged());

        } catch (Exception e) {
            Log.e(TAG, "Erro ao filtrar vídeos por duração", e);
        }
    }

    private boolean isDurationWithinLimit(String isoDuration) {
        int seconds = convertDurationToSeconds(isoDuration);
        int maxDurationInSeconds = 5 * 60; // 5 minutos em segundos
        return seconds <= maxDurationInSeconds;
    }

    private int convertDurationToSeconds(String isoDuration) {
        int minutes = 0;
        int seconds = 0;

        // Extrai minutos e segundos da duração ISO 8601
        if (isoDuration.contains("PT")) {
            isoDuration = isoDuration.replace("PT", "");
            if (isoDuration.contains("M")) {
                String[] parts = isoDuration.split("M");
                minutes = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
                if (parts.length > 1 && parts[1].contains("S")) {
                    seconds = Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
                }
            } else if (isoDuration.contains("S")) {
                seconds = Integer.parseInt(isoDuration.replaceAll("[^0-9]", ""));
            }
        }

        return (minutes * 60) + seconds;
    }

    private void onVideoItemClick(String videoId) {
        // Cria uma Intent para abrir o aplicativo YouTube
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videoId));
        startActivity(intent);
    }
}
