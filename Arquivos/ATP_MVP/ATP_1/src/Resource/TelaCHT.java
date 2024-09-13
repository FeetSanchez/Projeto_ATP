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

public class TelaCHT extends JFrame {
    private FundoTela tela;
    private JButton btnHISTORIA;
    private JButton btnGEOGRAFIA;
    private JButton btnSOCIOLOGIA;
    private JButton btnFILOSOFIA;
    private JButton btnRetornar;
    private JPanel panelLinks;
    private JButton currentButton;
    private JScrollPane scrollPane;

    public TelaCHT() {
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
        btnHISTORIA = new RoundedButton("HISTÓRIA", 15);
        btnHISTORIA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnHISTORIA.addActionListener(evt -> toggleLinksPanel(btnHISTORIA));

        btnGEOGRAFIA = new RoundedButton("GEOGRAFIA", 15);
        btnGEOGRAFIA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnGEOGRAFIA.addActionListener(evt -> toggleLinksPanel(btnGEOGRAFIA));

        btnSOCIOLOGIA = new RoundedButton("SOCIOLOGIA", 15);
        btnSOCIOLOGIA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnSOCIOLOGIA.addActionListener(evt -> toggleLinksPanel(btnSOCIOLOGIA));

        btnFILOSOFIA = new RoundedButton("FILOSOFIA", 15);
        btnFILOSOFIA.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnFILOSOFIA.addActionListener(evt -> toggleLinksPanel(btnFILOSOFIA));

        btnRetornar = new RoundedButton("RETORNAR", 15);
        btnRetornar.setFont(new Font("Arial", Font.BOLD, 20)); // Altera a fonte e o seu tamanho
        btnRetornar.addActionListener(evt -> btnRetornarActionPerformed());

        // Configuração das cores dos botões
        btnHISTORIA.setBackground(new Color(0, 191, 255));
        btnGEOGRAFIA.setBackground(new Color(0, 191, 255));
        btnSOCIOLOGIA.setBackground(new Color(0, 191, 255));
        btnFILOSOFIA.setBackground(new Color(0, 191, 255));
        btnRetornar.setBackground(Color.ORANGE);

        // Configuração da cor da fonte dos botões
        btnHISTORIA.setForeground(Color.WHITE);
        btnGEOGRAFIA.setForeground(Color.WHITE);
        btnSOCIOLOGIA.setForeground(Color.WHITE);
        btnFILOSOFIA.setForeground(Color.WHITE);
        btnRetornar.setForeground(Color.WHITE);

        // Adiciona os botões ao painel de fundo
        tela.add(btnHISTORIA);
        tela.add(btnGEOGRAFIA);
        tela.add(btnSOCIOLOGIA);
        tela.add(btnFILOSOFIA);
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
            if (button == btnHISTORIA) {
                addLinkToPanel("Pré-História", "https://www.educamaisbrasil.com.br/enem/historia/prehistoria");
                addLinkToPanel("História Antiga", "https://www.educamaisbrasil.com.br/enem/historia/historia-antiga");
                addLinkToPanel("Idade Média", "https://descomplica.com.br/blog/idade-media-resumo/");
                addLinkToPanel("Iluminismo", "https://www.todamateria.com.br/iluminismo/");
                addLinkToPanel("Idade Moderna", "https://www.preparaenem.com/historia/idade-moderna.htm#:~:text=Per%C3%ADodo%20compreendido%20entre%201453%2C%20com,e%20economia%20da%20Europa%20Medieval.");
                addLinkToPanel("Revolução Industrial", "https://brasilescola.uol.com.br/historiag/revolucao-industrial.htm");
                addLinkToPanel("Primeira Guerra Mundial", "https://descomplica.com.br/blog/primeira-guerra-mundial-resumo/");
                addLinkToPanel("Nazismo/Holocausto e Fascismo", "https://www.todamateria.com.br/nazismo/");
                addLinkToPanel("Segunda Guerra Mundial", "https://descomplica.com.br/blog/segunda-guerra-mundial-resumo/");
                addLinkToPanel("Liberalismo", "https://descomplica.com.br/blog/liberalismo-resumo/");
                addLinkToPanel("Guerra Fria", "https://descomplica.com.br/blog/guerra-fria-resumo/");
                addLinkToPanel("Período Colonial no Brasil", "https://descomplica.com.br/blog/periodo-colonial-resumo/");
                addLinkToPanel("República", "https://www.educamaisbrasil.com.br/enem/historia/brasil-republica");
                addLinkToPanel("Período de escravidão", "https://brasilescola.uol.com.br/historiab/escravidao-no-brasil.htm");
                addLinkToPanel("Era Vargas", "https://brasilescola.uol.com.br/historiab/era-vargas.htm");
                addLinkToPanel("Ditadura Militar", "https://descomplica.com.br/blog/ditadura-militar-no-brasil-resumo/");
                addLinkToPanel("Era populista", "https://descomplica.com.br/blog/ditadura-militar-no-brasil-resumo/");
                
            } else if (button == btnGEOGRAFIA) {
                addLinkToPanel("O Espaço Geográfico", "https://www.todamateria.com.br/espaco-geografico/");
                addLinkToPanel("Recursos Naturais", "https://www.todamateria.com.br/recursos-naturais/");
                addLinkToPanel("Aquecimento Global", "https://www.todamateria.com.br/efeito-estufa-e-aquecimento-global/");
                addLinkToPanel("Impactos no Meio Ambiente", "https://vestibular.mundoeducacao.uol.com.br/noticias/enem-2022-o-que-pode-cair-sobre-meio-ambiente/344920.html#:~:text=Impactos%20causados%20pela%20agricultura%20moderna,que%20podem%20cair%20no%20exame.&text=Amaz%C3%B4nia%20registrou%20maior%20%C3%ADndice%20de,2022%2C%20segundo%20dados%20do%20Inpe.");
                addLinkToPanel("Chuvas Ácidas", "https://www.todamateria.com.br/chuva-acida/");
                addLinkToPanel("Mudanças Climáticas", "https://www.todamateria.com.br/mudancas-climaticas-causas-e-consequencias/");
                addLinkToPanel("O Lixo", "https://www.todamateria.com.br/tipos-de-lixo/");
                addLinkToPanel("Poluição do Ar", "https://www.todamateria.com.br/poluicao-do-ar/");
                addLinkToPanel("Ilhas de Calor", "https://www.todamateria.com.br/ilha-de-calor/");
                addLinkToPanel("Inversão Térmica", "https://www.todamateria.com.br/inversao-termica/");
                addLinkToPanel("Impactos Ambientais", "https://www.todamateria.com.br/impactos-ambientais/");
                addLinkToPanel("Solo", "https://www.todamateria.com.br/solo/");
                addLinkToPanel("Relevo", "https://www.todamateria.com.br/relevo/");
                addLinkToPanel("Tipos de Clima", "https://www.todamateria.com.br/tipos-de-clima/");
                addLinkToPanel("Bacias Hidrográficas", "https://www.todamateria.com.br/bacia-hidrografica/");
                addLinkToPanel("Urbanização", "https://www.todamateria.com.br/urbanizacao/");
                addLinkToPanel("Planos e blocos econômicos", "https://brasilescola.uol.com.br/geografia/acordos-economicos.htm");
                addLinkToPanel("Geopolítica Mundial", "https://descomplica.com.br/blog/resumo-geopolitica-mundial/");
                addLinkToPanel("Migrações", "https://www.preparaenem.com/geografia/migracoes.htm");
                addLinkToPanel("Desenvolvimento humano e social", "https://brasilescola.uol.com.br/geografia/idh-indice-desenvolvimento-humano.htm");
                addLinkToPanel("Agricultura do Brasil", "https://brasilescola.uol.com.br/brasil/agricultura.htm");
                addLinkToPanel("População Brasileira", "https://www.todamateria.com.br/populacao-brasileira/");
                
            } else if (button == btnSOCIOLOGIA) {
                addLinkToPanel("Cultura", "https://www.todamateria.com.br/o-que-e-cultura/");
                addLinkToPanel("Cidadania", "https://www.todamateria.com.br/cidadania/");
                addLinkToPanel("Marxismo", "https://www.educamaisbrasil.com.br/enem/sociologia/marxismo");
                addLinkToPanel("Contratualismo", "https://www.preparaenem.com/sociologia/contratualismo.htm");
                addLinkToPanel("Movimentos Sociais", "https://www.todamateria.com.br/movimentos-sociais/");
                addLinkToPanel("Política", "https://www.todamateria.com.br/o-que-e-politica/");
                addLinkToPanel("Comunidade e Sociedade", "https://www.todamateria.com.br/comunidade-e-sociedade/");
                addLinkToPanel("Relações de Trabalho", "https://proenem.com.br/enem/sociologia/relacoes-de-trabalho/");
                addLinkToPanel("Globalização", "https://proenem.com.br/enem/sociologia/globalizacao-desenvolvimento-e-sociologia/");
                
            } else if (button == btnFILOSOFIA) {
                addLinkToPanel("Pensadores da Grécia Antiga", "https://www.todamateria.com.br/filosofia-grega/");
                addLinkToPanel("Filosofia Medieval", "https://descomplica.com.br/blog/exercicio-resolvido-filosofia-medieval/");
                addLinkToPanel("Filosofia Moderna", "https://www.educamaisbrasil.com.br/enem/filosofia/filosofia-moderna");
                addLinkToPanel("Existêncialismo", "https://www.educamaisbrasil.com.br/enem/filosofia/existencialismo");
                addLinkToPanel("Modernidade Líquida", "https://www.todamateria.com.br/modernidade-liquida/");
                addLinkToPanel("Consumismo", "https://www.todamateria.com.br/o-que-e-consumismo/");
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
        if (button == btnHISTORIA) {
            btnGEOGRAFIA.setLocation(btnGEOGRAFIA.getX(), btnGEOGRAFIA.getY() + offset);
            btnSOCIOLOGIA.setLocation(btnSOCIOLOGIA.getX(), btnSOCIOLOGIA.getY() + offset);
            btnFILOSOFIA.setLocation(btnFILOSOFIA.getX(), btnFILOSOFIA.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnGEOGRAFIA) {
            btnSOCIOLOGIA.setLocation(btnSOCIOLOGIA.getX(), btnSOCIOLOGIA.getY() + offset);
            btnFILOSOFIA.setLocation(btnFILOSOFIA.getX(), btnFILOSOFIA.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnSOCIOLOGIA) {
            btnFILOSOFIA.setLocation(btnFILOSOFIA.getX(), btnFILOSOFIA.getY() + offset);
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        } else if (button == btnFILOSOFIA) {
            btnRetornar.setLocation(btnRetornar.getX(), btnRetornar.getY() + offset);
        }
    }

    private void repositionButtons() {
        int buttonWidth = 300;
        int buttonHeight = 60;
        int xPosition = (getWidth() - buttonWidth) / 2;
        int yPosition = (getHeight() - (5 * buttonHeight + 80)) / 2;

        btnHISTORIA.setBounds(xPosition -7, yPosition, buttonWidth, buttonHeight);
        btnGEOGRAFIA.setBounds(xPosition -7, yPosition + 80, buttonWidth, buttonHeight);
        btnSOCIOLOGIA.setBounds(xPosition -7, yPosition + 160, buttonWidth, buttonHeight);
        btnFILOSOFIA.setBounds(xPosition -7, yPosition + 240, buttonWidth, buttonHeight);
        btnRetornar.setBounds(xPosition -7, yPosition + 400, buttonWidth, buttonHeight);

        if (panelLinks.isVisible()){
            int panelHeight = panelLinks.getPreferredSize().height;
            
            panelLinks.setBounds(xPosition, btnHISTORIA.getY() + btnHISTORIA.getHeight() + 20, buttonWidth, panelHeight);
        }
    }
    
    public static String getNome() {
        return "TelaCHT";
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
        