package aula.lojaoculos.view.updates;

import javax.swing.*;
import java.awt.*;

public class ViewEditaRemoveCliente extends JFrame {

    private DefaultListModel<String> clienteListModel;
    private JPanel formPanel;
    private JButton editButton, removeButton;
    private JTextField nomeTextField, dataTextField, emailTextField, cpfTextField, telefoneTextField;

    public ViewEditaRemoveCliente() {
        setTitle("Edita e Remove Clientes");
        setSize(900, 600); // Aumento na altura da janela para acomodar os botões
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        clienteListModel = new DefaultListModel<>();
        JScrollPane listScrollPane = new JScrollPane();
        listScrollPane.setBounds(50, 70, 200, 400);
        
        add(listScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(280, 50, 550, 500);
        add(formPanel);

        addLabelToFrame("Nome:", 10, 20, 150, 30);
        nomeTextField = createTextField(160, 20, 350, 30);

        addLabelToFrame("Data:", 10, 70, 150, 30);
        dataTextField = createTextField(160, 70, 350, 30);

        addLabelToFrame("Email:", 10, 120, 150, 30);
        emailTextField = createTextField(160, 120, 350, 30);

        addLabelToFrame("CPF:", 10, 170, 150, 30);
        cpfTextField = createTextField(160, 170, 350, 30);

        addLabelToFrame("Telefone:", 10, 220, 150, 30);
        telefoneTextField = createTextField(160, 220, 350, 30);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        editButton = createButton("Editar", labelFont, Color.WHITE, Color.BLACK);
        editButton.setBounds(10, 270, 200, 30);
        formPanel.add(editButton);

        removeButton = createButton("Remover", labelFont, Color.WHITE, Color.BLACK);
        removeButton.setBounds(230, 270, 200, 30);
        formPanel.add(removeButton);

        setVisible(true);
    }

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
