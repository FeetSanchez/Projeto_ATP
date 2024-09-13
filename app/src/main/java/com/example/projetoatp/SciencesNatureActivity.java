package com.example.projetoatp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SciencesNatureActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sciences_nature);

        Button buttonBiologia = findViewById(R.id.button_biologia);
        Button buttonQuimica = findViewById(R.id.button_quimica);
        Button buttonFisica = findViewById(R.id.button_fisica);

        buttonBiologia.setOnClickListener(v -> openVideoListActivity("Biologia"));
        buttonQuimica.setOnClickListener(v -> openVideoListActivity("Química"));
        buttonFisica.setOnClickListener(v -> openVideoListActivity("Física"));
    }

    // Método para iniciar a VideoListActivity com a query da disciplina
    private void openVideoListActivity(String query) {
        Intent intent = new Intent(SciencesNatureActivity.this, VideoListActivity.class);
        intent.putExtra("QUERY", query + " questões resolvidas de ensino médio");
        startActivity(intent);
    }
}
