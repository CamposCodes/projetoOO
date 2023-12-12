/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewCadastraProduto extends JFrame {
    public ViewCadastraProduto() {
        setTitle("Cadastro de Produto");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Layout para centralizar verticalmente

        // Configuração do espaçamento entre os botões
        int buttonPadding = 20;
        int buttonWidth = 200;
        int buttonHeight = 100;
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        // Botões para abrir outras janelas para cada tipo de óculos
        JButton oculosEscurosButton = createButton("Óculos Escuros", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton oculosGrauButton = createButton("Óculos de Grau", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton oculosEscurosGrauButton = createButton("Óculos Escuros com Grau", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);

        // Adiciona um espaço entre cada botão
        add(Box.createVerticalStrut(buttonPadding));
        add(oculosEscurosButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(oculosGrauButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(oculosEscurosGrauButton);
        add(Box.createVerticalStrut(buttonPadding));

        setVisible(true);
    }

    // Método utilitário para criar os botões
    private JButton createButton(String text, int width, int height, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Alinha o botão ao centro
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);

        // Adiciona ação aos botões para abrir outras janelas
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("Óculos Escuros")) {
                    // Abre a tela para cadastrar óculos escuros
                    // Exemplo: new ViewCadastraOculosEscuros();
                } else if (text.equals("Óculos de Grau")) {
                    // Abre a tela para cadastrar óculos de grau
                    // Exemplo: new ViewCadastraOculosGrau();
                } else if (text.equals("Óculos Escuros com Grau")) {
                    // Abre a tela para cadastrar óculos escuros com grau
                    // Exemplo: new ViewCadastraOculosEscurosGrau();
                }
            }
        });

        return button;
    }

    public static void main(String[] args) {
        new ViewCadastraProduto();
    }
}
