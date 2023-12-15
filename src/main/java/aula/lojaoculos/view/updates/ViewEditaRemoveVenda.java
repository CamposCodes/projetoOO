package aula.lojaoculos.view.updates;

import javax.swing.*;
import java.awt.*;

public class ViewEditaRemoveVenda extends JFrame {
    private DefaultListModel<String> vendaListModel, produtoListModel, clienteListModel, vendedorListModel;
    private JPanel formPanel;
    private JButton editButton, removeButton;
    private JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField, valorTotalTextField, quantidadeTextField, clienteNomeTextField, clienteCpfTextField, vendedorNomeTextField, vendedorCpfTextField;

    public ViewEditaRemoveVenda() {
        setTitle("Edita e Remove Vendas");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        vendaListModel = new DefaultListModel<>();
        JList<String> vendaList = new JList<>(vendaListModel);
        JScrollPane vendaListScrollPane = new JScrollPane(vendaList);
        vendaListScrollPane.setBounds(50, 10, 250, 150);
        vendaListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Vendas"));
        add(vendaListScrollPane);

        clienteListModel = new DefaultListModel<>();
        JList<String> clienteList = new JList<>(clienteListModel);
        JScrollPane clienteListScrollPane = new JScrollPane(clienteList);
        clienteListScrollPane.setBounds(50, 180, 250, 150);
        clienteListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        add(clienteListScrollPane);

        vendedorListModel = new DefaultListModel<>();
        JList<String> vendedorList = new JList<>(vendedorListModel);
        JScrollPane vendedorListScrollPane = new JScrollPane(vendedorList);
        vendedorListScrollPane.setBounds(50, 340, 250, 150);
        vendedorListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Vendedores"));
        add(vendedorListScrollPane);

        produtoListModel = new DefaultListModel<>();
        JList<String> produtoList = new JList<>(produtoListModel);
        JScrollPane produtoListScrollPane = new JScrollPane(produtoList);
        produtoListScrollPane.setBounds(50, 500, 250, 150);
        produtoListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
        add(produtoListScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(320, 10, 550, 630);
        formPanel.setBorder(BorderFactory.createTitledBorder("Editar/Remover Venda"));
        add(formPanel);

        modeloTextField = createTextField(160, 20, 80, 30);
        marcaTextField = createTextField(260, 20, 80, 30);
        JLabel modeloLabel = addLabelToFrame("Marca/Modelo:", 10, 20, 150, 30);
        formPanel.add(modeloLabel);

        precoTextField = createTextField(160, 70, 350, 30);
        JLabel precoLabel = addLabelToFrame("Preço:", 10, 70, 150, 30);
        formPanel.add(precoLabel);

        corLenteTextField = createTextField(160, 120, 350, 30);
        JLabel corLenteLabel = addLabelToFrame("Cor da Lente:", 10, 120, 150, 30);
        formPanel.add(corLenteLabel);

        grauEsquerdaTextField = createTextField(160, 170, 350, 30);
        JLabel grauEsquerdaLabel = addLabelToFrame("Grau Esquerdo:", 10, 170, 150, 30);
        formPanel.add(grauEsquerdaLabel);

        grauDireitaTextField = createTextField(160, 220, 350, 30);
        JLabel grauDireitaLabel = addLabelToFrame("Grau Direito:", 10, 220, 150, 30);
        formPanel.add(grauDireitaLabel);

        valorTotalTextField = createTextField(160, 270, 350, 30);
        JLabel valorTotalLabel = addLabelToFrame("Valor Total:", 10, 270, 150, 30);
        formPanel.add(valorTotalLabel);

        quantidadeTextField = createTextField(160, 320, 350, 30);
        JLabel quantidadeLabel = addLabelToFrame("Quantidade:", 10, 320, 150, 30);
        formPanel.add(quantidadeLabel);

        clienteNomeTextField = createTextField(160, 370, 350, 30);
        JLabel clienteNomeLabel = addLabelToFrame("Nome do Cliente:", 10, 370, 150, 30);
        formPanel.add(clienteNomeLabel);

        clienteCpfTextField = createTextField(160, 420, 350, 30);
        JLabel clienteCpfLabel = addLabelToFrame("CPF do Cliente:", 10, 420, 150, 30);
        formPanel.add(clienteCpfLabel);

        vendedorNomeTextField = createTextField(160, 470, 350, 30);
        JLabel vendedorNomeLabel = addLabelToFrame("Vendedor:", 10, 470, 150, 30);
        formPanel.add(vendedorNomeLabel);

        vendedorCpfTextField = createTextField(160, 520, 350, 30);
        JLabel vendedorCpfLabel = addLabelToFrame("CPF do Vendedor:", 10, 520, 150, 30);
        formPanel.add(vendedorCpfLabel);

        // Botões Editar e Remover
        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        editButton = createButton("Editar", labelFont, Color.WHITE, Color.BLACK);
        editButton.setBounds(10, 570, 150, 30);
        formPanel.add(editButton);

        removeButton = createButton("Remover", labelFont, Color.WHITE, Color.BLACK);
        removeButton.setBounds(170, 570, 150, 30);
        formPanel.add(removeButton);

        setVisible(true);
    }

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
        formPanel.add(label);
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
