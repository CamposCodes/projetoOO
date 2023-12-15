package aula.lojaoculos.view.updates;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class ViewEditaRemoveDesconto extends JFrame {
    private JTextField codigoText, porcentagemText, valorText, valorMinimoText;
    private JRadioButton cashbackRadio, cupomRadio;
    private JPanel formPanel, discountPanel; // Adição de um novo painel para descontos
    private JLabel codigoLabel, porcentagemLabel, valorLabel, valorMinimoLabel;
    private JList<String> descontosList; // Lista para exibir os descontos cadastrados

    private ButtonGroup buttonGroup;

    public ViewEditaRemoveDesconto() {
        setTitle("Edita e Remove Descontos");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        discountPanel = new JPanel(); // Novo painel para os descontos
        discountPanel.setLayout(new BorderLayout());
        discountPanel.setBounds(10, 50, 300, 500); // Posição e tamanho do painel de desconto
        discountPanel.setBorder(BorderFactory.createTitledBorder("Descontos")); // Adiciona uma borda com título
        add(discountPanel);

        // Adicionando a lista de descontos ao novo painel à esquerda
        descontosList = new JList<>(new String[]{"Desconto 1", "Desconto 2", "Desconto 3"}); // Substitua com seus próprios dados
        JScrollPane scrollPane = new JScrollPane(descontosList);
        scrollPane.setPreferredSize(new Dimension(280, 500)); // Ajuste o tamanho conforme necessário
        discountPanel.add(scrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(320, 50, 570, 500); // Posição e tamanho do painel de formulário
        formPanel.setBorder(BorderFactory.createTitledBorder("Editar/Remover")); // Adiciona uma borda com título
        add(formPanel);

        JLabel tipoLabel = new JLabel("Tipo de Desconto:");
        tipoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        tipoLabel.setBounds(20, 30, 200, 30);
        formPanel.add(tipoLabel);

        cashbackRadio = createRadioButton("Cashback", 20, 70, 100, 30);
        cupomRadio = createRadioButton("Cupom", 150, 70, 100, 30);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(cashbackRadio);
        buttonGroup.add(cupomRadio);
        formPanel.add(cashbackRadio);
        formPanel.add(cupomRadio);

        codigoLabel = new JLabel("Código do Desconto:");
        codigoLabel.setBounds(50, 120, 200, 30);
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(codigoLabel);

        codigoText = createTextField(260, 120, 170, 30);

        porcentagemLabel = new JLabel("Porcentagem Cashback:");
        porcentagemLabel.setBounds(50, 170, 250, 30);
        porcentagemLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(porcentagemLabel);

        porcentagemText = createTextField(260, 170, 250, 30);

        valorLabel = new JLabel("Valor do Cupom:");
        valorLabel.setBounds(50, 220, 200, 30);
        valorLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(valorLabel);

        valorText = createTextField(260, 220, 250, 30);

        valorMinimoLabel = new JLabel("Valor Mínimo para Uso:");
        valorMinimoLabel.setBounds(50, 270, 200, 30);
        valorMinimoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(valorMinimoLabel);

        valorMinimoText = createTextField(260, 270, 250, 30);

        // Botões editar e remover
        JButton editarButton = createButton("Editar", new Font("Arial", Font.PLAIN, 16), Color.WHITE, Color.BLACK);
        editarButton.setBounds(10, 420, 200, 30);
        formPanel.add(editarButton);

        JButton removerButton = createButton("Remover", new Font("Arial", Font.PLAIN, 16), Color.WHITE, Color.BLACK);
        removerButton.setBounds(230, 420, 200, 30);
        formPanel.add(removerButton);

        cashbackRadio.addActionListener(e -> showCashbackFields());
        cupomRadio.addActionListener(e -> showCupomFields());

        setVisible(true);
    }

    private void showCashbackFields() {
        valorLabel.setVisible(false);
        valorText.setVisible(false);
        valorMinimoLabel.setVisible(false);
        valorMinimoText.setVisible(false);

        porcentagemLabel.setVisible(true);
        porcentagemText.setVisible(true);
    }

    private void showCupomFields() {
        porcentagemLabel.setVisible(false);
        porcentagemText.setVisible(false);

        valorLabel.setVisible(true);
        valorText.setVisible(true);
        valorMinimoLabel.setVisible(true);
        valorMinimoText.setVisible(true);
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        formPanel.add(textField);
        return textField;
    }

    private JRadioButton createRadioButton(String text, int x, int y, int width, int height) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, width, height);
        formPanel.add(radioButton);
        return radioButton;
    }

    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }
}
