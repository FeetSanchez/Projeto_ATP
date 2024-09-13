package com.example.projetoatp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class ViewProvaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prova);

        Intent intent = getIntent();
        String filePath = intent.getStringExtra("filePath");
        Uri fileUri = Uri.parse("file:///android_asset/" + filePath);

        // You can use a PDF viewer or any other method to view the file
        // For simplicity, we'll open the file using an intent
        Intent viewIntent = new Intent(Intent.ACTION_VIEW);
        viewIntent.setDataAndType(fileUri, "application/pdf");
        viewIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(viewIntent);
    }
}
