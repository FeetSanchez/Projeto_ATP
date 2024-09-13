package com.example.projetoatp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class DisplayFilesActivity extends Activity {

    private ListView listView;
    private DatabaseHelper dbHelper;
    private ArrayList<String> fileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_files);

        listView = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);
        fileList = new ArrayList<>();

        loadFilesFromDatabase();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fileList);
        listView.setAdapter(adapter);
    }

    private void loadFilesFromDatabase() {
        Cursor cursor = dbHelper.getReadableDatabase().query("provas", new String[]{"nome"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                fileList.add(nome);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
