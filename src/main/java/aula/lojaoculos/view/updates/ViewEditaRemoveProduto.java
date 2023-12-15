package aula.lojaoculos.view.updates;
import javax.swing.*;
import java.awt.*;

public class ViewEditaRemoveProduto extends JFrame {
    private DefaultListModel<String> productListModel;
    private JPanel formPanel, productPanel;
    private JButton editButton, removeButton;
    private JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField;
    private JComboBox<String> tipoLenteComboBox, polarizadoComboBox;

    public ViewEditaRemoveProduto() {
        setTitle("Edita e Remove Produtos");
        setSize(900, 600); // Aumento na altura da janela para acomodar os botões
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        productListModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(productListModel);
        JScrollPane listScrollPane = new JScrollPane(productList);
        listScrollPane.setBounds(50, 50, 250, 500);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Produtos")); // Adiciona uma borda com título
        add(listScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(100, 50, 500, 500);
        add(formPanel);

        addLabelToFrame("Modelo:", 10, 20, 150, 30);
        modeloTextField = createTextField(160, 20, 350, 30);
        addLabelToFrame("Modelo:", 10, 20, 150, 30);
        modeloTextField = createTextField(160, 20, 350, 30); // Aumento na largura do campo de texto

        addLabelToFrame("Marca:", 10, 70, 150, 30); // Ajuste na posição Y
        marcaTextField = createTextField(160, 70, 350, 30);

        addLabelToFrame("Preço:", 10, 120, 150, 30);
        precoTextField = createTextField(160, 120, 350, 30);

        addLabelToFrame("Grau Lente Esquerda:", 10, 170, 150, 30);
        grauEsquerdaTextField = createTextField(160, 170, 350, 30);

        addLabelToFrame("Grau Lente Direita:", 10, 220, 150, 30);
        grauDireitaTextField = createTextField(160, 220, 350, 30);

        addLabelToFrame("Tipo da Lente:", 10, 270, 150, 30);
        String[] opcoesLente = {"Monofocal", "Bifocal", "Multifocal"};
        tipoLenteComboBox = new JComboBox<>(opcoesLente);
        tipoLenteComboBox.setBounds(160, 270, 350, 30);
        formPanel.add(tipoLenteComboBox);

        addLabelToFrame("Polarizado:", 10, 320, 150, 30);
        String[] opcoesPolarizado = {"Sim", "Não"};
        polarizadoComboBox = new JComboBox<>(opcoesPolarizado);
        polarizadoComboBox.setBounds(160, 320, 350, 30);
        formPanel.add(polarizadoComboBox);

        addLabelToFrame("Cor da Lente:", 10, 370, 150, 30);
        corLenteTextField = createTextField(160, 370, 350, 30);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        editButton = createButton("Editar", labelFont, Color.WHITE, Color.BLACK);
        editButton.setBounds(10, 420, 200, 30);
        formPanel.add(editButton);

        removeButton = createButton("Remover", labelFont, Color.WHITE, Color.BLACK);
        removeButton.setBounds(230, 420, 200, 30);
        formPanel.add(removeButton);

        productPanel = new JPanel();
        productPanel.setLayout(new BorderLayout());
        productPanel.setBounds(300, 50, 550, 500); // Posição e tamanho do painel de produtos
        productPanel.setBorder(BorderFactory.createTitledBorder("Produtos")); // Adiciona uma borda com título
        add(productPanel);

        productPanel.add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Métodos utilitários

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        formPanel.add(textField);
        return textField;
    }

    private void addLabelToFrame(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        formPanel.add(label);
    }

    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }
}
