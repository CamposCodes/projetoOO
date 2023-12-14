package aula.lojaoculos.view;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class ViewCadastraVenda extends JFrame {

    JTextField valorText, dataText, codigoDescontoText, valorDescontoText, creditosUtilizadosText;
    JButton cadastrarItemButton, criarNovoClienteButton, calcularButton, confirmarVendaButton;

    public ViewCadastraVenda() {
        setTitle("Cadastro de Venda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        int textFieldWidth = 200;
        int textFieldHeight = 40;
        int buttonWidth = 200;
        int buttonHeight = 60;
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        valorText = createTextField(300, 50, textFieldWidth, textFieldHeight);
        dataText = createTextField(300, 100, textFieldWidth, textFieldHeight);
        codigoDescontoText = createTextField(300, 150, textFieldWidth, textFieldHeight);
        valorDescontoText = createTextField(300, 200, textFieldWidth, textFieldHeight);
        creditosUtilizadosText = createTextField(300, 250, textFieldWidth, textFieldHeight);

        cadastrarItemButton = createButton("Cadastrar Item", 50, 380, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        cadastrarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraProduto();
            }
        });

        criarNovoClienteButton = createButton("Novo Cliente", 300, 380, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        criarNovoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraCliente();
            }
        });

        calcularButton = createButton("Calcular", 50, 480, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para o botão calcularButton
            }
        });

        confirmarVendaButton = createButton("Confirmar Venda", 300, 480, buttonWidth, buttonHeight, buttonFont, foregroundColor, backgroundColor);
        confirmarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para o botão confirmarVendaButton
            }
        });

        addComponentsToFrame();

        setVisible(true);
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        add(textField);
        return textField;
    }

    private JButton createButton(String text, int x, int y, int width, int height, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        add(button);
        return button;
    }

    private void addComponentsToFrame() {
        addLabelToFrame("Valor:", 50, 50, 250, 40); // Alteração no width para 250
        addLabelToFrame("Data:", 50, 100, 250, 40); // Alteração no width para 250
        addLabelToFrame("Cupom de Desconto:", 50, 150, 250, 40); // Alteração no width para 250
        addLabelToFrame("Valor do Desconto:", 50, 200, 250, 40); // Alteração no width para 250
        addLabelToFrame("Créditos Utilizados:", 50, 250, 250, 40); // Alteração no width para 250
    }

    private void addLabelToFrame(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        add(label);
    }
}
