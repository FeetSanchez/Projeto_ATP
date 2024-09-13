/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URI;

public class TelaCNT extends JFrame {
    private FundoTela tela;
    private JButton btnFISICA;
    private JButton btnQUIMICA;
    private JButton btnBIOLOGIA;
    private JButton btnRetornar;
    private JPanel panelLinks;
    private JButton currentButton;
    private JScrollPane scrollPane;

    public TelaCNT() {
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
        btnFISICA = new RoundedButton("FÍSICA", 15);
        btnFISICA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnFISICA.addActionListener(evt -> toggleLinksPanel(btnFISICA));
        
        btnQUIMICA = new RoundedButton("QUÍMICA", 15);
        btnQUIMICA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnQUIMICA.addActionListener(evt -> toggleLinksPanel(btnQUIMICA));
        
        btnBIOLOGIA = new RoundedButton("BIOLOGIA", 15);
        btnBIOLOGIA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnBIOLOGIA.addActionListener(evt -> toggleLinksPanel(btnBIOLOGIA));
                
        btnRetornar = new RoundedButton("RETORNAR", 15);
        btnRetornar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnRetornar.addActionListener(evt -> btnRetornarActionPerformed());

        // Configuração das cores dos botões
        btnFISICA.setBackground(new Color(0, 191, 255));
        btnQUIMICA.setBackground(new Color(0, 191, 255));
        btnBIOLOGIA.setBackground(new Color(0, 191, 255));
        btnRetornar.setBackground(Color.ORANGE);

        // Configuração da cor da fonte dos botões
        btnFISICA.setForeground(Color.WHITE);
        btnQUIMICA.setForeground(Color.WHITE);
        btnBIOLOGIA.setForeground(Color.WHITE);
        btnRetornar.setForeground(Color.WHITE);

        // Adiciona os botões ao painel de fundo
        tela.add(btnFISICA);
        tela.add(btnQUIMICA);
        tela.add(btnBIOLOGIA);
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
            if (button == btnFISICA) {
                addLinkToPanel("Mecânica", "https://www.varginha.cefetmg.br/wp-content/uploads/sites/11/2016/11/Apostila-F%C3%ADsica.pdf");
                addLinkToPanel("Eletricidade", "https://macbeth.if.usp.br/~gusev/eletricidade2.pdf");
                addLinkToPanel("Hidrostática", "https://pantheon.ufrj.br/bitstream/11422/4076/3/JHPLago.pdf");
                addLinkToPanel("Ondas", "https://ccrei.com.br/web3gestor/arquivos/81/%20Ondas.pdf");
                addLinkToPanel("Óptica", "https://www.fisica.net/optica/Optica-Moderna.pdf");
                addLinkToPanel("Acústica", "https://www.fisica.net/ondulatoria/elementos_de_acustica.pdf");
                addLinkToPanel("Calorimetria", "https://www.ccrei.com.br/web3gestor/arquivos/81/%20Calorimetria_diagrama%20de%20fases_gas%20ideal_termodinamica.pdf");
                addLinkToPanel("Física moderna", "https://acervo.sead.ufes.br/arquivos/fisica-moderna.pdf");
            } else if (button == btnQUIMICA) {
                addLinkToPanel("Moléculas e propriedades", "https://www2.ufjf.br/quimica/files/2015/06/aula-14-quimica-fundamental-2019-3-Intera%c3%a7%c3%b5es-Intermoleculares.pdf");
                addLinkToPanel("Propriedades dos compostos orgânicos", "https://aprovatotal.com.br/propriedades-dos-compostos-organicos/");
                addLinkToPanel("Separação de misturas", "https://www.todamateria.com.br/exercicios-separacao-misturas/");
                addLinkToPanel("Estequiometria", "https://www.todamateria.com.br/estequiometria/");
                addLinkToPanel("Funções inorgânicas", "https://www.todamateria.com.br/funcoes-inorganicas/");
                addLinkToPanel("Unidades de concentração", "https://proenem.com.br/enem/quimica/unidades-de-concentracao-i-porcentagens-concentracao-comum-molaridade-e-relacoes-entre-elas/");
                addLinkToPanel("pH e pOH", "https://vestibular.brasilescola.uol.com.br/enem/quimica-para-enem-ph-poh.htm");
                addLinkToPanel("Cadeias Carbônicas", "https://vestibular.brasilescola.uol.com.br/enem/cadeias-carbonicas-no-enem.htm");
                addLinkToPanel("Radioatividade", "https://quimicacompleta.com.br/radioatividade-no-enem/");
                addLinkToPanel("Soluções", "https://blog.stoodi.com.br/blog/quimica/quimica-tudo-o-que-voce-precisa-revisar-sobre-solucoes-para-o-enem/");
                addLinkToPanel("Oxidações", "https://www.educamaisbrasil.com.br/enem/quimica/oxidacao");
                addLinkToPanel("Eletroquímica", "https://vestibular.brasilescola.uol.com.br/enem/eletroquimica-no-enem.htm");
            } else if (button == btnBIOLOGIA) {
                addLinkToPanel("Moléculas, Células e tecidos", "https://www.todamateria.com.br/ciencias-da-natureza-e-suas-tecnologias/");
                addLinkToPanel("Hereditariedade e diversidade da vida", "https://professor-ruas.yolasite.com/resources/384502215-Vida-A-Ciencia-da-Biologia-Volume-I-Celula-e-Hereditariedade-8-ed-pdf.pdf");
                addLinkToPanel("Identidade dos seres vivos", "https://professor.pucgoias.edu.br/sitedocente/admin/arquivosUpload/10102/material/Aula%2003%20-%20Caracter%C3%ADsticas%20gerais%20de%20um%20ser%20vivo.pdf");
                addLinkToPanel("Ecologia e ciências ambientas", "https://educapes.capes.gov.br/bitstream/capes/586661/2/eBook_Fundamentos%20de%20ecologia%20e%20ciencias%20ambientais.pdf");
                addLinkToPanel("Origem e evolução da vida", "https://canal.cecierj.edu.br/112019/5ac08d67469851be3b89f02d15cd11ff.pdf");
                addLinkToPanel("Qualidade de vida das populações humanas", "https://antigo.uab.ufsc.br/biologia/files/2020/08/Ecologia-de-Popula%C3%A7%C3%B5es-e-Comunidades.pdf");
                addLinkToPanel("Imunização", "https://www.preparaenem.com/biologia/imunizacao.htm");
                addLinkToPanel("Citologia", "https://descomplica.com.br/blog/citologia-resumo/");
                addLinkToPanel("Ciclos de carbono, nitrogênio e água.", "https://vestibular.brasilescola.uol.com.br/enem/ciclos-biogeoquimicos-no-enem.htm");
                addLinkToPanel("Genética e mutações", "https://www.preparaenem.com/biologia/mutacao.htm");
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
        if (button == btnFISICA) {
            btnQUIMICA.setLocation(btnQUIMICA.getX(), btnQUIMICA.getY() + offset);
            btnBIOLOGIA.setLocation(btnBIOLOGIA.getX(), btnBIOLOGIA.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnQUIMICA) {
            btnBIOLOGIA.setLocation(btnBIOLOGIA.getX(), btnBIOLOGIA.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnBIOLOGIA) {
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } 
    }


    private void repositionButtons() {
        int buttonWidth = 300;
        int buttonHeight = 60;
        int xPosition = (getWidth() - buttonWidth) / 2;
        int yPosition = (getHeight() - (5 * buttonHeight + 80)) / 2;

        btnFISICA.setBounds(xPosition -7, yPosition, buttonWidth, buttonHeight);
        btnQUIMICA.setBounds(xPosition -7, yPosition + 80, buttonWidth, buttonHeight);
        btnBIOLOGIA.setBounds(xPosition -7, yPosition + 160, buttonWidth, buttonHeight);
        btnRetornar.setBounds(xPosition -7, yPosition + 400, buttonWidth, buttonHeight);
        
        if (panelLinks.isVisible()){
            int panelHeight = panelLinks.getPreferredSize().height;
            
            panelLinks.setBounds(xPosition, btnFISICA.getY() + btnFISICA.getHeight() + 20, buttonWidth, panelHeight);
        }
    }
    
    public static String getNome() {
        return "TelaCNT";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCNT().setVisible(true);
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