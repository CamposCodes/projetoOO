/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.updates;

import aula.lojaoculos.controller.desconto.EditaDesconto;
import aula.lojaoculos.controller.desconto.RemoveDesconto;
import aula.lojaoculos.controller.desconto.SelecionaDescontoEdicao;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.model.Cashback;
import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.model.Cupom;
import aula.lojaoculos.model.Desconto;
import aula.lojaoculos.persistence.DescontoPersistence;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewEditaRemoveDesconto extends JFrame {
    private JTextField codigoText, porcentagemText, valorText, valorMinimoText;
    private JPanel formPanel, discountPanel; // Adição de um novo painel para descontos
    private JLabel codigoLabel, porcentagemLabel, valorLabel, valorMinimoLabel;
    private JList<Desconto> descontosJList; // Lista para exibir os descontos cadastrados

    private DescontoPersistence descontoPersistence = new DescontoPersistence();

    private List<Desconto> listaDescontos;


    public ViewEditaRemoveDesconto() {

    }

    public void desenha(){setTitle("Edita e Remove Descontos");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        discountPanel = new JPanel(); // Novo painel para os descontos
        discountPanel.setLayout(new BorderLayout());
        discountPanel.setBounds(10, 50, 300, 500); // Posição e tamanho do painel de desconto
        discountPanel.setBorder(BorderFactory.createTitledBorder("Descontos")); // Adiciona uma borda com título
        add(discountPanel);

        // Adicionando a lista de descontos ao novo painel à esquerda
        DefaultListModel<Desconto> descontoDefaultListModel = new DefaultListModel<>();
        descontosJList = new JList<>(descontoDefaultListModel); // Substitua com seus próprios dados
        descontosJList.addListSelectionListener(new SelecionaDescontoEdicao(this));
        JScrollPane scrollPane = new JScrollPane(descontosJList);
        scrollPane.setPreferredSize(new Dimension(280, 500)); // Ajuste o tamanho conforme necessário
        discountPanel.add(scrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(320, 50, 570, 500); // Posição e tamanho do painel de formulário
        formPanel.setBorder(BorderFactory.createTitledBorder("Editar/Remover")); // Adiciona uma borda com título
        add(formPanel);

        codigoLabel = new JLabel("Código do Desconto:");
        codigoLabel.setBounds(50, 120, 200, 30);
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(codigoLabel);

        codigoText = createTextField(260, 120, 170, 30);
        codigoText.setEditable(false);

        porcentagemLabel = new JLabel("Porcentagem Cashback:");
        porcentagemLabel.setBounds(50, 170, 250, 30);
        porcentagemLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(porcentagemLabel);

        porcentagemText = createTextField(260, 170, 250, 30);

        valorLabel = new JLabel("Valor do Cupom:");
        valorLabel.setBounds(50, 220, 200, 30);
        valorLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(valorLabel);

        valorText = createTextField(260, 220, 250, 30);

        valorMinimoLabel = new JLabel("Valor Mínimo para Uso:");
        valorMinimoLabel.setBounds(50, 270, 200, 30);
        valorMinimoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        formPanel.add(valorMinimoLabel);

        valorMinimoText = createTextField(260, 270, 250, 30);

        // Botões editar e remover

        JButton editarButton = createButton("Editar", new Font("Arial", Font.PLAIN, 16), Color.WHITE, Color.BLACK);
        editarButton.addActionListener(new EditaDesconto(this));

        editarButton.setBounds(10, 420, 200, 30);
        formPanel.add(editarButton);

        JButton removerButton = createButton("Remover", new Font("Arial", Font.PLAIN, 16), Color.WHITE, Color.BLACK);
        removerButton.addActionListener(new RemoveDesconto(this));
        removerButton.setBounds(230, 420, 200, 30);
        formPanel.add(removerButton);

        setVisible(true);}

    private void showCashbackFields() {
        valorLabel.setVisible(false);
        valorText.setVisible(false);
        valorMinimoLabel.setVisible(false);
        valorMinimoText.setVisible(false);

        porcentagemLabel.setVisible(true);
        porcentagemText.setVisible(true);
    }

    private void showCupomFields() {
        porcentagemLabel.setVisible(false);
        porcentagemText.setVisible(false);

        valorLabel.setVisible(true);
        valorText.setVisible(true);
        valorMinimoLabel.setVisible(true);
        valorMinimoText.setVisible(true);
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        formPanel.add(textField);
        return textField;
    }

    private JRadioButton createRadioButton(String text, int x, int y, int width, int height) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, width, height);
        formPanel.add(radioButton);
        return radioButton;
    }

    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }

    public void importaDesconto(List<Desconto> all) {
        DefaultListModel<Desconto> modelDesconto = (DefaultListModel<Desconto>)descontosJList.getModel();

        for (Desconto c: all) {
            modelDesconto.addElement(c);
        }

        if(all == null){
            this.listaDescontos = new ArrayList<Desconto>();
        }else{
            this.listaDescontos = all;
        }
    }

    public List<Desconto> listaDescontos() {
        DefaultListModel<Desconto> model = (DefaultListModel<Desconto>)descontosJList.getModel();
        List<Desconto> descontos = new ArrayList<Desconto>();

        for (int i = 0; i < model.size(); i++) {
            descontos.add(model.get(i));
        }

        return descontos;
    }

    public void atualizaFormulario() {
        if(descontosJList.getSelectedIndex() != -1){
            limpaCampos();
            String tipoDesconto = descontosJList.getSelectedValue().getTipo();

            if(tipoDesconto.equals("Cashback")){
                Cashback desconto = (Cashback) descontosJList.getSelectedValue();
                showCashbackFields();
                codigoText.setText(desconto.getCodigo());
                porcentagemText.setText(Double.toString(desconto.getPorcentagem()));
            }else {
                Cupom desconto = (Cupom) descontosJList.getSelectedValue();
                showCupomFields();
                codigoText.setText(desconto.getCodigo());
                valorText.setText(Double.toString(desconto.getValorDoCupom()));
                valorMinimoText.setText(Double.toString(desconto.getValorMinimoUso()));
            }
        }
    }

    private boolean validarCampos() throws Exception {

        String codigo = codigoText.getText();

        String regexNumeros = "\\d+.\\d{2}";

        Pattern patternNumeros = Pattern.compile(regexNumeros);

        Matcher porcentagemMatcher = patternNumeros.matcher(porcentagemText.getText());
        Matcher valorMatcher = patternNumeros.matcher(valorText.getText());
        Matcher valorMinimoMatcher = patternNumeros.matcher(valorMinimoText.getText());

        if(descontosJList.getSelectedValue().getTipo().equals("Cashback")){

            if(!porcentagemMatcher.matches()){
                throw new FormatoException("O valor da porcentagem deve estar no formato: dd.dd");
            }
        } else if(descontosJList.getSelectedValue().getTipo().equals("Cupom")){


            if(!valorMatcher.matches()){
                throw new FormatoException("O valor deve estar no formato: dd.dd");
            }

            if(!valorMinimoMatcher.matches()){
                throw new FormatoException("O valor mínimo deve estar no formato: dd.dd");
            }
        }

        return true;
    }

    public void editaDesconto() {
        try {
            if(validarCampos()){

                int selectedIndex = descontosJList.getSelectedIndex();

                DefaultListModel<Desconto> model = (DefaultListModel<Desconto>) descontosJList.getModel();

                if(descontosJList.getSelectedValue().getTipo().equals("Cashback")){
                    Cashback desconto = (Cashback) model.get(selectedIndex);
                    Double porcentagem = Double.parseDouble(porcentagemText.getText());
                    desconto.setPorcentagem(porcentagem);
                    model.remove(selectedIndex);
                    model.add(selectedIndex, desconto);
                }else {
                    Cupom desconto = (Cupom) model.get(selectedIndex);
                    Double valor = Double.parseDouble(valorText.getText());
                    Double valorMinimo = Double.parseDouble(valorMinimoText.getText());
                    desconto.setValorDoCupom(valor);
                    desconto.setValorMinimoUso(valorMinimo);
                    model.remove(selectedIndex);
                    model.add(selectedIndex, desconto);
                }


                listaDescontos();
                JOptionPane.showMessageDialog(null,"As alterações foram aplicadas!");
                descontoPersistence.save(this.listaDescontos);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeDesconto() {
        if(descontosJList.getSelectedIndex() != -1){
            DefaultListModel<Desconto> model = (DefaultListModel<Desconto>)descontosJList.getModel();
            model.remove(descontosJList.getSelectedIndex());

            listaDescontos = listaDescontos();
            descontoPersistence.save(listaDescontos);
        }
        limpaCampos();
    }

    private void limpaCampos(){
        codigoText.setText(null);
        porcentagemText.setText(null);
        valorText.setText(null);
        valorMinimoText.setText(null);
    }
}
