package aula.lojaoculos.view;
import aula.lojaoculos.controller.funcionario.JanelaFuncionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewGerente extends JFrame {
    public ViewGerente() {
        setTitle("Tela Inicial do Chefe/Gerente");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Configuração do espaçamento entre os botões
        int buttonPadding = 20;
        int buttonWidth = 200;
        int buttonHeight = 100;
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        // Configura o layout para centralizar verticalmente
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton cadastrarClienteButton = createButton("Cadastrar Cliente", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastrarVendaButton = createButton("Cadastrar Venda", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastroDescontoButton = createButton("Cadastro de Desconto", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastroProdutoButton = createButton("Cadastro de Produto", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastroFuncionarioButton = createButton("Cadastro de Funcionário", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton sairButton = createButton("Sair", buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);

        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCadastraCliente tela = new ViewCadastraCliente();
//                tela.addWindowListener(new JanelaFuncionario(tela));
                tela.desenha();
            }
        });

        cadastrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCadastraVenda tela = new ViewCadastraVenda();
//                tela.addWindowListener(new JanelaFuncionario(tela));
//                tela.desenha();
            }
        });

//        cadastroDescontoButton.addActionListener(new ActionListener() { //TODO: CRIAR VIEW DE CADASTRO DE DESCONTO
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ViewCadastraFuncionario tela = new ViewCadastraFuncionario();
//                tela.addWindowListener(new JanelaFuncionario(tela));
//                tela.desenha();
//            }
//        });

        cadastroProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraProduto(); // TODO: CRIAR SUBJANELAS PARA OS PRODUTOS
            }
        });

        cadastroFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCadastraFuncionario tela = new ViewCadastraFuncionario();
                tela.addWindowListener(new JanelaFuncionario(tela));
                tela.desenha();
            }
        });
        


        // Adiciona um espaço entre cada botão
        add(Box.createVerticalStrut(buttonPadding));
        add(cadastrarClienteButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(cadastrarVendaButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(cadastroDescontoButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(cadastroProdutoButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(cadastroFuncionarioButton);
        add(Box.createVerticalStrut(buttonPadding));
        add(sairButton);
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
        return button;
    }

}
