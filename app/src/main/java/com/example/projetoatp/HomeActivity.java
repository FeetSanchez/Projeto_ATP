package com.example.projetoatp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonEstudar = findViewById(R.id.button_estudar);
        Button buttonBancoProvas = findViewById(R.id.button_banco_provas);

        buttonEstudar.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, SubjectsActivity.class);
            startActivity(intent);
        });

        buttonBancoProvas.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, BancoProvasActivity.class);
            startActivity(intent);
        });
    }
}
