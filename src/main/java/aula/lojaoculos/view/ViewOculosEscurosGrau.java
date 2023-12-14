package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;

public class ViewOculosEscurosGrau extends JFrame {

    public ViewOculosEscurosGrau() {
        setTitle("Cadastro de Óculos Escuros com Grau");
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

        JLabel grauEsquerdaLabel = createLabel("Grau Lente Esquerda:", labelFont);
        JTextField grauEsquerdaTextField = createTextField();

        JLabel grauDireitaLabel = createLabel("Grau Lente Direita:", labelFont);
        JTextField grauDireitaTextField = createTextField();

        JLabel tipoLenteLabel = createLabel("Tipo da Lente:", labelFont);
        JTextField tipoLenteTextField = createTextField();

        JLabel polarizadoLabel = createLabel("Polarizado:", labelFont);
        JTextField polarizadoTextField = createTextField();
        
        JButton registrarButton = createButton("Registrar", 150, 40, labelFont, Color.WHITE, Color.BLACK);

        // Definindo posições usando setBounds
        modeloLabel.setBounds(50, 50, 150, 30);
        modeloTextField.setBounds(210, 50, 200, 30);

        marcaLabel.setBounds(50, 100, 150, 30);
        marcaTextField.setBounds(210, 100, 200, 30);

        precoLabel.setBounds(50, 150, 150, 30);
        precoTextField.setBounds(210, 150, 200, 30);

        grauEsquerdaLabel.setBounds(50, 200, 150, 30);
        grauEsquerdaTextField.setBounds(210, 200, 200, 30);

        grauDireitaLabel.setBounds(50, 250, 150, 30);
        grauDireitaTextField.setBounds(210, 250, 200, 30);

        tipoLenteLabel.setBounds(50, 300, 150, 30);
        tipoLenteTextField.setBounds(210, 300, 200, 30);

        polarizadoLabel.setBounds(50, 350, 150, 30);
        polarizadoTextField.setBounds(210, 350, 200, 30);

        registrarButton.setBounds(50, 400, 150, 40);

        // Adicionando os componentes ao frame
        add(modeloLabel);
        add(modeloTextField);
        add(marcaLabel);
        add(marcaTextField);
        add(precoLabel);
        add(precoTextField);
        add(grauEsquerdaLabel);
        add(grauEsquerdaTextField);
        add(grauDireitaLabel);
        add(grauDireitaTextField);
        add(tipoLenteLabel);
        add(tipoLenteTextField);
        add(polarizadoLabel);
        add(polarizadoTextField);
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
