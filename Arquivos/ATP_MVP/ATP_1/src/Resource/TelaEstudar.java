/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resource;

import Telas.LoginView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

public class TelaEstudar extends JFrame {
    private FundoTela tela;
    private JButton btnLCT;
    private JButton btnCHT;
    private JButton btnCNT;
    private JButton btnMT;
    private JButton btnRetornar;

    public TelaEstudar() {
        // Configurações iniciais da janela
        setTitle("ESTUDAR");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(true);
        setLayout(new BorderLayout());

        tela = new FundoTela("/Imagens/TelaAzul.png");
        tela.setLayout(null); // Usar layout nulo para posicionamento absoluto
        add(tela, BorderLayout.CENTER);

        // Criação dos botões
        btnLCT = new RoundedButton("<html><div style='text-align: center;'>LINGUAGEM E CÓDIGOS</div></html>", 15);
        btnLCT.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnLCT.addActionListener(evt -> btnLCTActionPerformed());
        
        btnCHT = new RoundedButton("CIÊNCIAS HUMANAS", 15);
        btnCHT.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnCHT.addActionListener(evt -> btnCHTActionPerformed());
        
        btnCNT = new RoundedButton("<html><div style='text-align: center;'>CIÊNCIAS DA NATUREZA</div></html>", 15);
        btnCNT.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnCNT.addActionListener(evt -> btnCNTActionPerformed());
        
        btnMT = new RoundedButton("MATEMÁTICA", 15);
        btnMT.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnMT.addActionListener(evt -> btnMTActionPerformed());
        
        btnRetornar = new RoundedButton("RETORNAR", 15);
        btnRetornar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnRetornar.addActionListener(evt -> btnRetornarActionPerformed());

        // Configuração das cores dos botões
        btnLCT.setBackground(new Color(0, 191, 255));
        btnCHT.setBackground(new Color(0, 191, 255));
        btnCNT.setBackground(new Color(0, 191, 255));
        btnMT.setBackground(new Color(0, 191, 255));
        btnRetornar.setBackground(Color.ORANGE);

        // Configuração da cor da fonte dos botões
        btnLCT.setForeground(Color.WHITE);
        btnCHT.setForeground(Color.WHITE);
        btnCNT.setForeground(Color.WHITE);
        btnMT.setForeground(Color.WHITE);
        btnRetornar.setForeground(Color.WHITE);

        // Adiciona os botões ao painel de fundo
        tela.add(btnLCT);
        tela.add(btnCHT);
        tela.add(btnCNT);
        tela.add(btnMT);
        tela.add(btnRetornar);

        // Adiciona o listener para redimensionamento
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repositionButtons();
            }
        });

        // Posiciona os botões inicialmente
        repositionButtons();
    }

    private void repositionButtons() {
        int buttonWidth = 300;
        int buttonHeight = 60;
        int xPosition = (getWidth() - buttonWidth) / 2;
        int yPosition = (getHeight() - (5 * buttonHeight + 80)) / 2;

        btnLCT.setBounds(xPosition -7, yPosition, buttonWidth, buttonHeight);
        btnCHT.setBounds(xPosition -7, yPosition + 80, buttonWidth, buttonHeight);
        btnCNT.setBounds(xPosition -7, yPosition + 160, buttonWidth, buttonHeight);
        btnMT.setBounds(xPosition -7, yPosition + 240, buttonWidth, buttonHeight);
        btnRetornar.setBounds(xPosition -7, yPosition + 320, buttonWidth, buttonHeight);
    }
    
    public static String getNome() {
        return "TelaEstudar";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaEstudar().setVisible(true);
        });
    }

    // Métodos de ação dos botões (exemplo)
    private void btnLCTActionPerformed() {
        // Ação do botão LINGUAGENS, CÓDIGOS E SUAS TECNOLOGIAS
        new TelaLCT().setVisible(true);
        this.dispose(); // Fecha a TelaEstudar
    }

    private void btnCHTActionPerformed() {
        // Ação do botão CIÊNCIAS HUMANAS E SUAS TECNOLOGIAS
        new TelaCHT().setVisible(true);
        this.dispose(); // Fecha a TelaEstudar
    }

    private void btnCNTActionPerformed() {
        // Ação do botão CIÊNCIAS DAS NATUREZA E SUAS TECNOLOGIAS
        new TelaCNT().setVisible(true);
        this.dispose(); // Fecha a TelaEstudar
    }
    
    private void btnMTActionPerformed() {
        // Ação do botão MATEMÁTICA E SUAS TECNOLOGIAS
        new TelaMT().setVisible(true);
        this.dispose(); // Fecha a TelaEstudar
    }

    private void btnRetornarActionPerformed() {
        // Ação do botão RETORNAR
        new TelaPrincipal().setVisible(true);
        this.dispose(); // Fecha a TelaPrincipal
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
