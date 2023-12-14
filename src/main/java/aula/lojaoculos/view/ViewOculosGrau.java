package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;

public class ViewOculosGrau extends JFrame {

    public ViewOculosGrau() {
        
        setTitle("Cadastro de Óculos de Grau");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2, 10, 10));

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel modeloLabel = createLabel("Modelo:", labelFont);
        JTextField modeloTextField = createTextField();
        modeloLabel.setBounds(1,1,50,20);

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
        
            
        JButton registrarButton = createButton("Registrar", 100, 80);

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
