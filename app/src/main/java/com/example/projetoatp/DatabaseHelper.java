package com.example.projetoatp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import java.io.File;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "provas.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PROVAS_TABLE = "CREATE TABLE provas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, caminho_arquivo TEXT NOT NULL)";
        db.execSQL(CREATE_PROVAS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS provas");
        onCreate(db);
    }

    public void addFilesFromFolder(File folder) {
        SQLiteDatabase db = this.getWritableDatabase();
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                ContentValues values = new ContentValues();
                values.put("nome", file.getName());
                values.put("caminho_arquivo", file.getAbsolutePath());
                db.insert("provas", null, values);
            }
        }
    }
}
