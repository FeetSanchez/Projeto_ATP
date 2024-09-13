package com.example.projetoatp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SubjectsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        Button buttonCienciasNatureza = findViewById(R.id.button_ciencias_natureza);
        Button buttonCienciasHumanas = findViewById(R.id.button_ciencias_humanas);
        Button buttonLinguagens = findViewById(R.id.button_linguagens);
        Button buttonMatematica = findViewById(R.id.button_matematica);

        buttonCienciasNatureza.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectsActivity.this, SciencesNatureActivity.class);
            startActivity(intent);
        });

        buttonCienciasHumanas.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectsActivity.this, HumanSciencesActivity.class);
            startActivity(intent);
        });

        buttonLinguagens.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectsActivity.this, LanguagesActivity.class);
            startActivity(intent);
        });

        buttonMatematica.setOnClickListener(v -> {
            Intent intent = new Intent(SubjectsActivity.this, MathematicsActivity.class);
            startActivity(intent);
        });
    }
}
