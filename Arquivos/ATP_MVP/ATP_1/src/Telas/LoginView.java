/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import BANCO_DE_DADOS_BD.BancoDados;
import Resource.FundoTela;
import Resource.TelaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginView extends javax.swing.JFrame {

    private FundoTela tela;
    private RoundedButton btnENTRAR;
    private RoundedButton btnREALIZARCADASTRO;
    private RoundedButton btnESQUECISENHA;
    private JTextField txtEMAIL;
    private JPasswordField senhaPWD;

    public LoginView() {
        initComponents();
        
        setSize(360, 640);
        setResizable(true);
        setLayout(new BorderLayout());

        tela = new FundoTela("/Imagens/ATP3.png");
        add(tela, BorderLayout.CENTER);

        btnENTRAR = new RoundedButton("ENTRAR", 15);
        btnENTRAR.addActionListener(evt -> btnENTRARActionPerformed());
        btnREALIZARCADASTRO = new RoundedButton("CRIAR CONTA", 15);
        btnREALIZARCADASTRO.addActionListener(evt -> btnREALIZARCADASTROActionPerformed());
        btnESQUECISENHA = new RoundedButton("ESQUECI A SENHA", 15);
        btnESQUECISENHA.addActionListener(evt -> btnESQUECISENHAActionPerformed());

        txtEMAIL = new JTextField();
        senhaPWD = new JPasswordField();
        
        
        btnENTRAR.setPreferredSize(new Dimension(100, 30));
        btnREALIZARCADASTRO.setPreferredSize(new Dimension(100, 30));
        btnESQUECISENHA.setPreferredSize(new Dimension(100, 30));
        txtEMAIL.setPreferredSize(new Dimension(100, 30));
        senhaPWD.setPreferredSize(new Dimension(100, 30));

        // Configurando o layout absoluto
        tela.setLayout(null);

        // Adicionando o JLabel para "Email"
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.ORANGE);
        tela.add(lblEmail);

        // Adicionando a caixa de texto "Email"
        
        tela.add(txtEMAIL);

        // Adicionando o JLabel para "Senha"
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(Color.ORANGE);
        tela.add(lblSenha);

        // Adicionando a caixa de texto "Senha"
       
        tela.add(senhaPWD);

        // Adicionando o botão "Entrar"
        
        tela.add(btnENTRAR);

        // Adicionando o botão "Criar Conta"
      
        tela.add(btnREALIZARCADASTRO);

        // Adicionando o botão "Esqueci a Senha"
        
        tela.add(btnESQUECISENHA);

        // Estilizando os componentes
        txtEMAIL.setBorder(BorderFactory.createCompoundBorder(
            txtEMAIL.getBorder(), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        txtEMAIL.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        
        senhaPWD.setBorder(BorderFactory.createCompoundBorder(
            senhaPWD.getBorder(), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        senhaPWD.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));

        btnENTRAR.setBackground(new Color(50, 205, 50));
        btnENTRAR.setForeground(Color.WHITE);
        btnENTRAR.setOpaque(false);
        btnENTRAR.setBorderPainted(false);

        btnREALIZARCADASTRO.setBackground(new Color(0, 191, 255));
        btnREALIZARCADASTRO.setForeground(Color.WHITE);
        btnREALIZARCADASTRO.setOpaque(false);
        btnREALIZARCADASTRO.setBorderPainted(false);

        btnESQUECISENHA.setBackground(new Color(255, 165, 0));
        btnESQUECISENHA.setForeground(Color.WHITE);
        btnESQUECISENHA.setOpaque(false);
        btnESQUECISENHA.setBorderPainted(false);
        
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                int width = getWidth();
                int height = getHeight();
                
                int componentWidth = width / 3;
                int componentHeight = 30;
                int xPosition = (width - componentWidth) / 2;
                int yPosition = height - 280; // Ajuste para posicionar os componentes na parte inferior
                
                
                
                txtEMAIL.setBounds(xPosition -30, yPosition, componentWidth +50, componentHeight);
                lblEmail.setBounds(xPosition -30, yPosition - 20, componentWidth, 20);

                senhaPWD.setBounds(xPosition -30, yPosition + 50, componentWidth +50, componentHeight);
                lblSenha.setBounds(xPosition -30, yPosition + 30, componentWidth, 20);

                btnENTRAR.setBounds(xPosition -30, yPosition + 100, componentWidth +50, componentHeight);
                btnREALIZARCADASTRO.setBounds(xPosition -30, yPosition + 150, componentWidth +50, componentHeight);
                btnESQUECISENHA.setBounds(xPosition -30, yPosition + 200, componentWidth +50, componentHeight);
            }
        });
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnENTRARActionPerformed() {
        String email = txtEMAIL.getText();
        char[] senha = senhaPWD.getPassword();

        try (Connection conn = new BancoDados().conectar();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND senha = ?")) {
            
            stmt.setString(1, email);
            stmt.setString(2, new String(senha));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                    new TelaPrincipal().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Email ou senha incorretos.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + ex.getMessage());
        } finally {
            java.util.Arrays.fill(senha, '0'); // Limpar a senha do array
        }
    }

    private void btnREALIZARCADASTROActionPerformed() {
        new CadastroView().setVisible(true);
        this.dispose();
    }

    private void btnESQUECISENHAActionPerformed() {
        String email = JOptionPane.showInputDialog(this, "Digite seu email cadastrado:");
        if (email != null && !email.isEmpty()) {
            try (Connection conn = new BancoDados().conectar();
                 PreparedStatement stmt = conn.prepareStatement("SELECT senha FROM usuarios WHERE email = ?")) {
                
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String senha = rs.getString("senha");
                        // Aqui você pode implementar o envio do email com a senha
                        JOptionPane.showMessageDialog(this, "Sua senha foi enviada para o email cadastrado.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Email não encontrado.");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + ex.getMessage());
            }
        }
    }


    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public class RoundedButton extends JButton {
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
}}