package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.event.*;

public class ViewCadastraVenda extends JFrame {
    JTextField valorText, dataText, quantidadeText, codigoDescontoText, valorDescontoText, creditosUtilizadosText;
    JTable tabelaItens;
    JComboBox<String> listaProdutos, listaClientes;
    JButton cadastrarItemButton, criarNovoClienteButton, calcularButton, confirmarVendaButton;
    JLabel labelValor;

    public ViewCadastraVenda() {
        setTitle("Cadastro de Venda");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        // Campo para o valor da venda
        labelValor = new JLabel("Valor:");
        labelValor.setBounds(50, 50, 100, 30);
        add(labelValor);

        valorText = new JTextField();
        valorText.setBounds(150, 50, 200, 30);
        add(valorText);

        // Campo para a data
        JLabel labelData = new JLabel("Data:");
        labelData.setBounds(50, 90, 100, 30);
        add(labelData);

        dataText = new JTextField();
        dataText.setBounds(150, 90, 200, 30);
        add(dataText);

        // Campo para o cupom de desconto
        JLabel labelCodigoDesconto = new JLabel("Cupom de Desconto:");
        labelCodigoDesconto.setBounds(50, 130, 150, 30);
        add(labelCodigoDesconto);

        codigoDescontoText = new JTextField();
        codigoDescontoText.setBounds(200, 130, 150, 30);
        add(codigoDescontoText);

        // Campo para o valor do desconto
        JLabel labelValorDesconto = new JLabel("Valor do Desconto:");
        labelValorDesconto.setBounds(50, 170, 150, 30);
        add(labelValorDesconto);

        valorDescontoText = new JTextField();
        valorDescontoText.setBounds(200, 170, 150, 30);
        add(valorDescontoText);

        // Campo para os créditos utilizados pelo cliente
        JLabel labelCreditosUtilizados = new JLabel("Créditos Utilizados:");
        labelCreditosUtilizados.setBounds(50, 210, 150, 30);
        add(labelCreditosUtilizados);

        creditosUtilizadosText = new JTextField();
        creditosUtilizadosText.setBounds(200, 210, 150, 30);
        add(creditosUtilizadosText);

        // Botões existentes
        cadastrarItemButton = new JButton("Cadastrar Item");
        cadastrarItemButton.setBounds(50, 400, 150, 30);
        cadastrarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para cadastrar um item na tabela de itens
            }
        });
        add(cadastrarItemButton);

        criarNovoClienteButton = new JButton("Novo Cliente");
        criarNovoClienteButton.setBounds(250, 400, 150, 30);
        criarNovoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para abrir a tela de cadastro de novo cliente
            }
        });
        add(criarNovoClienteButton);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(50, 450, 150, 30);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para calcular valores
            }
        });
        add(calcularButton);

        confirmarVendaButton = new JButton("Confirmar Venda");
        confirmarVendaButton.setBounds(250, 450, 150, 30);
        confirmarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para confirmar a venda
            }
        });
        add(confirmarVendaButton);

        setVisible(true);
    }
}
