package com.example.projetoatp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MathematicsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics);

        // Encontre o botão que representará Matemática
        Button buttonMatematica = findViewById(R.id.button_matematica);

        // Configura o clique do botão para abrir a VideoListActivity com uma query de Matemática
        buttonMatematica.setOnClickListener(v -> openVideoListActivity("Matemática"));
    }

    // Método para iniciar a VideoListActivity com a query da disciplina Matemática
    private void openVideoListActivity(String query) {
        Intent intent = new Intent(MathematicsActivity.this, VideoListActivity.class);
        intent.putExtra("QUERY", query + " questões resolvidas de ensino médio");
        startActivity(intent);
    }
}
