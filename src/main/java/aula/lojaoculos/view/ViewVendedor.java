package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewVendedor extends JFrame {
    public ViewVendedor() {
        setTitle("Tela Inicial de Vendedor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Configura o layout para centralizar verticalmente

        // Configuração do espaçamento entre os botões
        int buttonPadding = 20;
        int buttonWidth = 200;
        int buttonHeight = 100;
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        JButton cadastrarClienteButton = createButton("Cadastrar Cliente", 250, buttonPadding, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastrarVendaButton = createButton("Cadastrar Venda", 250, buttonPadding * 2 + buttonHeight, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton sairButton = createButton("Sair", 250, buttonPadding * 3 + buttonHeight * 2, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);


        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraCliente().desenha();
            }
        });
        cadastrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraVenda();
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        // Adiciona um espaço entre cada botão
        add(Box.createVerticalStrut(buttonPadding));
        add(cadastrarClienteButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(cadastrarVendaButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(sairButton);
        add(Box.createVerticalStrut(buttonPadding));


        setVisible(true);


    }

    // Método utilitário para criar os botões
    private JButton createButton(String text, int x, int y, int width, int height, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }

}
