package aula.lojaoculos.view.cadastros;
import aula.lojaoculos.controller.produto.oculosEscuroGrau.RegistrarOculosEscuroGrau;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.model.Oculos;
import aula.lojaoculos.model.OculosGrauEscuro;
import aula.lojaoculos.persistence.OculosPersistence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewOculosEscurosGrau extends JFrame {

    private List<Oculos> listaOculos;

    JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField;

    JComboBox polarizadoComboBox, tipoLenteComboBox;

    private final OculosPersistence oculosPersistence = new OculosPersistence();

    public ViewOculosEscurosGrau() {

    }

    public void desenha(){
        setTitle("Cadastro de Óculos Escuros com Grau");
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

        JLabel grauEsquerdaLabel = createLabel("Grau Lente Esquerda:", labelFont);
        grauEsquerdaTextField = createTextField();

        JLabel grauDireitaLabel = createLabel("Grau Lente Direita:", labelFont);
        grauDireitaTextField = createTextField();

        JLabel tipoLenteLabel = createLabel("Tipo da Lente:", labelFont);
        String[] opcoesLente = {"Monofocal", "Bifocal", "Multifocal"};
        tipoLenteComboBox = new JComboBox<>(opcoesLente);

        JLabel polarizadoLabel = createLabel("Polarizado:", labelFont);
        String[] opcoesPolarizado = {"Sim", "Não"};
        polarizadoComboBox = new JComboBox<>(opcoesPolarizado);

        JLabel corLenteLabel = createLabel("Cor da Lente:", labelFont);
        corLenteTextField = createTextField();

        JButton registrarButton = createButton("Registrar", 150, 40, labelFont, Color.WHITE, Color.BLACK);
        registrarButton.addActionListener(new RegistrarOculosEscuroGrau(this));

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
        tipoLenteComboBox.setBounds(210, 300, 200, 30);

        polarizadoLabel.setBounds(50, 350, 150, 30);
        polarizadoComboBox.setBounds(210, 350, 200, 30);

        corLenteLabel.setBounds(50, 400, 150, 30);
        corLenteTextField.setBounds(210, 400, 200, 30);

        registrarButton.setBounds(50, 450, 150, 40);

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
                Double grauEsquerda = Double.parseDouble(grauEsquerdaTextField.getText());
                Double grauDireita = Double.parseDouble(grauDireitaTextField.getText());
                String tipoLente = (String) tipoLenteComboBox.getSelectedItem();
                String polarizado = (String) polarizadoComboBox.getSelectedItem();
                String corDaLente = corLenteTextField.getText();

                this.listaOculos.add(new OculosGrauEscuro(modelo, marca, preco, grauEsquerda, grauDireita, tipoLente, polarizado, corDaLente));
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
        String corDaLente = corLenteTextField.getText();

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

        if (corDaLente.isBlank()){
            throw new CampoVazioException("O campo \"cor da lente\" é obrigatório!");
        }

        return true;
    }
}
