package com.example.projetoatp;

// Classe para representar um item de vídeo
public class VideoItem {
    public String title;
    public String thumbnailUrl;
    public String videoId; // ID do vídeo para reprodução
    public String duration; // Duração do vídeo no formato legível
    public String description; // Descrição do vídeo (opcional)

    // Construtor para inicializar os atributos do item de vídeo
    public VideoItem(String title, String thumbnailUrl, String videoId, String duration, String description) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.videoId = videoId;
        this.duration = duration;
        this.description = description;
    }

    // Construtor simplificado se precisar apenas de título e miniatura
    public VideoItem(String title, String thumbnailUrl) {
        this(title, thumbnailUrl, null, null, null);
    }

    // Construtor com título, miniatura e ID do vídeo
    public VideoItem(String title, String thumbnailUrl, String videoId) {
        this(title, thumbnailUrl, videoId, null, null);
    }

    // Getters e Setters podem ser adicionados conforme necessidade para manipulação dos atributos
    public String getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }
}
