/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.awt.Desktop;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelaProvas extends JFrame {
    private JPanel tela;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private RoundedButton btnENEM2009;
    private RoundedButton btnGabarito2009;
    private RoundedButton btnENEM2010;
    private RoundedButton btnGabarito2010;
    private RoundedButton btnENEM2011;
    private RoundedButton btnGabarito2011;
    private RoundedButton btnENEM2012;
    private RoundedButton btnGabarito2012;
    private RoundedButton btnENEM2013;
    private RoundedButton btnGabarito2013;
    private RoundedButton btnENEM2014;
    private RoundedButton btnGabarito2014;
    private RoundedButton btnENEM2015;
    private RoundedButton btnGabarito2015;
    private RoundedButton btnENEM2016;
    private RoundedButton btnGabarito2016;
    private RoundedButton btnENEM2017;
    private RoundedButton btnGabarito2017;
    private RoundedButton btnENEM2018;
    private RoundedButton btnGabarito2018;
    private RoundedButton btnENEM2019;
    private RoundedButton btnGabarito2019;
    private RoundedButton btnENEM2020;
    private RoundedButton btnGabarito2020;
    private RoundedButton btnENEM2021;
    private RoundedButton btnGabarito2021;
    private RoundedButton btnENEM2022;
    private RoundedButton btnGabarito2022;
    private RoundedButton btnENEM2023;
    private RoundedButton btnGabarito2023;
    private RoundedButton btnRetornar;

    public TelaProvas() {
        // Configurações iniciais da janela
        setTitle("ESTUDAR");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(true);
        setLayout(new BorderLayout());

        // Alteração aqui: Definindo a cor de fundo como azul marinho
        tela = new JPanel();
        tela.setBackground(new Color(0, 0, 128)); // Azul marinho
        tela.setLayout(new BorderLayout());

        buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(0, 0, 128)); 
         // Tornar o painel transparente para mostrar a cor de fundo

        scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tela.add(scrollPane, BorderLayout.CENTER);
        add(tela, BorderLayout.CENTER);

        // Criação dos botões
        btnENEM2009 = new RoundedButton("ENEM 2009", 15);
        btnENEM2009.setBackground(new Color(0, 191, 255));
        btnENEM2009.setForeground(Color.WHITE);
        btnENEM2009.addActionListener(evt -> {
            btnENEM2009ActionPerformed();
        });

        btnGabarito2009 = new RoundedButton("GABARITO", 15);
        btnGabarito2009.setBackground(new Color(50, 205, 50));
        btnGabarito2009.setForeground(Color.WHITE);
        btnGabarito2009.addActionListener(evt -> btnGabarito2009ActionPerformed());

        btnENEM2010 = new RoundedButton("ENEM 2010", 15);
        btnENEM2010.setBackground(new Color(0, 191, 255));
        btnENEM2010.setForeground(Color.WHITE);
        btnENEM2010.addActionListener(evt -> btnENEM2010ActionPerformed());

        btnGabarito2010 = new RoundedButton("GABARITO", 15);
        btnGabarito2010.setBackground(new Color(50, 205, 50));
        btnGabarito2010.setForeground(Color.WHITE);
        btnGabarito2010.addActionListener(evt -> btnGabarito2010ActionPerformed());

        btnENEM2011 = new RoundedButton("ENEM 2011", 15);
        btnENEM2011.setBackground(new Color(0, 191, 255));
        btnENEM2011.setForeground(Color.WHITE);
        btnENEM2011.addActionListener(evt -> btnENEM2011ActionPerformed());

        btnGabarito2011 = new RoundedButton("GABARITO", 15);
        btnGabarito2011.setBackground(new Color(50, 205, 50));
        btnGabarito2011.setForeground(Color.WHITE);
        btnGabarito2011.addActionListener(evt -> btnGabarito2011ActionPerformed());

        btnENEM2012 = new RoundedButton("ENEM 2012", 15);
        btnENEM2012.setBackground(new Color(0, 191, 255));
        btnENEM2012.setForeground(Color.WHITE);
        btnENEM2012.addActionListener(evt -> btnENEM2012ActionPerformed());

        btnGabarito2012 = new RoundedButton("GABARITO", 15);
        btnGabarito2012.setBackground(new Color(50, 205, 50));
        btnGabarito2012.setForeground(Color.WHITE);
        btnGabarito2012.addActionListener(evt -> btnGabarito2012ActionPerformed());

        btnENEM2013 = new RoundedButton("ENEM 2013", 15);
        btnENEM2013.setBackground(new Color(0, 191, 255));
        btnENEM2013.setForeground(Color.WHITE);
        btnENEM2013.addActionListener(evt -> btnENEM2013ActionPerformed());

        btnGabarito2013 = new RoundedButton("GABARITO", 15);
        btnGabarito2013.setBackground(new Color(50, 205, 50));
        btnGabarito2013.setForeground(Color.WHITE);
        btnGabarito2013.addActionListener(evt -> btnGabarito2013ActionPerformed());

        btnENEM2014 = new RoundedButton("ENEM 2014", 15);
        btnENEM2014.setBackground(new Color(0, 191, 255));
        btnENEM2014.setForeground(Color.WHITE);
        btnENEM2014.addActionListener(evt -> btnENEM2014ActionPerformed());

        btnGabarito2014 = new RoundedButton("GABARITO", 15);
        btnGabarito2014.setBackground(new Color(50, 205, 50));
        btnGabarito2014.setForeground(Color.WHITE);
        btnGabarito2014.addActionListener(evt -> btnGabarito2014ActionPerformed());

        btnENEM2015 = new RoundedButton("ENEM 2015", 15);
        btnENEM2015.setBackground(new Color(0, 191, 255));
        btnENEM2015.setForeground(Color.WHITE);
        btnENEM2015.addActionListener(evt -> btnENEM2015ActionPerformed());

        btnGabarito2015 = new RoundedButton("GABARITO", 15);
        btnGabarito2015.setBackground(new Color(50, 205, 50));
        btnGabarito2015.setForeground(Color.WHITE);
        btnGabarito2015.addActionListener(evt -> btnGabarito2015ActionPerformed());

        btnENEM2016 = new RoundedButton("ENEM 2016", 15);
        btnENEM2016.setBackground(new Color(0, 191, 255));
        btnENEM2016.setForeground(Color.WHITE);
        btnENEM2016.addActionListener(evt -> btnENEM2016ActionPerformed());

        btnGabarito2016 = new RoundedButton("GABARITO", 15);
        btnGabarito2016.setBackground(new Color(50, 205, 50));
        btnGabarito2016.setForeground(Color.WHITE);
        btnGabarito2016.addActionListener(evt -> btnGabarito2016ActionPerformed());

        btnENEM2017 = new RoundedButton("ENEM 2017", 15);
        btnENEM2017.setBackground(new Color(0, 191, 255));
        btnENEM2017.setForeground(Color.WHITE);
        btnENEM2017.addActionListener(evt -> btnENEM2017ActionPerformed());

        btnGabarito2017 = new RoundedButton("GABARITO", 15);
        btnGabarito2017.setBackground(new Color(50, 205, 50));
        btnGabarito2017.setForeground(Color.WHITE);
        btnGabarito2017.addActionListener(evt -> btnGabarito2017ActionPerformed());

        btnENEM2018 = new RoundedButton("ENEM 2018", 15);
        btnENEM2018.setBackground(new Color(0, 191, 255));
        btnENEM2018.setForeground(Color.WHITE);
        btnENEM2018.addActionListener(evt -> btnENEM2018ActionPerformed());

        btnGabarito2018 = new RoundedButton("GABARITO", 15);
        btnGabarito2018.setBackground(new Color(50, 205, 50));
        btnGabarito2018.setForeground(Color.WHITE);
        btnGabarito2018.addActionListener(evt -> btnGabarito2018ActionPerformed());
        
        btnENEM2019 = new RoundedButton("ENEM 2019", 15);
        btnENEM2019.setBackground(new Color(0, 191, 255));
        btnENEM2019.setForeground(Color.WHITE);
        btnENEM2019.addActionListener(evt -> btnENEM2019ActionPerformed());

        btnGabarito2019 = new RoundedButton("GABARITO", 15);
        btnGabarito2019.setBackground(new Color(50, 205, 50));
        btnGabarito2019.setForeground(Color.WHITE);
        btnGabarito2019.addActionListener(evt -> btnGabarito2019ActionPerformed());

        btnENEM2020 = new RoundedButton("ENEM 2020", 15);
        btnENEM2020.setBackground(new Color(0, 191, 255));
        btnENEM2020.setForeground(Color.WHITE);
        btnENEM2020.addActionListener(evt -> btnENEM2020ActionPerformed());

        btnGabarito2020 = new RoundedButton("GABARITO", 15);
        btnGabarito2020.setBackground(new Color(50, 205, 50));
        btnGabarito2020.setForeground(Color.WHITE);
        btnGabarito2020.addActionListener(evt -> btnGabarito2020ActionPerformed());

        btnENEM2021 = new RoundedButton("ENEM 2021", 15);
        btnENEM2021.setBackground(new Color(0, 191, 255));
        btnENEM2021.setForeground(Color.WHITE);
        btnENEM2021.addActionListener(evt -> btnENEM2021ActionPerformed());

        btnGabarito2021 = new RoundedButton("GABARITO", 15);
        btnGabarito2021.setBackground(new Color(50, 205, 50));
        btnGabarito2021.setForeground(Color.WHITE);
        btnGabarito2021.addActionListener(evt -> btnGabarito2021ActionPerformed());

        btnENEM2022 = new RoundedButton("ENEM 2022", 15);
        btnENEM2022.setBackground(new Color(0, 191, 255));
        btnENEM2022.setForeground(Color.WHITE);
        btnENEM2022.addActionListener(evt -> btnENEM2022ActionPerformed());

        btnGabarito2022 = new RoundedButton("GABARITO", 15);
        btnGabarito2022.setBackground(new Color(50, 205, 50));
        btnGabarito2022.setForeground(Color.WHITE);
        btnGabarito2022.addActionListener(evt -> btnGabarito2022ActionPerformed());

        btnENEM2023 = new RoundedButton("ENEM 2023", 15);
        btnENEM2023.setBackground(new Color(0, 191, 255));
        btnENEM2023.setForeground(Color.WHITE);
        btnENEM2023.addActionListener(evt -> btnENEM2023ActionPerformed());

        btnGabarito2023 = new RoundedButton("GABARITO", 15);
        btnGabarito2023.setBackground(new Color(50, 205, 50));
        btnGabarito2023.setForeground(Color.WHITE);
        btnGabarito2023.addActionListener(evt -> btnGabarito2023ActionPerformed());

        btnRetornar = new RoundedButton("RETORNAR", 15);
        btnRetornar.setBackground(Color.ORANGE);
        btnRetornar.setForeground(Color.WHITE);
        btnRetornar.addActionListener(evt -> btnRetornarActionPerformed());

        // Adiciona os botões ao painel de fundo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(btnENEM2009, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2009, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(btnENEM2010, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2010, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(btnENEM2011, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2011, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel.add(btnENEM2012, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2012, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        buttonPanel.add(btnENEM2013, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2013, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        buttonPanel.add(btnENEM2014, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2014, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        buttonPanel.add(btnENEM2015, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2015, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        buttonPanel.add(btnENEM2016, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2016, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        buttonPanel.add(btnENEM2017, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2017, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        buttonPanel.add(btnENEM2018, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2018, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        buttonPanel.add(btnENEM2019, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2019, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        buttonPanel.add(btnENEM2020, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2020, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        buttonPanel.add(btnENEM2021, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2021, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        buttonPanel.add(btnENEM2022, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2022, gbc);

        gbc.gridx = 0;
        gbc.gridy = 14;
        buttonPanel.add(btnENEM2023, gbc);
        gbc.gridx = 1;
        buttonPanel.add(btnGabarito2023, gbc);

        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 2;
        buttonPanel.add(btnRetornar, gbc);

        setVisible(true);
    }

    private void btnENEM2009ActionPerformed(){
        // Lógica para abrir a prova do ENEM 2009
        String pdfUrl = "http://localhost/Provas/2009/dia1_caderno1_azul.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\dia1_caderno1_azul.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2009ActionPerformed() {
        // Lógica para abrir o gabarito do ENEM 2009
        String pdfUrl = "http://localhost/Provas/2009/gabarito_dia1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\gabarito_dia1.pdf"; // Caminho local para salvar o PDF
        try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnENEM2010ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2010/dia1_caderno1_azul.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\dia1_caderno1_azul.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2010ActionPerformed() {
        // Lógica para abrir o gabarito do ENEM 2010
        String pdfUrl = "http://localhost/Provas/2010/dia1_caderno1_azul_com_gab.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\dia1_caderno1_azul_com_gab.pdf"; // Caminho local para salvar o PDF
        try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2011ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2011/dia1_caderno1_azul.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\dia1_caderno1_azul.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2011ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2011/01_AZUL_GABARITO.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\01_AZUL_GABARITO.pdf"; // Caminho local para salvar o PDF
        try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void btnENEM2012ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2012/dia1_caderno1_azul.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\dia1_caderno1_azul.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2012ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2012/gabarito-dia1_azul.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\gabarito-dia1_azul.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2013ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2013/prova-dia1_azul.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\dia1_azul.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void btnGabarito2013ActionPerformed() {
        // Lógica para abrir o gabarito do ENEM 2013
        String pdfUrl = "http://localhost/Provas/2013/gabarito_azul.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\gabarito-dia1_azul.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2014ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2014/2014_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2014_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void btnGabarito2014ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2014/CADERNO_1_AZUL_SABADO.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\CADERNO_1_AZUL_SABADO.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2015ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2015/2015_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2015_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2015ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2015/GABARITO_1_AZUL_SABADO.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\GABARITO_1_AZUL_SABADO.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2016ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2016/2016_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2015_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2016ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2016/GAB_ENEM_2016_DIA_1_01_AZUL.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\GAB_ENEM_2016_DIA_1_01_AZUL.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2017ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2017/2017_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2017_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnGabarito2017ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2017/cad_1_gabarito_azul_5112017.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\cad_1_gabarito_azul_5112017.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnENEM2018ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2018/2018_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2018_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnGabarito2018ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2018/GAB_ENEM_2018_DIA_1_AZUL.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\GAB_ENEM_2018_DIA_1_AZUL.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2019ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2019/2019_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2019_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnGabarito2019ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2019/gabarito_1_dia_caderno_1_azul_aplicacao_regular.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\gabarito_1_dia_caderno_1_azul_aplicacao_regular.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2020ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2020/2020_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2020_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2020ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2020/Gabarito-2020_GB_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\Gabarito-2020_GB_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2021ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2021/2021_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2021_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2021ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2021/2021_GB_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2021_GB_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnENEM2022ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2022/2022_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2022_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2022ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2022/2022_GB_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2022_GB_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnENEM2023ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2023/2023_PV_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2023_PV_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

        try {
            // Verificar se o diretório existe, se não, criar
            File directory = new File("C:\\temp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Baixar o PDF da URL
            URL url = new URL(pdfUrl);
            InputStream in = url.openStream();
            Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            // Abrir o PDF localmente
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnGabarito2023ActionPerformed() {
        String pdfUrl = "http://localhost/Provas/2023/2023_GB_impresso_D1_CD1.pdf"; // URL do PDF no XAMPP
        String localFilePath = "C:\\temp\\2023_GB_impresso_D1_CD1.pdf"; // Caminho local para salvar o PDF

    try {
        // Verificar se o diretório existe, se não, criar
        File directory = new File("C:\\temp");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Baixar o PDF da URL
        URL url = new URL(pdfUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        in.close();

        // Abrir o PDF localmente
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(localFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void btnRetornarActionPerformed() {
        new TelaPrincipal().setVisible(true);
        this.dispose(); // Fecha a TelaProvas
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaProvas().setVisible(true);
        });
    }

    // Classe interna para criar botões arredondados
    class RoundedButton extends JButton {
        private int radius;

        public RoundedButton(String text, int radius) {
            super(text);
            this.radius = radius;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius));
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius));
            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y) {
            return new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius).contains(x, y);
        }
        
    }

    
}
