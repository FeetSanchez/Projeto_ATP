package com.example.projetoatp;

import com.example.projetoatp.VideoItem;

import java.util.ArrayList;
import java.util.List;

// Classe responsável por filtrar vídeos de acordo com critérios específicos
public class VideoFilter {

    // Método para filtrar vídeos de até 5 minutos e relacionados ao tema "questões resolvidas"
    public List<VideoItem> filterVideos(List<VideoItem> allVideos) {
        List<VideoItem> filteredVideos = new ArrayList<>();

        for (VideoItem video : allVideos) {
            // Converte a duração do vídeo para segundos
            int videoDurationInSeconds = convertDurationToSeconds(video.getDuration());
            int maxDurationInSeconds = 10 * 60; // 5 minutos em segundos

            // Verifica se o vídeo atende aos critérios: duração <= 5 minutos e contém "questões resolvidas"
            if (videoDurationInSeconds <= maxDurationInSeconds &&
                    video.getTitle().toLowerCase().contains("questões resolvidas de ensino médio")) {
                filteredVideos.add(video);
            }
        }

        return filteredVideos;
    }

    // Método para converter a duração no formato ISO 8601 para segundos
    private int convertDurationToSeconds(String isoDuration) {
        int minutes = 0;
        int seconds = 0;

        // Verifica a presença de minutos e segundos na duração
        if (isoDuration.contains("M")) {
            String[] parts = isoDuration.split("M");
            minutes = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
            if (parts.length > 1 && parts[1].contains("S")) {
                seconds = Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
            }
        } else if (isoDuration.contains("S")) {
            seconds = Integer.parseInt(isoDuration.replaceAll("[^0-9]", ""));
        }

        return (minutes * 60) + seconds;
    }
}
