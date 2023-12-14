package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;

public class ViewOculosGrau extends JFrame {

    public ViewOculosGrau() {
        setTitle("Cadastro de Óculos de Grau");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null); // Mudança para layout null

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel modeloLabel = createLabel("Modelo:", labelFont);
        JTextField modeloTextField = createTextField();
        modeloLabel.setBounds(50, 50, 100, 30);
        modeloTextField.setBounds(160, 50, 200, 30);

        JLabel marcaLabel = createLabel("Marca:", labelFont);
        JTextField marcaTextField = createTextField();
        marcaLabel.setBounds(50, 100, 100, 30);
        marcaTextField.setBounds(160, 100, 200, 30);

        JLabel precoLabel = createLabel("Preço:", labelFont);
        JTextField precoTextField = createTextField();
        precoLabel.setBounds(50, 150, 100, 30);
        precoTextField.setBounds(160, 150, 200, 30);

        JLabel grauEsquerdaLabel = createLabel("Grau Lente Esquerda:", labelFont);
        JTextField grauEsquerdaTextField = createTextField();
        grauEsquerdaLabel.setBounds(50, 200, 150, 30);
        grauEsquerdaTextField.setBounds(210, 200, 200, 30);

        JLabel grauDireitaLabel = createLabel("Grau Lente Direita:", labelFont);
        JTextField grauDireitaTextField = createTextField();
        grauDireitaLabel.setBounds(50, 250, 150, 30);
        grauDireitaTextField.setBounds(210, 250, 200, 30);

        JLabel tipoLenteLabel = createLabel("Tipo da Lente:", labelFont);
        JTextField tipoLenteTextField = createTextField();
        tipoLenteLabel.setBounds(50, 300, 150, 30);
        tipoLenteTextField.setBounds(210, 300, 200, 30);
        
        JButton registrarButton = createButton("Registrar", 150, 40);
        registrarButton.setBounds(50, 350, 150, 40);

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
        add(registrarButton);

        setVisible(true);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        return textField;
    }
    
    private JButton createButton(String text, int width, int height ){
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(new Color(237,241,238));
        button.setBackground(new Color(9,10,9));
        button.setPreferredSize(new Dimension(width,height));
        return button;
    }
}
