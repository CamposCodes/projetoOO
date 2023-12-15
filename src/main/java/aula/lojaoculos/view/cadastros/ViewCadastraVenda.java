package aula.lojaoculos.view.cadastros;

import aula.lojaoculos.controller.cliente.JanelaCliente;
import aula.lojaoculos.view.cadastros.ViewCadastraCliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCadastraVenda extends JFrame {

    private DefaultListModel<String> produtoListModel, clienteListModel, vendedorListModel;
    private JPanel formPanel;
    private JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField, valorTotalTextField, quantidadeTextField, clienteNomeTextField, clienteCpfTextField, vendedorNomeTextField, vendedorCpfTextField;
    private JList<String> produtoList, clienteList, vendedorList;
    private JButton confirmarButton, adicionarProdutoButton, cancelarButton;

    public ViewCadastraVenda() {
        setTitle("Cadastrar Venda");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        produtoListModel = new DefaultListModel<>();
        produtoList = new JList<>(produtoListModel);
        JScrollPane produtoListScrollPane = new JScrollPane(produtoList);
        produtoListScrollPane.setBounds(50, 50, 250, 150);
        produtoListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
        add(produtoListScrollPane);

        clienteListModel = new DefaultListModel<>();
        clienteList = new JList<>(clienteListModel);
        JScrollPane clienteListScrollPane = new JScrollPane(clienteList);
        clienteListScrollPane.setBounds(50, 220, 250, 150);
        clienteListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        add(clienteListScrollPane);

        vendedorListModel = new DefaultListModel<>();
        vendedorList = new JList<>(vendedorListModel);
        JScrollPane vendedorListScrollPane = new JScrollPane(vendedorList);
        vendedorListScrollPane.setBounds(50, 390, 250, 150);
        vendedorListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Vendedores"));
        add(vendedorListScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(320, 50, 550, 500);
        formPanel.setBorder(BorderFactory.createTitledBorder("Formulário"));
        add(formPanel);

        modeloTextField = createTextField(160, 20, 350, 30);
        JLabel modeloLabel = addLabelToFrame("Modelo:", 10, 20, 150, 30);
        formPanel.add(modeloLabel);

        marcaTextField = createTextField(160, 70, 350, 30);
        JLabel marcaLabel = addLabelToFrame("Marca:", 10, 70, 150, 30);
        formPanel.add(marcaLabel);

        precoTextField = createTextField(160, 120, 350, 30);
        JLabel precoLabel = addLabelToFrame("Preço:", 10, 120, 150, 30);
        formPanel.add(precoLabel);

        quantidadeTextField = createTextField(160, 170, 350, 30);
        JLabel quantidadeLabel = addLabelToFrame("Quantidade:", 10, 170, 150, 30);
        formPanel.add(quantidadeLabel);

        clienteNomeTextField = createTextField(160, 220, 350, 30);
        JLabel clienteNomeLabel = addLabelToFrame("Nome do Cliente:", 10, 220, 150, 30);
        formPanel.add(clienteNomeLabel);

        clienteCpfTextField = createTextField(160, 270, 350, 30);
        JLabel clienteCpfLabel = addLabelToFrame("CPF do Cliente:", 10, 270, 150, 30);
        formPanel.add(clienteCpfLabel);

        vendedorNomeTextField = createTextField(160, 320, 350, 30);
        JLabel vendedorNomeLabel = addLabelToFrame("Nome do Vendedor:", 10, 320, 150, 30);
        formPanel.add(vendedorNomeLabel);

        vendedorCpfTextField = createTextField(160, 370, 350, 30);
        JLabel vendedorCpfLabel = addLabelToFrame("CPF do Vendedor:", 10, 370, 150, 30);
        formPanel.add(vendedorCpfLabel);

        // Botões Confirmar, Adicionar Produto e Cancelar
        confirmarButton = createButton("Confirmar", labelFont, Color.WHITE, Color.BLACK);
        confirmarButton.setBounds(10, 420, 150, 30);
        formPanel.add(confirmarButton);

        adicionarProdutoButton = createButton("Adicionar Produto", labelFont, Color.WHITE, Color.BLACK);
        adicionarProdutoButton.setBounds(170, 420, 200, 30);
        adicionarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAdicionaProduto();
            }
        });
        formPanel.add(adicionarProdutoButton);

        cancelarButton = createButton("Cancelar", labelFont, Color.WHITE, Color.BLACK);
        cancelarButton.setBounds(380, 420, 150, 30);
        formPanel.add(cancelarButton);

        setVisible(true);
    }

    // Métodos utilitários

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        formPanel.add(textField);
        return textField;
    }

    private JLabel addLabelToFrame(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        return label;
    }

    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }
}
