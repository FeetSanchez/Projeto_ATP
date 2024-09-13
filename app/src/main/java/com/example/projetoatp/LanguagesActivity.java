package com.example.projetoatp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LanguagesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        Button buttonPortugues = findViewById(R.id.button_portugues);
        Button buttonLiteratura = findViewById(R.id.button_literatura);
        Button buttonLinguaEstrangeira = findViewById(R.id.button_lingua_estrangeira);
        Button buttonArtes = findViewById(R.id.button_artes);
        Button buttonEducacaoFisica = findViewById(R.id.button_educacao_fisica);
        Button buttonTecnologias = findViewById(R.id.button_tecnologias_informacao);

        // Define o clique dos botões para direcionar à VideoListActivity com a query correspondente
        buttonPortugues.setOnClickListener(v -> openVideoListActivity("Português"));
        buttonLiteratura.setOnClickListener(v -> openVideoListActivity("Literatura"));
        buttonLinguaEstrangeira.setOnClickListener(v -> openVideoListActivity("Língua Estrangeira"));
        buttonArtes.setOnClickListener(v -> openVideoListActivity("Artes"));
        buttonEducacaoFisica.setOnClickListener(v -> openVideoListActivity("Educação Física"));
        buttonTecnologias.setOnClickListener(v -> openVideoListActivity("Tecnologias da Informação e Comunicação"));
    }

    // Método para iniciar a VideoListActivity com a query da disciplina
    private void openVideoListActivity(String query) {
        Intent intent = new Intent(LanguagesActivity.this, VideoListActivity.class);
        intent.putExtra("QUERY", query + " questões resolvidas de ensino médio");
        startActivity(intent);
    }
}
