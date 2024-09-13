/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resource;

import Telas.CadastroView;
import Telas.LoginView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

public class TelaPrincipal extends JFrame {
    private FundoTela tela;
    private JButton btnEstudar;
    private JButton btnBancoDeProvas;
    private JButton btnBuscar;
    private JButton btnSairDoATP;

    public TelaPrincipal() {
        // Configurações iniciais da janela
        setTitle("Tela Principal");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(true);
        setLayout(new BorderLayout());

        tela = new FundoTela("/Resource/TelaPrincipal.png");
        tela.setLayout(null); // Usar layout nulo para posicionamento absoluto
        add(tela, BorderLayout.CENTER);

        // Criação dos botões
        btnEstudar = new RoundedButton("ESTUDAR", 15);
        btnEstudar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnEstudar.addActionListener(evt -> btnESTUDARActionPerformed());
        
        btnBancoDeProvas = new RoundedButton("PROVAS", 15);
        btnBancoDeProvas.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnBancoDeProvas.addActionListener(evt -> btnBancoDeProvasActionPerformed());
        
        btnBuscar = new RoundedButton("BUSCAR", 15);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnBuscar.addActionListener(evt -> btnBuscarActionPerformed());
        
        btnSairDoATP = new RoundedButton("SAIR DO ATP", 15);
        btnSairDoATP.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnSairDoATP.addActionListener(evt -> btnSairDoATPActionPerformed());

        // Configuração das cores dos botões
        btnEstudar.setBackground(new Color(0, 191, 255));
        btnBancoDeProvas.setBackground(new Color(0, 191, 255));
        btnBuscar.setBackground(new Color(0, 191, 255));
        btnSairDoATP.setBackground(Color.ORANGE);

        // Configuração da cor da fonte dos botões
        btnEstudar.setForeground(Color.WHITE);
        btnBancoDeProvas.setForeground(Color.WHITE);
        btnBuscar.setForeground(Color.WHITE);
        btnSairDoATP.setForeground(Color.WHITE);

        // Adiciona os botões ao painel de fundo
        tela.add(btnEstudar);
        tela.add(btnBancoDeProvas);
        tela.add(btnBuscar);
        tela.add(btnSairDoATP);

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
        int buttonWidth = 200;
        int buttonHeight = 50;
        int xPosition = (getWidth() - buttonWidth) / 2;
        int yPosition = getHeight() / 2;

        btnEstudar.setBounds(xPosition - 7, yPosition - 100, buttonWidth, buttonHeight);
        btnBancoDeProvas.setBounds(xPosition - 7, yPosition, buttonWidth, buttonHeight);
        btnBuscar.setBounds(xPosition - 7, yPosition + 100, buttonWidth, buttonHeight);
        btnSairDoATP.setBounds(xPosition - 7, yPosition + 200, buttonWidth, buttonHeight);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Métodos de ação dos botões (exemplo)
    private void btnESTUDARActionPerformed() {
        // Ação do botão Estudar
        new TelaEstudar().setVisible(true);
        this.dispose(); // Fecha a TelaPrincipal
    }

    private void btnBancoDeProvasActionPerformed() {
        // Ação do botão Banco de provas
        new TelaProvas().setVisible(true);
        this.dispose(); // Fecha a TelaPrincipal
    }

    private void btnBuscarActionPerformed() {
        // Ação do botão Buscar
       
        new BuscaNomeApp(this); 
        this.dispose(); // Fecha a TelaPrincipal
    }

    private void btnSairDoATPActionPerformed() {
        // Ação do botão Sair do ATP
        new LoginView().setVisible(true);
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