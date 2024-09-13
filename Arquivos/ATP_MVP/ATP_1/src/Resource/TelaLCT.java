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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URI;

public class TelaLCT extends JFrame {
    private FundoTela tela;
    private JButton btnPORTUGUES;
    private JButton btnLITERATURA;
    private JButton btnINGLES;
    private JButton btnESPANHOL;
    private JButton btnARTES;
    private JButton btnRetornar;
    private JPanel panelLinks;
    private JButton currentButton;
    private JScrollPane scrollPane;

    public TelaLCT() {
        // Configurações iniciais da janela
        setTitle("LINGUAGEM, CÓDIGOS E SUAS TECNOLOGIAS");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(true);
        setLayout(new BorderLayout());

        tela = new FundoTela("/Imagens/TelaAzul.png");
        tela.setLayout(null); // Usar layout nulo para posicionamento absoluto

        // Adiciona o painel de fundo ao JScrollPane
        scrollPane = new JScrollPane(tela);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        // Criação dos botões
        btnPORTUGUES = new RoundedButton("PORTUGUÊS", 15);
        btnPORTUGUES.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnPORTUGUES.addActionListener(evt -> toggleLinksPanel(btnPORTUGUES));
        
        btnLITERATURA = new RoundedButton("LITERATURA", 15);
        btnLITERATURA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnLITERATURA.addActionListener(evt -> toggleLinksPanel(btnLITERATURA));
        
        btnINGLES = new RoundedButton("INGLÊS", 15);
        btnINGLES.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnINGLES.addActionListener(evt -> toggleLinksPanel(btnINGLES));
        
        btnESPANHOL = new RoundedButton("ESPANHOL", 15);
        btnESPANHOL.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnESPANHOL.addActionListener(evt -> toggleLinksPanel(btnESPANHOL));
        
        btnARTES = new RoundedButton("ARTES", 15);
        btnARTES.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnARTES.addActionListener(evt -> toggleLinksPanel(btnARTES));
        
        btnRetornar = new RoundedButton("RETORNAR", 15);
        btnRetornar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnRetornar.addActionListener(evt -> btnRetornarActionPerformed());

        // Configuração das cores dos botões
        btnPORTUGUES.setBackground(new Color(0, 191, 255));
        btnLITERATURA.setBackground(new Color(0, 191, 255));
        btnINGLES.setBackground(new Color(0, 191, 255));
        btnESPANHOL.setBackground(new Color(0, 191, 255));
        btnARTES.setBackground(new Color(0, 191, 255));
        btnRetornar.setBackground(Color.ORANGE);

        // Configuração da cor da fonte dos botões
        btnPORTUGUES.setForeground(Color.WHITE);
        btnLITERATURA.setForeground(Color.WHITE);
        btnINGLES.setForeground(Color.WHITE);
        btnESPANHOL.setForeground(Color.WHITE);
        btnARTES.setForeground(Color.WHITE);
        btnRetornar.setForeground(Color.WHITE);

        // Adiciona os botões ao painel de fundo
        tela.add(btnPORTUGUES);
        tela.add(btnLITERATURA);
        tela.add(btnINGLES);
        tela.add(btnESPANHOL);
        tela.add(btnARTES);
        tela.add(btnRetornar);

        // Painel para os links
        panelLinks = new JPanel();
        panelLinks.setLayout(new BoxLayout(panelLinks, BoxLayout.Y_AXIS));
        panelLinks.setBackground(new Color(248, 248, 255));
        panelLinks.setVisible(false);
        tela.add(panelLinks);

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

    private void toggleLinksPanel(JButton button) {
        if (panelLinks.isVisible() && currentButton == button) {
            panelLinks.setVisible(false);
            repositionButtons();
            scrollPane.getVerticalScrollBar().setValue(0); // Volta a barra de rolagem para a posição inicial
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Remove a barra de rolagem
            scrollPane.getVerticalScrollBar().setEnabled(false); // Desativa a barra de rolagem
            tela.setPreferredSize(new Dimension(800, 600)); // Define o tamanho preferido da tela
            tela.setSize(800, 600); // Ajusta o tamanho da tela
        } else {
            if (currentButton != null && currentButton != button) {
                panelLinks.setVisible(false);
                repositionButtons();
            }

            panelLinks.removeAll();
            if (button == btnPORTUGUES) {
                addLinkToPanel("Funções da Linguagem", "https://www.todamateria.com.br/funcoes-da-linguagem/#:~:text=As%20fun%C3%A7%C3%B5es%20da%20linguagem%20s%C3%A3o,fun%C3%A7%C3%A3o%20conativa%20e%20fun%C3%A7%C3%A3o%20metalingu%C3%ADstica.");
                addLinkToPanel("Gêneros textuais", "https://www.todamateria.com.br/generos-textuais/#:~:text=G%C3%AAneros%20textuais%20s%C3%A3o%20as%20diferentes,listas%20de%20compras%20e%20receitas.");
                addLinkToPanel("Análise de texto", "https://brasilescola.uol.com.br/redacao/a-interpretacao-textual.htm");
                addLinkToPanel("Semântica", "https://www.portugues.com.br/gramatica/semantica.html");
                addLinkToPanel("Norma Culta e Coloquial", "https://aprovatotal.com.br/linguagem-culta-e-coloquial/#:~:text=A%20linguagem%20culta%20normalmente%20utiliza,se%20aproxima%20da%20fala%20cotidiana.");
                addLinkToPanel("Morfologia", "https://www.portugues.com.br/gramatica/morfologia.html");
                addLinkToPanel("Linguística", "https://www.educamaisbrasil.com.br/enem/lingua-portuguesa/linguistica");
                addLinkToPanel("Sintaxe", "https://blog.stoodi.com.br/blog/portugues/o-que-e-sintaxe/");
            } else if (button == btnLITERATURA) {
                addLinkToPanel("Movimentos Literários", "https://blog.stoodi.com.br/blog/portugues/escolas-literarias-do-brasil/");
                addLinkToPanel("Obras Literárias", "https://brasilescola.uol.com.br/literatura/20-classicos-da-literatura-brasileira.htm");
                addLinkToPanel("Figuras de Linguagem", "https://blog.stoodi.com.br/blog/portugues/27-figuras-de-linguagem/");
                addLinkToPanel("Poesias Concretas", "https://brasilescola.uol.com.br/literatura/poesia-concreta.htm");
                addLinkToPanel("Intertextualidade", "https://guiadoestudante.abril.com.br/enem/o-que-e-intertextualidade-e-como-ela-aparece-no-enem");
                addLinkToPanel("Arte Contemporânea", "https://www.educamaisbrasil.com.br/enem/artes/arte-contemporanea");
                addLinkToPanel("Literatura Contemporânea", "https://blog.stoodi.com.br/blog/portugues/literatura-contemporanea-o-que-e/#:~:text=O%20que%20%C3%A9%20literatura%20contempor%C3%A2nea,no%20cotidiano%20de%20determinada%20%C3%A9poca.");
            } else if (button == btnINGLES) {
                addLinkToPanel("Inglês Básico", "https://www.pravaler.com.br/wp-content/uploads/2020/03/cliqueapostilas-apostila-de-ingles-para-iniciantes.pdf");
                addLinkToPanel("Inglês Básico 2", "https://www.uece.br/wp-content/uploads/sites/3/2019/08/apostila_ingles_basico.pdf");
            } else if (button == btnESPANHOL) {
                addLinkToPanel("Espanhol Básico", "https://www.cursosonlinesp.com.br/product_downloads/y/Curso%20Espanhol%20Basico.pdf");
                addLinkToPanel("Espanhol Básico 2", "https://ifpr.edu.br/pronatec/wp-content/uploads/sites/46/2012/07/Espanhol_Basico.pdf");
            } else if (button == btnARTES) {
                addLinkToPanel("Música", "https://querobolsa.com.br/revista/musicas-que-ja-cairam-no-enem");
                addLinkToPanel("Grafite", "https://querobolsa.com.br/revista/musicas-que-ja-cairam-no-enem");
                addLinkToPanel("Cubismo", "https://www.educamaisbrasil.com.br/enem/artes/cubismo");
                addLinkToPanel("Obras artísticas", "https://www.todamateria.com.br/artes-no-enem/");
                addLinkToPanel("Renascimento", "https://www.todamateria.com.br/renascimento-caracteristicas-e-contexto-historico/#:~:text=O%20Renascimento%20foi%20um%20movimento,deu%20in%C3%ADcio%20%C3%A0%20Idade%20Moderna.");
                addLinkToPanel("Movimentos artísticos e culturais", "https://kuadros.com/pt-br/blogs/curiosidades-de-arte/los-principales-movimientos-artisticos-de-la-historia-del-arte");
                
            }

            panelLinks.setVisible(true);

            int buttonY = button.getY() + button.getHeight() + 20;
            int panelHeight = panelLinks.getPreferredSize().height;
            panelLinks.setBounds(button.getX(), buttonY, button.getWidth(), panelHeight);

            moveButtonsDown(button, panelHeight + 20); // Dá um espaço para os links descerem sem ficar por cima dos botões
            currentButton = button;

            // Atualiza a barra de rolagem para aparecer novamente
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.getVerticalScrollBar().setEnabled(true); // Reativa a barra de rolagem
        }

        // Atualiza o tamanho preferido do painel de fundo para garantir que a barra de rolagem funcione
        int totalHeight = Math.max(tela.getHeight(), btnRetornar.getY() + btnRetornar.getHeight() + 10);
        tela.setPreferredSize(new Dimension(getWidth(), totalHeight));
        scrollPane.revalidate();
        scrollPane.repaint();
    }

    private void addLinkToPanel(String text, String url) {
        JLabel label = new JLabel("<html><a href='" + url + "'>" + text + "</a></html>");
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panelLinks.add(label);
    }

    private void moveButtonsDown(JButton button, int offset) {
        if (button == btnPORTUGUES) {
            btnLITERATURA.setLocation(btnLITERATURA.getX(), btnLITERATURA.getY() + offset);
            btnINGLES.setLocation(btnINGLES.getX(), btnINGLES.getY() + offset);
            btnESPANHOL.setLocation(btnESPANHOL.getX(), btnESPANHOL.getY() + offset);
            btnARTES.setLocation(btnARTES.getX(), btnARTES.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnLITERATURA) {
            btnINGLES.setLocation(btnINGLES.getX(), btnINGLES.getY() + offset);
            btnESPANHOL.setLocation(btnESPANHOL.getX(), btnESPANHOL.getY() + offset);
            btnARTES.setLocation(btnARTES.getX(), btnARTES.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnINGLES) {
            btnESPANHOL.setLocation(btnESPANHOL.getX(), btnESPANHOL.getY() + offset);
            btnARTES.setLocation(btnARTES.getX(), btnARTES.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnESPANHOL) {
            btnARTES.setLocation(btnARTES.getX(), btnARTES.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnARTES) {
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        }
    }

    private void repositionButtons() {
        int buttonWidth = 300;
        int buttonHeight = 60;
        int xPosition = (getWidth() - buttonWidth) / 2;
        int yPosition = (getHeight() - (5 * buttonHeight + 80)) / 2;

        btnPORTUGUES.setBounds(xPosition -7, yPosition, buttonWidth, buttonHeight);
        btnLITERATURA.setBounds(xPosition -7, yPosition + 80, buttonWidth, buttonHeight);
        btnINGLES.setBounds(xPosition -7, yPosition + 160, buttonWidth, buttonHeight);
        btnESPANHOL.setBounds(xPosition -7, yPosition + 240, buttonWidth, buttonHeight);
        btnARTES.setBounds(xPosition -7, yPosition + 320, buttonWidth, buttonHeight);
        btnRetornar.setBounds(xPosition -7, yPosition + 400, buttonWidth, buttonHeight);

        if (panelLinks.isVisible()) {
            int panelHeight = panelLinks.getPreferredSize().height;
            panelLinks.setBounds(xPosition, btnPORTUGUES.getY() + btnPORTUGUES.getHeight() + 20, buttonWidth, panelHeight);
        }
    }
    
    public static String getNome() {
        return "TelaLCT";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLCT().setVisible(true);
        });
    }

    // Método de ação do botão Retornar
    private void btnRetornarActionPerformed() {
        // Ação do botão RETORNAR
        new TelaEstudar().setVisible(true);
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