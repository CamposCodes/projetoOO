/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.cadastros;

import aula.lojaoculos.controller.produto.oculosEscuro.JanelaOculosEscuro;
import aula.lojaoculos.controller.produto.oculosEscuroGrau.JanelaOculosEscuroGrau;
import aula.lojaoculos.controller.produto.oculosGrau.JanelaOculosGrau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewCadastraProduto extends JFrame {
    public ViewCadastraProduto() {
        setTitle("Cadastro de Produto");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null); // Layout nulo para usar setBounds

        // Configuração do espaçamento entre os botões
        int buttonWidth = 300;
        int buttonHeight = 60;
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        // Botões para abrir outras janelas para cada tipo de óculos
        JButton oculosEscurosButton = createButton("Óculos Escuros", buttonFont, foregroundColor, backgroundColor);
        JButton oculosGrauButton = createButton("Óculos de Grau", buttonFont, foregroundColor, backgroundColor);
        JButton oculosEscurosGrauButton = createButton("Óculos Escuros com Grau", buttonFont, foregroundColor, backgroundColor);

        // Adiciona ação aos botões para abrir outras janelas
        oculosEscurosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewOculosEscuros tela = new ViewOculosEscuros();
                tela.addWindowListener(new JanelaOculosEscuro(tela));
                tela.desenha();
            }
        });
        oculosEscurosGrauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewOculosEscurosGrau tela = new ViewOculosEscurosGrau();
                tela.addWindowListener(new JanelaOculosEscuroGrau(tela));
                tela.desenha();
            }
        });
        oculosGrauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewOculosGrau tela = new ViewOculosGrau();
                tela.addWindowListener(new JanelaOculosGrau(tela));
                tela.desenha();
            }
        });

        // Aplica o estilo e posicionamento aos botões usando setBounds
        oculosEscurosButton.setBounds(250, 50, buttonWidth, buttonHeight);
        oculosGrauButton.setBounds(250, 200, buttonWidth, buttonHeight);
        oculosEscurosGrauButton.setBounds(250, 350, buttonWidth, buttonHeight);

        // Adiciona os botões ao frame
        add(oculosEscurosButton);
        add(oculosGrauButton);
        add(oculosEscurosGrauButton);

        setVisible(true);
    }

    // Método utilitário para criar os botões
    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }
}
