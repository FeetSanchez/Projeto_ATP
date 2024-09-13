/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FundoTela extends JPanel {

    private Image imagemOriginal;
    private Image imagemRedimensionada;

    public FundoTela(String nomeImagem) {
        this.imagemOriginal = new ImageIcon(getClass().getResource(nomeImagem)).getImage();
        // Adiciona um ComponentListener para redimensionar a imagem quando o componente for redimensionado
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                redimensionarImagem();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemRedimensionada != null) {
            g.drawImage(imagemRedimensionada, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    private void redimensionarImagem() {
        int larguraPainel = this.getWidth();
        int alturaPainel = this.getHeight();
        int larguraImagem = imagemOriginal.getWidth(null);
        int alturaImagem = imagemOriginal.getHeight(null);

        double proporcaoImagem = (double) larguraImagem / alturaImagem;
        double proporcaoPainel = (double) larguraPainel / alturaPainel;

        if (proporcaoPainel > proporcaoImagem) {
            // Ajustar largura com base na altura do painel
            int novaAltura = alturaPainel;
            int novaLargura = (int) (novaAltura * proporcaoImagem);
            imagemRedimensionada = imagemOriginal.getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
        } else {
            // Ajustar altura com base na largura do painel
            int novaLargura = larguraPainel;
            int novaAltura = (int) (novaLargura / proporcaoImagem);
            imagemRedimensionada = imagemOriginal.getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
        }
        repaint();
    }
}
    

