package com.example.projetoatp;

import android.app.Activity;
import android.os.Bundle;
import java.io.File;

public class AddFilesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_files);

        File folder = new File("C:\\Projetos e estudos\\Projeto ATP\\Arquivos\\Provas\\*");
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.addFilesFromFolder(folder);
    }
}
