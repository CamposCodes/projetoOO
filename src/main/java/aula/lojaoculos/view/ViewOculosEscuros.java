package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;

public class ViewOculosEscuros extends JFrame {
    public ViewOculosEscuros() {
        setTitle("Cadastro de Óculos Escuros");
        setSize(600, 400); // Aumentando a resolução para 600x400 pixels
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2, 10, 10));

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel modeloLabel = createLabel("Modelo:", labelFont);
        JTextField modeloTextField = createTextField();

        JLabel marcaLabel = createLabel("Marca:", labelFont);
        JTextField marcaTextField = createTextField();

        JLabel precoLabel = createLabel("Preço:", labelFont);
        JTextField precoTextField = createTextField();

        JLabel polarizadoLabel = createLabel("Polarizado:", labelFont);
        JTextField polarizadoTextField = createTextField();

        JLabel corLenteLabel = createLabel("Cor da Lente:", labelFont);
        JTextField corLenteTextField = createTextField();
        
        JButton registrarButton = createButton("Registrar", 150, 40, labelFont, Color.WHITE, Color.BLACK);

        add(modeloLabel);
        add(modeloTextField);
        add(marcaLabel);
        add(marcaTextField);
        add(precoLabel);
        add(precoTextField);
        add(polarizadoLabel);
        add(polarizadoTextField);
        add(corLenteLabel);
        add(corLenteTextField);
        add(registrarButton);

        setVisible(true);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private JTextField createTextField() {
        return new JTextField();
    }
    
    private JButton createButton(String text, int width, int height, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }

}