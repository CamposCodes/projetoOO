/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.updates;
import aula.lojaoculos.controller.produto.EditaProduto;
import aula.lojaoculos.controller.produto.RemoveProduto;
import aula.lojaoculos.controller.produto.SelecionaProdutoEdicao;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.model.*;
import aula.lojaoculos.persistence.OculosPersistence;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewEditaRemoveProduto extends JFrame {
    private DefaultListModel<Oculos> productListModel;
    private JPanel formPanel, productPanel;
    private JButton editButton, removeButton;
    private JList<Oculos> productJlist;

    private OculosPersistence oculosPersistence = new OculosPersistence();
    private List<Oculos> listaProduto;
    private JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField;
    private JTextField tipoLenteTextField, polarizadoTextField;

    public ViewEditaRemoveProduto() {

    }

    public void desenha(){
        setTitle("Edita e Remove Produtos");
        setSize(900, 600); // Aumento na altura da janela para acomodar os botões
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        productListModel = new DefaultListModel<>();
        productJlist = new JList<>(productListModel);
        productJlist.addListSelectionListener(new SelecionaProdutoEdicao(this));
        JScrollPane listScrollPane = new JScrollPane(productJlist);
        listScrollPane.setBounds(50, 50, 250, 500);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Produtos")); // Adiciona uma borda com título
        add(listScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(100, 50, 500, 500);
        add(formPanel);

        addLabelToFrame("Modelo:", 10, 20, 150, 30);
        modeloTextField = createTextField(160, 20, 350, 30);
        addLabelToFrame("Modelo:", 10, 20, 150, 30);
        modeloTextField = createTextField(160, 20, 350, 30); // Aumento na largura do campo de texto

        modeloTextField.setEditable(false);

        addLabelToFrame("Marca:", 10, 70, 150, 30); // Ajuste na posição Y
        marcaTextField = createTextField(160, 70, 350, 30);
        marcaTextField.setEditable(false);

        addLabelToFrame("Preço:", 10, 120, 150, 30);
        precoTextField = createTextField(160, 120, 350, 30);

        addLabelToFrame("Grau Lente Esquerda:", 10, 170, 150, 30);
        grauEsquerdaTextField = createTextField(160, 170, 350, 30);
        grauEsquerdaTextField.setEditable(false);

        addLabelToFrame("Grau Lente Direita:", 10, 220, 150, 30);
        grauDireitaTextField = createTextField(160, 220, 350, 30);
        grauDireitaTextField.setEditable(false);

        addLabelToFrame("Tipo da lente:", 10, 270, 350, 30);
        tipoLenteTextField = createTextField(160, 270, 350, 30);
        formPanel.add(tipoLenteTextField);
        tipoLenteTextField.setEditable(false);

        addLabelToFrame("Polarizado:", 10, 320, 150, 30);
        polarizadoTextField = createTextField(160, 320, 350, 30);
        formPanel.add(polarizadoTextField);
        polarizadoTextField.setEditable(false);

        addLabelToFrame("Cor da Lente:", 10, 370, 150, 30);
        corLenteTextField = createTextField(160, 370, 350, 30);
        corLenteTextField.setEditable(false);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        editButton = createButton("Editar", labelFont, Color.WHITE, Color.BLACK);
        editButton.addActionListener(new EditaProduto(this));
        editButton.setBounds(10, 420, 200, 30);
        formPanel.add(editButton);

        removeButton = createButton("Remover", labelFont, Color.WHITE, Color.BLACK);
        removeButton.addActionListener(new RemoveProduto(this));
        removeButton.setBounds(230, 420, 200, 30);
        formPanel.add(removeButton);

        productPanel = new JPanel();
        productPanel.setLayout(new BorderLayout());
        productPanel.setBounds(300, 50, 550, 500); // Posição e tamanho do painel de produtos
        productPanel.setBorder(BorderFactory.createTitledBorder("Produtos")); // Adiciona uma borda com título
        add(productPanel);

        productPanel.add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Métodos utilitários

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

    public void editaProduto() {
        try {
            if (validarCampos()) {

                int selectedIndex = productJlist.getSelectedIndex();

                if(selectedIndex != -1) {

                    DefaultListModel<Oculos> model = (DefaultListModel<Oculos>) productJlist.getModel();

                    Oculos oculos = model.get(selectedIndex);

                    Double preco = Double.parseDouble(precoTextField.getText());

                    model.remove(selectedIndex);

                    oculos.setPreco(preco);

                    model.add(selectedIndex, oculos);
                    listaProduto();
                    JOptionPane.showMessageDialog(null,"As alterações foram aplicadas!");
                    oculosPersistence.save(this.listaProduto);
                    limpaCampos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarCampos() throws Exception {

        String regexNumeros = "\\d+.\\d{2}";

        Pattern patternNumeros = Pattern.compile(regexNumeros);

        Matcher precoMatcher = patternNumeros.matcher(precoTextField.getText());

        if (!precoMatcher.matches()){
            throw new FormatoException("O preço deve estar no formato: dddd.dd");
        }

        return true;
    }


    public void importaProduto(List<Oculos> all) {
        DefaultListModel<Oculos> modelOculos = (DefaultListModel<Oculos>) productJlist.getModel();

        for (Oculos o: all) {
            modelOculos.addElement(o);
        }

        if(all == null){
            this.listaProduto = new ArrayList<Oculos>();
        }else{
            this.listaProduto = all;
        }
    }

    public List<Oculos> listaProduto() {
        DefaultListModel<Oculos> model = (DefaultListModel<Oculos>)productJlist.getModel();
        List<Oculos> produtos = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            produtos.add(model.get(i));
        }

        return produtos;
    }

    public void atualizaFormulario() {
        if (productJlist.getSelectedIndex() != -1){
            DefaultListModel<Oculos> model = (DefaultListModel<Oculos>)productJlist.getModel();
            String oculosGenericoNome = model.get(productJlist.getSelectedIndex()).getClass().getSimpleName();

            limpaCampos();

            if(oculosGenericoNome.equals("OculosGrauEscuro")){
                OculosGrauEscuro oculos = (OculosGrauEscuro) model.get(productJlist.getSelectedIndex());

                modeloTextField.setText(oculos.getModelo());
                marcaTextField.setText(oculos.getMarca());
                precoTextField.setText(Double.toString(oculos.getPreco()));
                grauEsquerdaTextField.setText(Double.toString(oculos.getGrauEsquerda()));
                grauDireitaTextField.setText(Double.toString(oculos.getGrauDireita()));
                tipoLenteTextField.setText(oculos.getTipoLente());
                polarizadoTextField.setText(oculos.getPolarizado());
                corLenteTextField.setText(oculos.getCorDaLente());

            } else if(oculosGenericoNome.equals("OculosGrau")){
                OculosGrau oculos = (OculosGrau) model.get(productJlist.getSelectedIndex());

                modeloTextField.setText(oculos.getModelo());
                marcaTextField.setText(oculos.getMarca());
                precoTextField.setText(Double.toString(oculos.getPreco()));
                grauEsquerdaTextField.setText(Double.toString(oculos.getGrauEsquerda()));
                grauDireitaTextField.setText(Double.toString(oculos.getGrauDireita()));
                tipoLenteTextField.setText(oculos.getTipoLente());

            }else if(oculosGenericoNome.equals("OculosEscuros")){
                OculosEscuros oculos = (OculosEscuros) model.get(productJlist.getSelectedIndex());

                modeloTextField.setText(oculos.getModelo());
                marcaTextField.setText(oculos.getMarca());
                precoTextField.setText(Double.toString(oculos.getPreco()));
                polarizadoTextField.setText(oculos.getPolarizado());
                corLenteTextField.setText(oculos.getCorDaLente());

            }

        }
    }

    private void limpaCampos(){
        modeloTextField.setText(null);
        marcaTextField.setText(null);
        precoTextField.setText(null);
        grauEsquerdaTextField.setText(null);
        grauDireitaTextField.setText(null);
        tipoLenteTextField.setText(null);
        polarizadoTextField.setText(null);
        corLenteTextField.setText(null);
    }

    public void removeDesconto() {
        if(productJlist.getSelectedIndex() != -1){
            DefaultListModel<Oculos> model = (DefaultListModel<Oculos>)productJlist.getModel();
            model.remove(productJlist.getSelectedIndex());

            listaProduto = listaProduto();
            oculosPersistence.save(listaProduto);
        }
        limpaCampos();
    }
}
