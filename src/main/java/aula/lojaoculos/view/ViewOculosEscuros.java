package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;

public class ViewOculosEscuros extends JFrame {
    public ViewOculosEscuros() {
        setTitle("Cadastro de Óculos Escuros");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null); // Mudança para layout null

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

        // Definindo posições usando setBounds
        modeloLabel.setBounds(50, 50, 100, 30);
        modeloTextField.setBounds(160, 50, 200, 30);

        marcaLabel.setBounds(50, 100, 100, 30);
        marcaTextField.setBounds(160, 100, 200, 30);

        precoLabel.setBounds(50, 150, 100, 30);
        precoTextField.setBounds(160, 150, 200, 30);

        polarizadoLabel.setBounds(50, 200, 100, 30);
        polarizadoTextField.setBounds(160, 200, 200, 30);

        corLenteLabel.setBounds(50, 250, 100, 30);
        corLenteTextField.setBounds(160, 250, 200, 30);

        registrarButton.setBounds(50, 300, 150, 40);

        // Adicionando os componentes ao frame
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
