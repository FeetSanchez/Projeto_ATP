package com.example.projetoatp;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;

import java.io.IOException;

public class YouTubeService {

    // Chave de API - insira a sua chave de API do YouTube
    private static final String API_KEY = "AIzaSyCQRCalHbejh53XXaXEHce7jTv1dUqTZ_g";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    // Método para obter o serviço do YouTube configurado com a chave de API
    public static YouTube getService() throws IOException {
        // Criar um transport HTTP
        final NetHttpTransport httpTransport = new NetHttpTransport();

        // Inicializa o serviço do YouTube
        return new YouTube.Builder(httpTransport, JSON_FACTORY, (HttpRequestInitializer) request -> {
        })
                .setApplicationName("YouTube Data API Client")
                .build();
    }
}
