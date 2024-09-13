package com.example.projetoatp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private VideoAdapter videoAdapter;
    private final List<VideoItem> videoList = new ArrayList<>();
    private String currentQuery = ""; // Inicializa com uma string vazia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuração da RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializa o adaptador com o listener para o clique do item
        videoAdapter = new VideoAdapter(this, videoList, this::onVideoItemClick);
        recyclerView.setAdapter(videoAdapter);

        // Configuração dos ClickListeners dos Botões
        setUpButtonClickListeners();
    }

    private void setUpButtonClickListeners() {
        Button buttonGoToHome = findViewById(R.id.buttonGoToHome);
        buttonGoToHome.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        Button buttonGoToSubjects = findViewById(R.id.buttonGoToSubjects);
        buttonGoToSubjects.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SubjectsActivity.class);
            startActivity(intent);
        });

        Map<Integer, String> buttonQueries = new HashMap<>();
        buttonQueries.put(R.id.buttonPortuguese, "Língua Portuguesa");
        buttonQueries.put(R.id.buttonMath, "Matemática");
        buttonQueries.put(R.id.buttonHistory, "História");
        buttonQueries.put(R.id.buttonGeography, "Geografia");
        buttonQueries.put(R.id.buttonBiology, "Biologia");
        buttonQueries.put(R.id.buttonChemistry, "Química");
        buttonQueries.put(R.id.buttonPhysics, "Física");
        buttonQueries.put(R.id.buttonPE, "Educação Física");
        buttonQueries.put(R.id.buttonEnglish, "Língua Estrangeira (Inglês)");
        buttonQueries.put(R.id.buttonSpanish, "Língua Estrangeira (Espanhol)");
        buttonQueries.put(R.id.buttonArts, "Artes");
        buttonQueries.put(R.id.buttonPhilosophy, "Filosofia");
        buttonQueries.put(R.id.buttonSociology, "Sociologia");

        for (Map.Entry<Integer, String> entry : buttonQueries.entrySet()) {
            Button button = findViewById(entry.getKey());
            String query = entry.getValue();
            button.setOnClickListener(v -> {
                currentQuery = query; // Atualiza a query atual
                fetchVideosFromYouTube();
            });
        }
    }

    // Função para buscar vídeos da API do YouTube
    @SuppressLint("NotifyDataSetChanged")
    private void fetchVideosFromYouTube() {
        new Thread(() -> {
            try {
                YouTube youtubeService = YouTubeService.getService(); // Implementar o YouTubeService para autenticação e configuração da API
                YouTube.Search.List request = youtubeService.search().list("snippet");
                request.setKey("AIzaSyCHjqr0Kfo-e3Y471bP5yIrRwnHrXP_tGw"); // Substitua com a sua chave da API
                request.setQ(currentQuery); // Utilizando currentQuery para a busca
                request.setMaxResults(10L);

                SearchListResponse response = request.execute();
                List<SearchResult> results = response.getItems();

                // Limpar a lista existente e adicionar vídeos novos
                videoList.clear();
                for (SearchResult result : results) {
                    String title = result.getSnippet().getTitle();
                    String thumbnailUrl = result.getSnippet().getThumbnails().getHigh().getUrl();
                    String videoId = result.getId().getVideoId(); // Adiciona o ID do vídeo
                    videoList.add(new VideoItem(title, thumbnailUrl, videoId));
                }

                // Atualizar a RecyclerView na thread principal
                runOnUiThread(() -> videoAdapter.notifyDataSetChanged());

            } catch (Exception e) {
                Log.e("YouTubeAPI", "Erro ao buscar vídeos", e);
            }
        }).start();
    }

    // Método de callback para quando um item de vídeo é clicado
    private void onVideoItemClick(String videoId) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videoId));
        startActivity(intent);
    }
}
