/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscaNomeApp {
    private JFrame frame;
    private JTextField textField;
    private JButton searchButton;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;
    private Map<String, Class<? extends JFrame>> telaMap;
    private boolean isSearchingLink;
    private JButton btnRetornar;
    private JFrame parentFrame; // Adicione uma referência à tela principal

    public BuscaNomeApp(JFrame parentFrame) {
        this.parentFrame = parentFrame; // Inicialize a referência à tela principal
        frame = new JFrame("Busca de Nome");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(360, 640);
        frame.setLayout(new BorderLayout());

        // Definir o fundo da tela como azul
        frame.getContentPane().setBackground(Color.BLUE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setOpaque(false); // Tornar o painel superior transparente
        textField = new JTextField(15);
        searchButton = new JButton("Pesquisar");
        topPanel.add(textField);
        topPanel.add(searchButton);
        frame.add(topPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 30, 70, 30));
        // Definir o fundo da caixa com os termos como branco
        resultList.setBackground(Color.WHITE);
        frame.add(scrollPane, BorderLayout.CENTER);

        telaMap = new HashMap<>();
        populateTelaMap();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textField.getText();
                isSearchingLink = nome.toLowerCase().contains("link");
                List<String> resultados = buscarNome(nome);
                listModel.clear();
                for (String resultado : resultados) {
                    listModel.addElement(resultado);
                }
            }
        });

        resultList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String nomeSelecionado = resultList.getSelectedValue();
                if (nomeSelecionado != null) {
                    JOptionPane.showMessageDialog(frame, "Você selecionou: " + nomeSelecionado);
                    // Navegar para a tela correspondente
                    navegarParaTela(nomeSelecionado);
                }
            }
        });

        btnRetornar = new RoundedButton("RETORNAR", 15);
        btnRetornar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnRetornar.addActionListener(evt -> btnRetornarActionPerformed());
        btnRetornar.setBackground(Color.ORANGE);
        btnRetornar.setForeground(Color.WHITE);
        
        frame.add(btnRetornar, BorderLayout.SOUTH);

        // Centralizar a nova janela em relação à tela principal
        frame.setLocationRelativeTo(parentFrame);

        frame.setVisible(true);
    }

    private void repositionButtons() {
        int buttonWidth = 300;
        int buttonHeight = 60;
        int xPosition = (frame.getWidth() - buttonWidth) / 2;
        int yPosition = (frame.getHeight() - (5 * buttonHeight + 80)) / 2;
        
        btnRetornar.setBounds(xPosition - 7, yPosition + 400, buttonWidth, buttonHeight);
    }

    public void mostrar() {
        frame.setVisible(true);
    }

    private void populateTelaMap() {
        telaMap.put("TelaCHT", TelaCHT.class);
        telaMap.put("TelaCNT", TelaCNT.class);
        telaMap.put("TelaMT", TelaMT.class);
        telaMap.put("TelaLCT", TelaLCT.class);
        telaMap.put("TelaEstudar", TelaEstudar.class);
    }

    private List<String> buscarNome(String nome) {
        List<String> resultados = new ArrayList<>();
        for (Class<? extends JFrame> telaClass : telaMap.values()) {
            try {
                JFrame tela = telaClass.getDeclaredConstructor().newInstance();
                if (isSearchingLink) {
                    ativarBotoes(tela);
                }
                resultados.addAll(buscarNosComponentes(tela, nome));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultados;
    }

    private void ativarBotoes(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JButton) {
                ((JButton) comp).doClick();
            } else if (comp instanceof Container) {
                ativarBotoes((Container) comp);
            }
        }
    }

    private List<String> buscarNosComponentes(Container container, String nome) {
        List<String> resultados = new ArrayList<>();
        for (Component comp : container.getComponents()) {
            if (comp instanceof JButton) {
                JButton botao = (JButton) comp;
                if (botao.getText().toLowerCase().contains(nome.toLowerCase())) {
                    resultados.add(botao.getText());
                    if (isSearchingLink) {
                        botao.doClick();
                    }
                }
            } else if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                if (label.getText().toLowerCase().contains(nome.toLowerCase())) {
                    resultados.add(label.getText());
                }
                if (label.getToolTipText() != null && label.getToolTipText().toLowerCase().contains(nome.toLowerCase())) {
                    resultados.add(label.getToolTipText());
                }
            } else if (comp instanceof JPanel && "panelLinks".equals(comp.getName())) {
                resultados.addAll(buscarNosComponentes((Container) comp, nome));
            } else if (comp instanceof Container) {
                resultados.addAll(buscarNosComponentes((Container) comp, nome));
            }
        }
        return resultados;
    }

    private void navegarParaTela(String nome) {
        for (Class<? extends JFrame> telaClass : telaMap.values()) {
            try {
                JFrame tela = telaClass.getDeclaredConstructor().newInstance();
                if (isSearchingLink) {
                    ativarBotoes(tela);
                }
                if (buscarNosComponentes(tela, nome).contains(nome)) {
                    tela.setVisible(true);
                    // Exibir o link na tela
                    JOptionPane.showMessageDialog(tela, "Link encontrado: " + nome);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(frame, "Tela não encontrada para: " + nome);
    }

    private void btnRetornarActionPerformed() {
        // Ação do botão "Retornar"
        new TelaPrincipal().setVisible(true);
        frame.dispose(); // Fecha a janela atual
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Classe para criar botões arredondados
    class RoundedButton extends JButton {
        private int radius;

        public RoundedButton(String text, int radius) {
            super(text);
            this.radius = radius;
            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
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
        public Dimension getPreferredSize() {
            return new Dimension(100, 50);
        }
    }
}