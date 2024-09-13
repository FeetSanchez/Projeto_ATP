/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import BANCO_DE_DADOS_BD.BancoDados;
import Resource.FundoTela;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CadastroView extends javax.swing.JFrame {

    FundoTela tela;
    private JTextField txtNOME;
    private RoundedButton btnCADASTRAR;
    private RoundedButton btnRETORNAR;
    private JTextField txtEMAIL;
    private JPasswordField senhaPWD;

    public CadastroView() {
        initComponents();
        
        setSize(360, 640);
        setResizable(true);
        setLayout(new BorderLayout());
        
        
        tela = new FundoTela("/Imagens/ATP3.png");
        add(tela, BorderLayout.CENTER);
        
        btnCADASTRAR = new RoundedButton("CADASTRAR", 15);
        btnCADASTRAR.setBackground(new Color(50, 205, 50));
        btnCADASTRAR.setForeground(Color.WHITE);
        btnCADASTRAR.addActionListener(evt -> btnCADASTRARActionPerformed());
        
        btnRETORNAR = new RoundedButton("RETORNAR", 15);
        btnRETORNAR.setBackground(new Color(255, 165, 0));
        btnRETORNAR.setForeground(Color.WHITE);
        btnRETORNAR.addActionListener(evt -> btnRETORNARActionPerformed());

        txtEMAIL = new JTextField();
        txtNOME = new JTextField();
        senhaPWD = new JPasswordField();
        
        btnCADASTRAR.setPreferredSize(new Dimension(250, 30));
        btnRETORNAR.setPreferredSize(new Dimension(250, 30));
        txtEMAIL.setPreferredSize(new Dimension(250, 30));
        txtNOME.setPreferredSize(new Dimension(250, 30));
        senhaPWD.setPreferredSize(new Dimension(250, 30));
        
        tela.setLayout(null);
        tela.add(btnCADASTRAR);
        tela.add(btnRETORNAR);
        tela.add(txtEMAIL);
        tela.add(txtNOME);
        tela.add(senhaPWD);
        
        // Adicionando o JLabel para "Nome"
        JLabel lblNome = new JLabel("Nome de usuário");
        lblNome.setForeground(Color.ORANGE);
        tela.add(lblNome);
        
        // Adicionando o JLabel para "Email"
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.ORANGE);
        tela.add(lblEmail);
        
        // Adicionando o JLabel para "Senha"
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(Color.ORANGE);
        tela.add(lblSenha);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                int width = getWidth();
                int height = getHeight();
                
                int componentWidth = width / 3;
                int componentHeight = 30;
                int xPosition = (width - componentWidth) / 2;
                int yPosition = height - 280; // Ajuste para posicionar os componentes na parte inferior

                txtNOME.setBounds(xPosition, yPosition, componentWidth, componentHeight);
                lblNome.setBounds(xPosition, yPosition - 20, componentWidth, 20);
                txtEMAIL.setBounds(xPosition, yPosition + 50, componentWidth, componentHeight);
                lblEmail.setBounds(xPosition, yPosition + 30, componentWidth, 20);
                senhaPWD.setBounds(xPosition, yPosition + 100, componentWidth, componentHeight);
                lblSenha.setBounds(xPosition, yPosition + 80, componentWidth, 20);
                btnCADASTRAR.setBounds(xPosition, yPosition + 150, componentWidth, componentHeight);
                btnRETORNAR.setBounds(xPosition, yPosition + 200, componentWidth, componentHeight);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }


   private void btnCADASTRARActionPerformed() {
        String nome = txtNOME.getText();
        String email = txtEMAIL.getText();
        char[] senha = senhaPWD.getPassword();

        if (email.isEmpty() || senha.length == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        try (Connection conn = new BancoDados().conectar();
             PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)")) {
            // Verificar se o email já está cadastrado
            checkStmt.setString(1, email);
            try (java.sql.ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Já existe um usuário cadastrado com este email. Se você esqueceu a senha, clique em 'Esqueci a Senha' na tela inicial.");
                    return;
                }
            }
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, new String(senha));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário.");
        } finally {
            java.util.Arrays.fill(senha, '0'); // Limpar a senha do array
        }

        new LoginView().setVisible(true);
        this.dispose();
    }

    private void btnRETORNARActionPerformed() {
        new LoginView().setVisible(true);
        this.dispose();
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
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroView().setVisible(true);
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

           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
