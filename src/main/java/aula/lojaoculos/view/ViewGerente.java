package aula.lojaoculos.view;
import aula.lojaoculos.controller.cliente.JanelaCliente;
import aula.lojaoculos.controller.desconto.JanelaDesconto;
import aula.lojaoculos.controller.funcionario.JanelaFuncionario;
import aula.lojaoculos.view.cadastros.*;
<<<<<<< HEAD
import aula.lojaoculos.view.updates.*;
=======
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;
>>>>>>> 7a5f84015b64ade97d2271bc2908a15fb8d324bc


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewGerente extends JFrame {
    public ViewGerente() {
        setTitle("Tela Inicial do Chefe/Gerente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Configuração do espaçamento entre os botões
        int buttonPadding = 20;
        int buttonWidth = 300;
        int buttonHeight = 60;
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

         // Criação dos botões usando setBounds
        JButton cadastrarClienteButton = createButton("Cadastrar Cliente", 250, buttonPadding, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastrarVendaButton = createButton("Cadastrar Venda", 250, buttonPadding * 2 + buttonHeight, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastroDescontoButton = createButton("Cadastro de Desconto", 250, buttonPadding * 3 + buttonHeight * 2, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastroProdutoButton = createButton("Cadastro de Produto", 250, buttonPadding * 4 + buttonHeight * 3, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        JButton cadastroFuncionarioButton = createButton("Cadastro de Funcionário", 250, buttonPadding * 5 + buttonHeight * 4, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
<<<<<<< HEAD
        JButton listagensButton = createButton("Listagens", 250, buttonPadding * 6 + buttonHeight * 5, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
=======
        JButton listagemProdutoButton = createButton("Listagem de Produto", 250, buttonPadding * 6 + buttonHeight * 5, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
>>>>>>> 7a5f84015b64ade97d2271bc2908a15fb8d324bc
        JButton sairButton = createButton("Sair", 250, buttonPadding * 7 + buttonHeight * 6, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);

        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCadastraCliente tela = new ViewCadastraCliente();
                tela.addWindowListener(new JanelaCliente(tela));
                tela.desenha();
            }
        });
        
        cadastroDescontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCadastraDesconto tela = new ViewCadastraDesconto();
                tela.addWindowListener(new JanelaDesconto(tela));
                tela.desenha();
            }
        });

        cadastrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraVenda();
                //    tela.addWindowListener(new JanelaFuncionario(tela));
                //    tela.desenha();
            }
        });

        cadastroProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraProduto();
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
<<<<<<< HEAD
        listagensButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewListagens();
=======
        listagemProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEditaRemoveProduto();
>>>>>>> 7a5f84015b64ade97d2271bc2908a15fb8d324bc
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
<<<<<<< HEAD
        add(listagensButton);
=======
        add(listagemProdutoButton);
>>>>>>> 7a5f84015b64ade97d2271bc2908a15fb8d324bc
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
