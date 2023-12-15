package aula.lojaoculos.view.cadastros;

import aula.lojaoculos.controller.item.AdicionarItem;
import aula.lojaoculos.controller.item.SelecionarProduto;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewAdicionaProduto extends JFrame {

    private DefaultListModel<Oculos> produtoListModel;
    private JPanel formPanel, produtoPanel;
    private JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField, valorTotalTextField, quantidadeTextField, tipoLenteTextField, polarizadoTextField;;
    private JButton adicionarButton, cancelarButton;

    private ViewCadastraVenda telaVenda;

    JList<Oculos> produtoList;

    public ViewAdicionaProduto(ViewCadastraVenda telaVenda) {
        this.telaVenda = telaVenda;
    }

    public void desenha(){
        setTitle("Adicionar Item");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        produtoListModel = new DefaultListModel<>();
        produtoList = new JList<Oculos>(produtoListModel);
        produtoList.addListSelectionListener(new SelecionarProduto(this));
        JScrollPane listScrollPane = new JScrollPane(produtoList);
        listScrollPane.setBounds(50, 50, 250, 500);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Produtos"));
        add(listScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(100, 50, 500, 500);
        add(formPanel);

        modeloTextField = createTextField(160, 20, 350, 30);
        modeloTextField.setEditable(false);
        marcaTextField = createTextField(160, 70, 350, 30);
        marcaTextField.setEditable(false);
        precoTextField = createTextField(160, 120, 350, 30);
        precoTextField.setEditable(false);
        grauEsquerdaTextField = createTextField(160, 170, 350, 30);
        grauEsquerdaTextField.setEditable(false);
        grauDireitaTextField = createTextField(160, 220, 350, 30);
        grauDireitaTextField.setEditable(false);
        corLenteTextField = createTextField(160, 270, 350, 30);
        corLenteTextField.setEditable(false);

        JLabel modeloLabel = addLabelToFrame("Modelo:", 10, 20, 150, 30);
        formPanel.add(modeloLabel);

        JLabel marcaLabel = addLabelToFrame("Marca:", 10, 70, 150, 30);
        formPanel.add(marcaLabel);

        JLabel precoLabel = addLabelToFrame("Preço:", 10, 120, 150, 30);
        formPanel.add(precoLabel);

        JLabel grauEsquerdaLabel = addLabelToFrame("Grau Esquerdo:", 10, 170, 150, 30);
        formPanel.add(grauEsquerdaLabel);

        JLabel grauDireitaLabel = addLabelToFrame("Grau Direito:", 10, 220, 150, 30);
        formPanel.add(grauDireitaLabel);

        JLabel tipoLenteLabel = addLabelToFrame("Tipo de Lente:", 10, 270, 150, 30);
        tipoLenteTextField = createTextField(160, 270, 350, 30);
        tipoLenteTextField.setEditable(false);
        formPanel.add(tipoLenteLabel);
        formPanel.add(tipoLenteTextField);

        JLabel polarizadoLabel = addLabelToFrame("Polarizado:", 10, 320, 150, 30);
        polarizadoTextField = createTextField(160, 320, 350, 30);
        polarizadoTextField.setEditable(false);
        formPanel.add(polarizadoLabel);
        formPanel.add(polarizadoTextField);

        quantidadeTextField = createTextField(120, 370, 150, 30);
        quantidadeTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regexNumeros = "\\d+";

                Pattern patternNumeros = Pattern.compile(regexNumeros);

                Matcher precoMatcher = patternNumeros.matcher(quantidadeTextField.getText());

                try {

                    if(!precoMatcher.matches()){
                        throw new FormatoException("A quantidade deve ser um número inteiro!");
                    }

                    Double precoUnitario = Double.parseDouble(precoTextField.getText());
                    Double quantidade = Double.parseDouble(quantidadeTextField.getText());
                    Double precoTotal = precoUnitario * quantidade;

//                    precoTotal.

                    valorTotalTextField.setText(Double.toString(precoTotal));
                } catch (NumberFormatException erro){
                    JOptionPane.showMessageDialog(null, "Selecione um produto antes de definir a quantidade!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    quantidadeTextField.setText(null);
                } catch (FormatoException erro2){
                    JOptionPane.showMessageDialog(null, erro2.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
                    quantidadeTextField.setText(null);
                }
            }
        });
        JLabel quantidadeLabel = addLabelToFrame("Quantidade:", 10, 370, 150, 30);
        formPanel.add(quantidadeLabel);
        formPanel.add(quantidadeTextField);

        valorTotalTextField = createTextField(370, 370, 140, 30);
        valorTotalTextField.setEditable(false);
        JLabel valorTotalLabel = addLabelToFrame("Valor Total:", 280, 370, 150, 30);
        formPanel.add(valorTotalLabel);
        formPanel.add(valorTotalTextField);

        adicionarButton = createButton("Adicionar", labelFont, Color.WHITE, Color.BLACK);
        adicionarButton.addActionListener(new AdicionarItem(this));
        adicionarButton.setBounds(10, 420, 500, 30);
        formPanel.add(adicionarButton);

        // Adicione os listeners para os botões (lógica de adicionar e cancelar)

        produtoPanel = new JPanel();
        produtoPanel.setLayout(new BorderLayout());
        produtoPanel.setBounds(300, 50, 550, 500);
        produtoPanel.setBorder(BorderFactory.createTitledBorder("Produtos"));
        add(produtoPanel);

        produtoPanel.add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Métodos utilitários

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        formPanel.add(textField);
        return textField;
    }

    private JLabel addLabelToFrame(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        return label;
    }

    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }

    public void importaProdutos(List<Oculos> all) {
        DefaultListModel<Oculos> model = (DefaultListModel<Oculos>)produtoList.getModel();

        for (Oculos o: all) {
            model.addElement(o);
        }
    }

    public void atualizarCampos() {
        if (produtoList.getSelectedIndex() != -1){
            DefaultListModel<Oculos> model = (DefaultListModel<Oculos>)produtoList.getModel();
            String oculosGenericoNome = model.get(produtoList.getSelectedIndex()).getClass().getSimpleName();

            limpaCampos();

            if(oculosGenericoNome.equals("OculosGrauEscuro")){
                OculosGrauEscuro oculos = (OculosGrauEscuro) model.get(produtoList.getSelectedIndex());

                modeloTextField.setText(oculos.getModelo());
                marcaTextField.setText(oculos.getMarca());
                precoTextField.setText(Double.toString(oculos.getPreco()));
                grauEsquerdaTextField.setText(Double.toString(oculos.getGrauEsquerda()));
                grauDireitaTextField.setText(Double.toString(oculos.getGrauDireita()));
                tipoLenteTextField.setText(oculos.getTipoLente());
                polarizadoTextField.setText(oculos.getPolarizado());

            } else if(oculosGenericoNome.equals("OculosGrau")){
                OculosGrau oculos = (OculosGrau) model.get(produtoList.getSelectedIndex());

                modeloTextField.setText(oculos.getModelo());
                marcaTextField.setText(oculos.getMarca());
                precoTextField.setText(Double.toString(oculos.getPreco()));
                grauEsquerdaTextField.setText(Double.toString(oculos.getGrauEsquerda()));
                grauDireitaTextField.setText(Double.toString(oculos.getGrauDireita()));
                tipoLenteTextField.setText(oculos.getTipoLente());

            }else if(oculosGenericoNome.equals("OculosEscuros")){
                OculosEscuros oculos = (OculosEscuros) model.get(produtoList.getSelectedIndex());

                modeloTextField.setText(oculos.getModelo());
                marcaTextField.setText(oculos.getMarca());
                precoTextField.setText(Double.toString(oculos.getPreco()));
                polarizadoTextField.setText(oculos.getPolarizado());

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
    }

    public void adicionarItem() {
        DefaultListModel<Oculos> model = (DefaultListModel<Oculos>)produtoList.getModel();
        String oculosGenericoNome = model.get(produtoList.getSelectedIndex()).getClass().getSimpleName();

        Double custoUnitario = Double.parseDouble(precoTextField.getText());
        int quantidade = Integer.parseInt(quantidadeTextField.getText());
        Double total = Double.parseDouble(valorTotalTextField.getText());

        if(oculosGenericoNome.equals("OculosGrauEscuro")){
            OculosGrauEscuro oculos = (OculosGrauEscuro) model.get(produtoList.getSelectedIndex());
            telaVenda.adicionaNovoItem(new Item(custoUnitario, quantidade, total, oculos));

        } else if(oculosGenericoNome.equals("OculosGrau")){
            OculosGrau oculos = (OculosGrau) model.get(produtoList.getSelectedIndex());
            telaVenda.adicionaNovoItem(new Item(custoUnitario, quantidade, total, oculos));

        }else if(oculosGenericoNome.equals("OculosEscuros")){
            OculosEscuros oculos = (OculosEscuros) model.get(produtoList.getSelectedIndex());
            telaVenda.adicionaNovoItem(new Item(custoUnitario, quantidade, total, oculos));
        }

    }
}
