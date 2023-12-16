package aula.lojaoculos.view.updates;

import aula.lojaoculos.controller.cliente.JanelaEditaCliente;
import aula.lojaoculos.controller.desconto.JanelaEditaDesconto;
import aula.lojaoculos.controller.funcionario.JanelaEditaFuncionario;
import aula.lojaoculos.controller.produto.JanelaEditaProduto;
import aula.lojaoculos.controller.venda.JanelaEditaVenda;

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

        atualizaProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ViewEditaRemoveProduto tela = new ViewEditaRemoveProduto();
                tela.addWindowListener(new JanelaEditaProduto(tela));
                tela.desenha();
            }
        });
        atualizaFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ViewEditaRemoveFuncionario tela = new ViewEditaRemoveFuncionario();
                tela.addWindowListener(new JanelaEditaFuncionario(tela));
                tela.desenha();
            }
        });
        atualizaClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewEditaRemoveCliente tela = new ViewEditaRemoveCliente();
                tela.addWindowListener(new JanelaEditaCliente(tela));
                tela.desenha();
            }
        });
        atualizaDescontosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ViewEditaRemoveDesconto tela = new ViewEditaRemoveDesconto();
                tela.addWindowListener(new JanelaEditaDesconto(tela));
                tela.desenha();
            }
        });

        atualizaVendasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewEditaRemoveVenda tela = new ViewEditaRemoveVenda();
                tela.addWindowListener(new JanelaEditaVenda(tela));
                tela.desenha();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
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
