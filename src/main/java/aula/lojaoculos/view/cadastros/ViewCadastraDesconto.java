package aula.lojaoculos.view.cadastros;

import aula.lojaoculos.controller.desconto.CadastrarDesconto;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.model.*;
import aula.lojaoculos.persistence.DescontoPersistence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewCadastraDesconto extends JFrame {
    private JTextField codigoText, porcentagemText, valorText, valorMinimoText;
    private JRadioButton cashbackRadioButton, cupomRadioButton;

    private final DescontoPersistence descontoPersistence = new DescontoPersistence();

    private ButtonGroup buttonGroup;

    private List<Desconto> listaDescontos;

    public ViewCadastraDesconto() {

    }

    public void desenha(){
        setLayout(null);
        setTitle("Cadastro de Desconto");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Color foregroundColor = new Color(237, 241, 238);
        Color backgroundColor = new Color(9, 10, 9);

        JLabel tipoLabel = new JLabel("Tipo de Desconto:");
        tipoLabel.setBounds(100, 80, 300, 30);
        tipoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(tipoLabel);

        cashbackRadioButton = new JRadioButton("Cashback");
        cashbackRadioButton.setBounds(270, 80, 100, 30);
        add(cashbackRadioButton);

        cupomRadioButton = new JRadioButton("Cupom");
        cupomRadioButton.setBounds(375, 80, 100, 30);
        add(cupomRadioButton);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(cashbackRadioButton);
        buttonGroup.add(cupomRadioButton);

        JLabel codigoLabel = new JLabel("Código do Cupom:");
        codigoLabel.setBounds(100, 130, 300, 30);
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        codigoLabel.hide();
        add(codigoLabel);


        codigoText = new JTextField();
        codigoText.setBounds(350, 130, 170, 30);
        codigoText.hide();
        add(codigoText);

        JLabel porcentagemLabel = new JLabel("Porcentagem de Cashback:");
        porcentagemLabel.setBounds(100, 180, 300, 30);
        porcentagemLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        porcentagemLabel.hide();
        add(porcentagemLabel);

        porcentagemText = new JTextField();
        porcentagemText.setBounds(350, 180, 250, 30);
        porcentagemText.hide();
        add(porcentagemText);

        JLabel valorLabel = new JLabel("Valor do Cupom:");
        valorLabel.setBounds(100, 180, 300, 30);
        valorLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        valorLabel.hide();
        add(valorLabel);

        valorText = new JTextField();
        valorText.setBounds(350, 180, 250, 30);
        valorText.hide();
        add(valorText);

        JLabel valorMinimoLabel = new JLabel("Valor Mínimo para uso: ");
        valorMinimoLabel.setBounds(100, 230, 300, 30);
        valorMinimoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        valorMinimoLabel.hide();
        add(valorMinimoLabel);

        valorMinimoText = new JTextField();
        valorMinimoText.setBounds(350, 230, 250, 30);
        valorMinimoText.hide();
        add(valorMinimoText);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(300, 350, 150, 40);
        cadastrarButton.setFont(buttonFont);
        cadastrarButton.setForeground(foregroundColor);
        cadastrarButton.setBackground(backgroundColor);
        cadastrarButton.addActionListener(new CadastrarDesconto(this));

        cashbackRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoLabel.show();
                codigoText.show();
                porcentagemLabel.show();
                porcentagemText.show();
                valorLabel.hide();
                valorText.hide();
                valorMinimoLabel.hide();
                valorMinimoText.hide();
            }
        }) ;

        cupomRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoLabel.show();
                codigoText.show();
                porcentagemLabel.hide();
                porcentagemText.hide();
                valorLabel.show();
                valorText.show();
                valorMinimoLabel.show();
                valorMinimoText.show();
            }
        }) ;

        add(cadastrarButton);

        setVisible(true);
    }

    public boolean cadastraDesconto() {
        try {
            if (validarCampos()) {

                String codigo = codigoText.getText();

                System.out.println(cashbackRadioButton.isSelected());

                if(cashbackRadioButton.isSelected()){
                    Double porcentagem = Double.parseDouble(porcentagemText.getText());

                    this.listaDescontos.add(new Cashback(codigo, porcentagem));
                    descontoPersistence.save(listaDescontos);
                } else if(cupomRadioButton.isSelected()){
                    Double valor = Double.parseDouble(valorText.getText());
                    Double valorMinimo = Double.parseDouble(valorMinimoText.getText());

                    this.listaDescontos.add(new Cupom(codigo, valor, valorMinimo));
                    descontoPersistence.save(listaDescontos);
                }

                return true;
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "O campo \"valor do cupom\", \"valor mínimo para uso\" e \"porcentagem de cashback\" são obrigatórios e devem estar no padrão: dd.dd", "Alerta", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private boolean validarCampos() throws Exception {

        String codigo = codigoText.getText();

        String regexNumeros = "\\d+.\\d{2}";

        Pattern patternNumeros = Pattern.compile(regexNumeros);

        Matcher porcentagemMatcher = patternNumeros.matcher(porcentagemText.getText());
        Matcher valorMatcher = patternNumeros.matcher(valorText.getText());
        Matcher valorMinimoMatcher = patternNumeros.matcher(valorMinimoText.getText());

        if(codigo.isBlank()){
            throw new CampoVazioException("O campo \"código\" é obrigatório");
        }

        if(cashbackRadioButton.isSelected()){

            if(!porcentagemMatcher.matches()){
                throw new FormatoException("O valor da porcentagem deve estar no formato: dd.dd");
            }
        } else if(cupomRadioButton.isSelected()){


            if(!valorMatcher.matches()){
                throw new FormatoException("O valor deve estar no formato: dd.dd");
            }

            if(!valorMinimoMatcher.matches()){
                throw new FormatoException("O valor mínimo deve estar no formato: dd.dd");
            }
        }

        return true;
    }


    public void importaDescontos(List<Desconto> all) {
        if(all == null){
            this.listaDescontos = new ArrayList<Desconto>();
        }else{
            this.listaDescontos = all;
        }
    }

    public List<Desconto> getDescontos() {
        return listaDescontos;
    }
}
