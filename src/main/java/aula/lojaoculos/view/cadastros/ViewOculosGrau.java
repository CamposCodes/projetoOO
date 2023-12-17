/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.cadastros;
import aula.lojaoculos.controller.produto.oculosGrau.RegistrarOculosGrau;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.model.Oculos;
import aula.lojaoculos.model.OculosGrau;
import aula.lojaoculos.persistence.OculosPersistence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewOculosGrau extends JFrame {

    private List<Oculos> listaOculos;

    JTextField modeloTextField, marcaTextField, precoTextField, grauEsquerdaTextField, grauDireitaTextField;

    JComboBox tipoLenteComboBox;

    private final OculosPersistence oculosPersistence = new OculosPersistence();

    public ViewOculosGrau() {

    }

    public void desenha(){
        setTitle("Cadastro de Óculos de Grau");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null); // Mudança para layout null

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel modeloLabel = createLabel("Modelo:", labelFont);
        modeloTextField = createTextField();
        modeloLabel.setBounds(50, 50, 100, 30);
        modeloTextField.setBounds(160, 50, 200, 30);

        JLabel marcaLabel = createLabel("Marca:", labelFont);
        marcaTextField = createTextField();
        marcaLabel.setBounds(50, 100, 100, 30);
        marcaTextField.setBounds(160, 100, 200, 30);

        JLabel precoLabel = createLabel("Preço:", labelFont);
        precoTextField = createTextField();
        precoLabel.setBounds(50, 150, 100, 30);
        precoTextField.setBounds(160, 150, 200, 30);

        JLabel grauEsquerdaLabel = createLabel("Grau Lente Esquerda:", labelFont);
        grauEsquerdaTextField = createTextField();
        grauEsquerdaLabel.setBounds(50, 200, 150, 30);
        grauEsquerdaTextField.setBounds(210, 200, 200, 30);

        JLabel grauDireitaLabel = createLabel("Grau Lente Direita:", labelFont);
        grauDireitaTextField = createTextField();
        grauDireitaLabel.setBounds(50, 250, 150, 30);
        grauDireitaTextField.setBounds(210, 250, 200, 30);

        JLabel tipoLenteLabel = createLabel("Tipo da Lente:", labelFont);
        String[] opcoesLente = {"Monofocal", "Bifocal", "Multifocal"};
        tipoLenteComboBox = new JComboBox<>(opcoesLente);
        tipoLenteLabel.setBounds(50, 300, 150, 30);
        tipoLenteComboBox.setBounds(210, 300, 200, 30);

        JButton registrarButton = createButton("Registrar", 150, 40);
        registrarButton.setBounds(50, 350, 150, 40);
        registrarButton.addActionListener(new RegistrarOculosGrau(this));

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
        add(tipoLenteComboBox);
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

    public List<Oculos> getListaOculos() {
        return listaOculos;
    }

    public void importaOculos(List<Oculos> all) {
        if(all == null){
            this.listaOculos = new ArrayList<Oculos>();
        }else{
            this.listaOculos = all;
        }
    }

    public boolean cadastraProduto() {
        try {
            if (validarCampos()) {

                String modelo = modeloTextField.getText();
                String marca = marcaTextField.getText();
                Double preco = Double.parseDouble(precoTextField.getText());
                Double grauEsquerda = Double.parseDouble(grauEsquerdaTextField.getText());
                Double grauDireita = Double.parseDouble(grauDireitaTextField.getText());
                String tipoLente = (String) tipoLenteComboBox.getSelectedItem();

                this.listaOculos.add(new OculosGrau(modelo, marca, preco, grauEsquerda, grauDireita, tipoLente));
                oculosPersistence.save(this.listaOculos);
                return true;
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "O campo \"preço\" e os graus das lentes devem estar no padrão: dd.dd", "Alerta", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private boolean validarCampos() throws Exception {

        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();

        String regexNumeros = "\\d+.\\d{2}";

        Pattern patternNumeros = Pattern.compile(regexNumeros);

        Matcher precoMatcher = patternNumeros.matcher(precoTextField.getText());
        Matcher esquerdaMatcher = patternNumeros.matcher(grauEsquerdaTextField.getText());
        Matcher direitaMatcher = patternNumeros.matcher(grauDireitaTextField.getText());

        if(modelo.isBlank()){
            throw new CampoVazioException("O campo \"modelo\" é obrigatório!");
        }

        if(marca.isBlank()){
            throw new CampoVazioException("O campo \"marca\" é obrigatório!");
        }

        if (!precoMatcher.matches()){
            throw new FormatoException("O preço deve estar no formato: dddd.dd");
        }

        if (!esquerdaMatcher.matches() || !direitaMatcher.matches()){
            throw new FormatoException("Os graus das lentes devem estar no formado: d.dd");
        }

        return true;
    }
}
