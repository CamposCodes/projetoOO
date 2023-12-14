package aula.lojaoculos.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewCadastraDesconto extends JFrame {
    private JTextField codigoText, porcentagemText, valorText, valorMinimoText;
    private JRadioButton cashbackRadioButton, cupomRadioButton;

    public ViewCadastraDesconto() {
        setLayout(null);
        setTitle("Cadastro de Desconto");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        JLabel tipoLabel = new JLabel("Tipo de Desconto:");
        tipoLabel.setBounds(100, 80, 300, 30);
        tipoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tipoLabel);
        
        cashbackRadioButton = new JRadioButton("Cashback");
        cashbackRadioButton.setBounds(270, 80, 100, 30);
        add(cashbackRadioButton);

        cupomRadioButton = new JRadioButton("Cupom");
        cupomRadioButton.setBounds(375, 80, 100, 30);
        add(cupomRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(cashbackRadioButton);
        buttonGroup.add(cupomRadioButton);

        JLabel codigoLabel = new JLabel("Código do Cupom:");
        codigoLabel.setBounds(100, 130, 300, 30);
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(codigoLabel);

        codigoText = new JTextField();
        codigoText.setBounds(350, 130, 170, 30);
        add(codigoText);

        JLabel porcentagemLabel = new JLabel("Porcentagem de Cashback:");
        porcentagemLabel.setBounds(100, 180, 300, 30);
        porcentagemLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(porcentagemLabel);

        porcentagemText = new JTextField();
        porcentagemText.setBounds(350, 180, 250, 30);
        add(porcentagemText);

        JLabel valorLabel = new JLabel("Valor do Cupom:");
        valorLabel.setBounds(100, 230, 300, 30);
        valorLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(valorLabel);

        valorText = new JTextField();
        valorText.setBounds(350, 230, 250, 30);
        add(valorText);

        JLabel valorMinimoLabel = new JLabel("Valor Mínimo para uso: ");
        valorMinimoLabel.setBounds(100, 280, 300, 30);
        valorMinimoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(valorMinimoLabel);

        valorMinimoText = new JTextField();
        valorMinimoText.setBounds(350, 280, 250, 30);
        add(valorMinimoText);

        JButton cadastrarButton = new git JButton("Cadastrar");
        cadastrarButton.setBounds(300, 350, 150, 40);
        cadastrarButton.setFont(buttonFont);
        cadastrarButton.setForeground(foregroundColor);
        cadastrarButton.setBackground(backgroundColor);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar o desconto
            }
        });
        add(cadastrarButton);

        setVisible(true);
    }
}
