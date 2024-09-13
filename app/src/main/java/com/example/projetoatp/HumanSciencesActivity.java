package com.example.projetoatp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HumanSciencesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human_sciences);

        Button buttonHistoria = findViewById(R.id.button_historia);
        Button buttonGeografia = findViewById(R.id.button_geografia);
        Button buttonFilosofia = findViewById(R.id.button_filosofia);
        Button buttonSociologia = findViewById(R.id.button_sociologia);

        // Define o clique dos botões para direcionar à VideoListActivity com a query correspondente
        buttonHistoria.setOnClickListener(v -> openVideoListActivity("História"));
        buttonGeografia.setOnClickListener(v -> openVideoListActivity("Geografia"));
        buttonFilosofia.setOnClickListener(v -> openVideoListActivity("Filosofia"));
        buttonSociologia.setOnClickListener(v -> openVideoListActivity("Sociologia"));
    }

    // Método para iniciar a VideoListActivity com a query da disciplina
    private void openVideoListActivity(String query) {
        Intent intent = new Intent(HumanSciencesActivity.this, VideoListActivity.class);
        intent.putExtra("QUERY", query + " questões resolvidas de ensino médio");
        startActivity(intent);
    }
}
