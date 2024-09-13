package com.example.projetoatp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BancoProvasActivity extends AppCompatActivity {

    private ListView listViewProvas;
    private List<String> provasList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private String currentFolder = "provas"; // Start with the root folder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_provas);

        // Inicializa o ListView e o ArrayAdapter
        listViewProvas = findViewById(R.id.listViewProvas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, provasList);
        listViewProvas.setAdapter(adapter);

        // Carrega os arquivos e pastas do diretório inicial
        loadProvasFromAssets(currentFolder);

        // Configura o listener de clique para os itens do ListView
        listViewProvas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = provasList.get(position);
                String newFolder = currentFolder + "/" + selectedItem;

                try {
                    // Verifica se o item selecionado é um diretório
                    String[] files = getAssets().list(newFolder);
                    if (files != null) {
                        // Se for um diretório, atualiza a pasta atual e recarrega os itens
                        currentFolder = newFolder;
                        loadProvasFromAssets(currentFolder);
                    } else {
                        // Se for um arquivo PDF, abre com um aplicativo externo
                        openPdfFile(newFolder);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void loadProvasFromAssets(String folder) {
        AssetManager assetManager = getAssets();
        provasList.clear();
        try {
            // Lista os arquivos e pastas no diretório atual
            String[] filesAndFolders = assetManager.list(folder);
            if (filesAndFolders != null) {
                for (String fileOrFolder : filesAndFolders) {
                    provasList.add(fileOrFolder);
                }
                adapter.notifyDataSetChanged();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openPdfFile(String filePath) {
        try {
            // Cria um arquivo temporário para o PDF
            File file = new File(getCacheDir(), filePath);
            InputStream inputStream = getAssets().open(filePath);
            FileOutputStream outputStream = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();

            // Abre o arquivo PDF com um aplicativo externo
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
