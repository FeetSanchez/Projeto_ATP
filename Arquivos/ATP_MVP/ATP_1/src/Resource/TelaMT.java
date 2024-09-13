/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URI;

public class TelaMT extends JFrame {
    private FundoTela tela;
    private JButton btnALGEBRA;
    private JButton btnLOGICA;
    private JButton btnGEOMETRIA;
    private JButton btnRetornar;
    private JPanel panelLinks;
    private JButton currentButton;
    private JScrollPane scrollPane;

    public TelaMT() {
        // Configurações iniciais da janela
        setTitle("ESTUDAR");
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
        btnALGEBRA = new RoundedButton("ÁLGEBRA", 15);
        btnALGEBRA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnALGEBRA.addActionListener(evt -> toggleLinksPanel(btnALGEBRA));
        
        btnLOGICA = new RoundedButton("RACIOCÍNIO LÓGICO", 15);
        btnLOGICA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnLOGICA.addActionListener(evt -> toggleLinksPanel(btnLOGICA));
        
        btnGEOMETRIA = new RoundedButton("GEOMETRIA", 15);
        btnGEOMETRIA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnGEOMETRIA.addActionListener(evt -> toggleLinksPanel(btnGEOMETRIA));
                
        btnRetornar = new RoundedButton("RETORNAR", 15);
        btnRetornar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnRetornar.addActionListener(evt -> btnRetornarActionPerformed());

        // Configuração das cores dos botões
        btnALGEBRA.setBackground(new Color(0, 191, 255));
        btnLOGICA.setBackground(new Color(0, 191, 255));
        btnGEOMETRIA.setBackground(new Color(0, 191, 255));
        btnRetornar.setBackground(Color.ORANGE);

        // Configuração da cor da fonte dos botões
        btnALGEBRA.setForeground(Color.WHITE);
        btnLOGICA.setForeground(Color.WHITE);
        btnGEOMETRIA.setForeground(Color.WHITE);
        btnRetornar.setForeground(Color.WHITE);

        // Adiciona os botões ao painel de fundo
        tela.add(btnALGEBRA);
        tela.add(btnLOGICA);
        tela.add(btnGEOMETRIA);
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
            if (button == btnALGEBRA) {
                addLinkToPanel("Aritmética", "https://iniciativaexatas.com/aritmetica-enem/");
                addLinkToPanel("Regra de três", "https://querobolsa.com.br/enem/matematica/regra-de-tres");
                addLinkToPanel("Porcentagem", "https://vestibular.brasilescola.uol.com.br/enem/porcentagem-no-enem.htm");
                addLinkToPanel("Razões e proporções", "https://edumat.ouropreto.ifmg.edu.br/wp-content/uploads/sites/12/2016/06/apostila-matematica-financeira-01-RAZ%C3%83O-PROPOR%C3%87%C3%83O-REGRAS-DE-TRES-e-PORCENTAGEM-cassio.pdf");
                addLinkToPanel("Funções", "https://www.preparaenem.com/enem/funcoes-no-enem.htm");
                addLinkToPanel("Estatística", "https://www.preparaenem.com/enem/estatistica-no-enem.htm");
                addLinkToPanel("Probabilidade", "https://vestibular.brasilescola.uol.com.br/enem/probabilidade-no-enem.htm");
                addLinkToPanel("Análise Combinatória", "https://www.todamateria.com.br/analise-combinatoria/");
            } else if (button == btnLOGICA) {
                addLinkToPanel("Lógica Aristotélica", "https://www.todamateria.com.br/logica-aristotelica/");
                addLinkToPanel("Lógica Matemática", "https://www.todamateria.com.br/logica-matematica/");
                addLinkToPanel("Leitura e interpretação de gráficos", "https://blogdoenem.com.br/graficos-enem/");
                addLinkToPanel("Média, Mediana e Moda", "https://querobolsa.com.br/enem/matematica/mediana-mediana-media-e-moda");  
                addLinkToPanel("Tabela Verdade", "https://www.todamateria.com.br/tabela-verdade/");
                addLinkToPanel("Método Dedutivo", "https://www.todamateria.com.br/metodo-dedutivo/");
                addLinkToPanel("Silogismo", "https://www.todamateria.com.br/silogismo/");
            } else if (button == btnGEOMETRIA) {
                addLinkToPanel("Prisma", "https://www.todamateria.com.br/prisma/");
                addLinkToPanel("Geometria Plana", "https://www.preparaenem.com/matematica/geometria-plana.htm");
                addLinkToPanel("Geometria Espacial", "https://www.preparaenem.com/enem/geometria-espacial-no-enem.htm");
                addLinkToPanel("Geometria Analítica", "https://www.todamateria.com.br/geometria-analitica-resumo/");
                addLinkToPanel("Geometria Molecular", "https://www.todamateria.com.br/geometria-molecular/");
                
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
        if (button == btnALGEBRA) {
            btnLOGICA.setLocation(btnLOGICA.getX(), btnLOGICA.getY() + offset);
            btnGEOMETRIA.setLocation(btnGEOMETRIA.getX(), btnGEOMETRIA.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnLOGICA) {
            btnGEOMETRIA.setLocation(btnGEOMETRIA.getX(), btnGEOMETRIA.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnGEOMETRIA) {
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } 
    }

    private void repositionButtons() {
        int buttonWidth = 300;
        int buttonHeight = 60;
        int xPosition = (getWidth() - buttonWidth) / 2;
        int yPosition = (getHeight() - (5 * buttonHeight + 80)) / 2;

        btnALGEBRA.setBounds(xPosition -7, yPosition, buttonWidth, buttonHeight);
        btnLOGICA.setBounds(xPosition -7, yPosition + 80, buttonWidth, buttonHeight);
        btnGEOMETRIA.setBounds(xPosition -7, yPosition + 160, buttonWidth, buttonHeight);
        btnRetornar.setBounds(xPosition -7, yPosition + 400, buttonWidth, buttonHeight);
        
        if (panelLinks.isVisible()){
            int panelHeight = panelLinks.getPreferredSize().height;
            
            panelLinks.setBounds(xPosition, btnALGEBRA.getY() + btnALGEBRA.getHeight() + 20, buttonWidth, panelHeight);
        }
    }
    
    public static String getNome() {
        return "TelaMT";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaMT().setVisible(true);
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