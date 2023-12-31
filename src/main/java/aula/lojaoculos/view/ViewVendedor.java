/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view;

import aula.lojaoculos.controller.cliente.JanelaCliente;
import aula.lojaoculos.controller.venda.JanelaVenda;
import aula.lojaoculos.view.cadastros.ViewCadastraCliente;
import aula.lojaoculos.view.cadastros.ViewCadastraVenda;

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
        setLayout(null); // Configuração do layout como null para uso de setBounds

        // Configuração do espaçamento entre os botões
        int buttonPadding = 20;
        int buttonWidth = 200;
        int buttonHeight = 50;
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        JButton cadastrarClienteButton = createButton("Cadastrar Cliente", 300, buttonPadding, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastrarVendaButton = createButton("Cadastrar Venda", 300, buttonPadding * 2 + buttonHeight, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton sairButton = createButton("Sair", 300, buttonPadding * 3 + buttonHeight * 2, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);

        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCadastraCliente tela = new ViewCadastraCliente();
                tela.addWindowListener(new JanelaCliente(tela));
                tela.desenha();
            }
        });

        cadastrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCadastraVenda tela = new ViewCadastraVenda();
                tela.addWindowListener(new JanelaVenda(tela));
                tela.desenha();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(cadastrarClienteButton);
        add(cadastrarVendaButton);
        add(sairButton);

        setVisible(true);
    }

    private JButton createButton(String text, int x, int y, int width, int height, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }
}
