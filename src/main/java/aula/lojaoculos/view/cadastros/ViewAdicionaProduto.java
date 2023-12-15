package aula.lojaoculos.view.cadastros;

import javax.swing.*;
import java.awt.*;

public class ViewAdicionaProduto extends JFrame {

    private DefaultListModel<String> produtoListModel;
    private JPanel formPanel, produtoPanel;
    private JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField, valorTotalTextField, quantidadeTextField;
    private JComboBox<String> tipoLenteComboBox, polarizadoComboBox;
    private JButton adicionarButton, cancelarButton;

    public ViewAdicionaProduto() {
        setTitle("Adiciona Produtos");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        produtoListModel = new DefaultListModel<>();
        JList<String> produtoList = new JList<>(produtoListModel);
        JScrollPane listScrollPane = new JScrollPane(produtoList);
        listScrollPane.setBounds(50, 50, 250, 500);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
        add(listScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(100, 50, 500, 500);
        add(formPanel);

        modeloTextField = createTextField(160, 20, 350, 30);
        marcaTextField = createTextField(160, 70, 350, 30);
        precoTextField = createTextField(160, 120, 350, 30);
        grauEsquerdaTextField = createTextField(160, 170, 350, 30);
        grauDireitaTextField = createTextField(160, 220, 350, 30);
        corLenteTextField = createTextField(160, 270, 350, 30);

        JLabel modeloLabel = addLabelToFrame("Modelo:", 10, 20, 150, 30);
        formPanel.add(modeloLabel);

        JLabel marcaLabel = addLabelToFrame("Marca:", 10, 70, 150, 30);
        formPanel.add(marcaLabel);

        JLabel precoLabel = addLabelToFrame("Preço:", 10, 120, 150, 30);
        formPanel.add(precoLabel);

        JLabel grauEsquerdaLabel = addLabelToFrame("Grau Esquerdo:", 10, 170, 150, 30);
        formPanel.add(grauEsquerdaLabel);

        JLabel grauDireitaLabel = addLabelToFrame("Grau Direito:", 10, 220, 150, 30);
        formPanel.add(grauDireitaLabel);

        JLabel tipoLenteLabel = addLabelToFrame("Tipo de Lente:", 10, 270, 150, 30);
        String[] opcoesLente = {"Monofocal", "Bifocal", "Multifocal"};
        tipoLenteComboBox = new JComboBox<>(opcoesLente);
        tipoLenteComboBox.setBounds(160, 270, 350, 30);
        formPanel.add(tipoLenteLabel);
        formPanel.add(tipoLenteComboBox);

        JLabel polarizadoLabel = addLabelToFrame("Polarizado:", 10, 320, 150, 30);
        String[] opcoesPolarizado = {"Sim", "Não"};
        polarizadoComboBox = new JComboBox<>(opcoesPolarizado);
        polarizadoComboBox.setBounds(160, 320, 350, 30);
        formPanel.add(polarizadoLabel);
        formPanel.add(polarizadoComboBox);

        valorTotalTextField = createTextField(120, 370, 150, 30);
        JLabel valorTotalLabel = addLabelToFrame("Valor Total:", 10, 370, 150, 30);
        formPanel.add(valorTotalLabel);
        formPanel.add(valorTotalTextField);

        quantidadeTextField = createTextField(370, 370, 140, 30);
        JLabel quantidadeLabel = addLabelToFrame("Quantidade:", 280, 370, 150, 30);
        formPanel.add(quantidadeLabel);
        formPanel.add(quantidadeTextField);

        adicionarButton = createButton("Adicionar", labelFont, Color.WHITE, Color.BLACK);
        adicionarButton.setBounds(10, 420, 200, 30);
        formPanel.add(adicionarButton);

        cancelarButton = createButton("Cancelar", labelFont, Color.WHITE, Color.BLACK);
        cancelarButton.setBounds(230, 420, 200, 30);
        formPanel.add(cancelarButton);

        // Adicione os listeners para os botões (lógica de adicionar e cancelar) 

        produtoPanel = new JPanel();
        produtoPanel.setLayout(new BorderLayout());
        produtoPanel.setBounds(300, 50, 550, 500);
        produtoPanel.setBorder(BorderFactory.createTitledBorder("Produtos"));
        add(produtoPanel);

        produtoPanel.add(formPanel, BorderLayout.CENTER);

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
