package com.example.projetoatp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// Adaptador da RecyclerView que conecta os dados dos vídeos à lista
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private final List<VideoItem> videoList; // Lista de vídeos a serem exibidos
    private final Context context; // Contexto para inflar o layout e carregar imagens
    private final OnVideoItemClickListener onVideoItemClickListener; // Adicionado para o callback

    // Interface para o callback do clique no item
    public interface OnVideoItemClickListener {
        void onVideoItemClick(String videoId);
    }

    // Construtor do adaptador que recebe o contexto, a lista de vídeos e o callback
    public VideoAdapter(Context context, List<VideoItem> videoList, OnVideoItemClickListener onVideoItemClickListener) {
        this.context = context;
        this.videoList = videoList;
        this.onVideoItemClickListener = onVideoItemClickListener; // Inicializa o callback
    }

    // Método responsável por inflar o layout de cada item da RecyclerView
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do item de vídeo
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    // Método que vincula os dados do vídeo ao ViewHolder
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        // Obtém o item de vídeo atual
        VideoItem video = videoList.get(position);
        // Define o título do vídeo no TextView
        holder.videoTitle.setText(video.title);
        holder.itemView.setOnClickListener(v -> {
            if (onVideoItemClickListener != null) {
                onVideoItemClickListener.onVideoItemClick(video.videoId); // Chama o callback
            }
        });
        // Usa a biblioteca Glide para carregar a imagem da miniatura no ImageView
        Glide.with(context).load(video.thumbnailUrl).into(holder.videoThumbnail);
    }

    // Retorna o número total de itens na lista
    @Override
    public int getItemCount() {
        return videoList.size();
    }

    // Classe interna que representa o ViewHolder, armazenando as referências dos componentes do layout de item
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView videoThumbnail; // Imagem da miniatura do vídeo
        TextView videoTitle; // Título do vídeo

        // Construtor que mapeia as views do layout de item
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoThumbnail = itemView.findViewById(R.id.videoThumbnail);
            videoTitle = itemView.findViewById(R.id.videoTitle);
        }
    }
}
