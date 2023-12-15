package aula.lojaoculos.view.updates;
import aula.lojaoculos.view.updates.ViewEditaRemoveFuncionario;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewListagens extends JFrame {

    public ViewListagens() {
        setTitle("Listagens");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        int buttonPadding = 20;
        int buttonWidth = 300;
        int buttonHeight = 60;
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        JButton atualizaProdutosButton = createButton("Atualiza Produtos", 250, buttonPadding, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton atualizaFuncionariosButton = createButton("Atualiza Funcionários", 250, buttonPadding * 2 + buttonHeight, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton atualizaClientesButton = createButton("Atualiza Clientes", 250, buttonPadding * 3 + buttonHeight * 2, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton atualizaDescontosButton = createButton("Atualiza Descontos", 250, buttonPadding * 4 + buttonHeight * 3, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton atualizaVendasButton = createButton("Atualiza Vendas", 250, buttonPadding * 5 + buttonHeight * 4, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton sairButton = createButton("Sair", 250, buttonPadding * 6 + buttonHeight * 5, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);

        // Adicione aqui a lógica para as ações dos botões, por exemplo:
        atualizaProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEditaRemoveProduto();
            }
        });
        atualizaFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEditaRemoveFuncionario();
            }
        });

        // Adicione os botões ao frame
        add(Box.createVerticalStrut(buttonPadding));
        add(atualizaProdutosButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(atualizaFuncionariosButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(atualizaClientesButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(atualizaDescontosButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(atualizaVendasButton);
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
