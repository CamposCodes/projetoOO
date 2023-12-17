/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.cadastros;
import aula.lojaoculos.controller.produto.oculosEscuro.RegistrarOculosEscuro;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.model.Oculos;
import aula.lojaoculos.model.OculosEscuros;
import aula.lojaoculos.persistence.OculosPersistence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewOculosEscuros extends JFrame {

    private List<Oculos> listaOculos;

    JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField;

    JComboBox polarizadoComboBox;

    private final OculosPersistence oculosPersistence = new OculosPersistence();

    public ViewOculosEscuros() {

    }

    public void desenha() {
        setTitle("Cadastro de Óculos Escuros");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null); // Mudança para layout null

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel modeloLabel = createLabel("Modelo:", labelFont);
        modeloTextField = createTextField();

        JLabel marcaLabel = createLabel("Marca:", labelFont);
        marcaTextField = createTextField();

        JLabel precoLabel = createLabel("Preço:", labelFont);
        precoTextField = createTextField();

        JLabel polarizadoLabel = createLabel("Polarizado:", labelFont);
        String[] opcoes = {"Sim", "Não"};
        polarizadoComboBox = new JComboBox<>(opcoes);

        JLabel corLenteLabel = createLabel("Cor da Lente:", labelFont);
        corLenteTextField = createTextField();

        JButton registrarButton = createButton("Registrar", 150, 40, labelFont, Color.WHITE, Color.BLACK);
        registrarButton.addActionListener(new RegistrarOculosEscuro(this));

        // Definindo posições usando setBounds
        modeloLabel.setBounds(50, 50, 100, 30);
        modeloTextField.setBounds(160, 50, 200, 30);

        marcaLabel.setBounds(50, 100, 100, 30);
        marcaTextField.setBounds(160, 100, 200, 30);

        precoLabel.setBounds(50, 150, 100, 30);
        precoTextField.setBounds(160, 150, 200, 30);

        polarizadoLabel.setBounds(50, 200, 100, 30);
        polarizadoComboBox.setBounds(160, 200, 200, 30);

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
        add(polarizadoComboBox);
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


    public void importaOculos(List<Oculos> all) {
        if(all == null){
            this.listaOculos = new ArrayList<Oculos>();
        }else{
            this.listaOculos = all;
        }
    }

    public List<Oculos> getListaOculos() {
        return this.listaOculos;
    }

    public boolean cadastraProduto() {
        try {
            if (validarCampos()) {

                String modelo = modeloTextField.getText();
                String marca = marcaTextField.getText();
                Double preco = Double.parseDouble(precoTextField.getText());
                String polarizado = (String) polarizadoComboBox.getSelectedItem();
                String corDaLente = corLenteTextField.getText();

                this.listaOculos.add(new OculosEscuros(modelo, marca, preco, polarizado, corDaLente));
                oculosPersistence.save(this.listaOculos);
                return true;
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "O campo \"preço\" é obrigatório", "Alerta", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private boolean validarCampos() throws Exception {

        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();
        String corDaLente = corLenteTextField.getText();

        String regexPreco = "\\d+.\\d{2}";

        Pattern patternPreco = Pattern.compile(regexPreco);

        Matcher precoMatcher = patternPreco.matcher(precoTextField.getText());

        if(modelo.isBlank()){
            throw new CampoVazioException("O campo \"modelo\" é obrigatório!");
        }

        if(marca.isBlank()){
            throw new CampoVazioException("O campo \"marca\" é obrigatório!");
        }

        if (!precoMatcher.matches()){
            throw new FormatoException("O preço deve estar no formato: dddd.dd");
        }

        if (corDaLente.isBlank()){
            throw new CampoVazioException("O campo \"cor da lente\" é obrigatório!");
        }

        return true;
    }
}

