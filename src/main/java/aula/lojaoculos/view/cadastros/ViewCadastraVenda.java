package aula.lojaoculos.view.cadastros;

import aula.lojaoculos.controller.item.JanelaItem;
import aula.lojaoculos.controller.venda.AbreTelaAdiciona;
import aula.lojaoculos.controller.venda.SelecionarCliente;
import aula.lojaoculos.controller.venda.SelecionarFuncionario;
import aula.lojaoculos.controller.venda.SelecionarItem;
import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.model.Item;
import aula.lojaoculos.model.Oculos;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCadastraVenda extends JFrame {

//    private DefaultListModel<String> produtoListModel, clienteListModel, vendedorListModel;



    private JPanel formPanel;
    private JTextField modeloTextField, marcaTextField, precoTextField, valorTotalTextField, quantidadeTextField, clienteNomeTextField, clienteCpfTextField, vendedorNomeTextField, vendedorCpfTextField, codigoCupomTextField, creditosDoClienteTextField;
    private JList<Cliente> clienteList;
    private JList<Funcionario> funcionarioList;
    private JList<Item> itemList;
    private JButton confirmarButton, adicionarProdutoButton, removerItemButton, calcularTotalButton;

    public ViewCadastraVenda() {

    }

    public void desenha(){
        setTitle("Cadastrar Venda");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        DefaultListModel<Item> modelItem = new DefaultListModel<>();
        itemList = new JList<Item>(modelItem);
        itemList.addListSelectionListener(new SelecionarItem(this));
        JScrollPane produtoListScrollPane = new JScrollPane(itemList);
        produtoListScrollPane.setBounds(50, 50, 250, 150);
        produtoListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Itens"));
        add(produtoListScrollPane);

        DefaultListModel<Cliente> modelCliente = new DefaultListModel<>();
        clienteList = new JList<>(modelCliente);
        clienteList.addListSelectionListener(new SelecionarCliente(this));
        JScrollPane clienteListScrollPane = new JScrollPane(clienteList);
        clienteListScrollPane.setBounds(50, 220, 250, 150);
        clienteListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
        add(clienteListScrollPane);

        DefaultListModel<Funcionario> modelFuncionario = new DefaultListModel<>();
        funcionarioList = new JList<>(modelFuncionario);
        funcionarioList.addListSelectionListener(new SelecionarFuncionario(this));
        JScrollPane vendedorListScrollPane = new JScrollPane(funcionarioList);
        vendedorListScrollPane.setBounds(50, 390, 250, 150);
        vendedorListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Vendedores"));
        add(vendedorListScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(320, 50, 550, 600);
        formPanel.setBorder(BorderFactory.createTitledBorder("Formulário"));
        add(formPanel);

        modeloTextField = createTextField(160, 20, 350, 30);
        modeloTextField.setEditable(false);
        JLabel modeloLabel = addLabelToFrame("Modelo:", 10, 20, 150, 30);
        formPanel.add(modeloLabel);

        marcaTextField = createTextField(160, 70, 350, 30);
        marcaTextField.setEditable(false);
        JLabel marcaLabel = addLabelToFrame("Marca:", 10, 70, 150, 30);
        formPanel.add(marcaLabel);

        precoTextField = createTextField(160, 120, 350, 30);
        precoTextField.setEditable(false);
        JLabel precoLabel = addLabelToFrame("Preço:", 10, 120, 150, 30);
        formPanel.add(precoLabel);

        quantidadeTextField = createTextField(160, 170, 350, 30);
        quantidadeTextField.setEditable(false);
        JLabel quantidadeLabel = addLabelToFrame("Quantidade:", 10, 170, 150, 30);
        formPanel.add(quantidadeLabel);

        clienteNomeTextField = createTextField(160, 220, 350, 30);
        clienteNomeTextField.setEditable(false);
        JLabel clienteNomeLabel = addLabelToFrame("Nome do Cliente:", 10, 220, 150, 30);
        formPanel.add(clienteNomeLabel);

        clienteCpfTextField = createTextField(160, 270, 350, 30);
        clienteCpfTextField.setEditable(false);
        JLabel clienteCpfLabel = addLabelToFrame("CPF do Cliente:", 10, 270, 150, 30);
        formPanel.add(clienteCpfLabel);

        vendedorNomeTextField = createTextField(160, 320, 350, 30);
        vendedorNomeTextField.setEditable(false);
        JLabel vendedorNomeLabel = addLabelToFrame("Nome do Vendedor:", 10, 320, 150, 30);
        formPanel.add(vendedorNomeLabel);

        vendedorCpfTextField = createTextField(160, 370, 350, 30);
        vendedorCpfTextField.setEditable(false);
        JLabel vendedorCpfLabel = addLabelToFrame("CPF do Vendedor:", 10, 370, 150, 30);
        formPanel.add(vendedorCpfLabel);

        codigoCupomTextField = createTextField(160, 420, 350, 30);
        JLabel codigoCupomLabel = addLabelToFrame("Código de Cupom:", 10, 420, 150, 30);
        formPanel.add(codigoCupomLabel);

        creditosDoClienteTextField = createTextField(160, 470, 175, 30);
        creditosDoClienteTextField.setEditable(false);
        JLabel creditosDoClienteLabel = addLabelToFrame("Créditos do cliente:", 10, 470, 150, 30);
        formPanel.add(creditosDoClienteLabel);

        valorTotalTextField = createTextField(160, 520, 175, 30);
        valorTotalTextField.setEditable(false);
        JLabel valorTotalLabel = addLabelToFrame("Total:", 10, 520, 150, 30);
        formPanel.add(valorTotalLabel);

        calcularTotalButton = createButton("Calcular Total", labelFont, Color.WHITE, Color.BLACK);
        calcularTotalButton.setBounds(335, 520, 175, 30);
        formPanel.add(calcularTotalButton);

        // Botões Confirmar, Adicionar Produto e Cancelar
        confirmarButton = createButton("Confirmar", labelFont, Color.WHITE, Color.BLACK);
        confirmarButton.setEnabled(false);
        confirmarButton.setBounds(10, 570, 150, 30);
        formPanel.add(confirmarButton);

        adicionarProdutoButton = createButton("Adicionar Item", labelFont, Color.WHITE, Color.BLACK);
        adicionarProdutoButton.setBounds(170, 570, 200, 30);
        adicionarProdutoButton.addActionListener(new AbreTelaAdiciona(this));


        formPanel.add(adicionarProdutoButton);

        removerItemButton = createButton("Remover Item", labelFont, Color.WHITE, Color.BLACK);
        removerItemButton.setBounds(380, 570, 150, 30);
        formPanel.add(removerItemButton);

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

    public void importaListas(List<Cliente> clientes, List<Funcionario> funcionarios){
        DefaultListModel<Cliente> modelCliente = (DefaultListModel<Cliente>)clienteList.getModel();

        for (Cliente c: clientes) {
            modelCliente.addElement(c);
        }

        DefaultListModel<Funcionario> modelFuncionario = (DefaultListModel<Funcionario>)funcionarioList.getModel();

        for (Funcionario f: funcionarios) {
            modelFuncionario.addElement(f);
        }


    }

    public void abreTelaItem(){
        ViewAdicionaProduto tela = new ViewAdicionaProduto(this);
        tela.addWindowListener(new JanelaItem(tela));
        tela.desenha();
    }

    public void atualizarCampos() {
        if(clienteList.getSelectedIndex() != -1){
            DefaultListModel<Cliente> model = (DefaultListModel<Cliente>)clienteList.getModel();
            Cliente cliente = model.get(clienteList.getSelectedIndex());

            clienteNomeTextField.setText(cliente.getNome());
            clienteCpfTextField.setText(cliente.getCpf());
            creditosDoClienteTextField.setText(Double.toString(cliente.getCreditosNaLoja()));
        }

        if(funcionarioList.getSelectedIndex() != -1){
            DefaultListModel<Funcionario> model = (DefaultListModel<Funcionario>)funcionarioList.getModel();
            Funcionario funcionario = model.get(funcionarioList.getSelectedIndex());

            vendedorNomeTextField.setText(funcionario.getNome());
            vendedorCpfTextField.setText(funcionario.getCpf());
        }

        if(itemList.getSelectedIndex() != -1){
            DefaultListModel<Item> model = (DefaultListModel<Item>)itemList.getModel();
            Item item = model.get(itemList.getSelectedIndex());

            marcaTextField.setText(item.getProduto().getMarca());
            modeloTextField.setText(item.getProduto().getModelo());
            precoTextField.setText(Double.toString(item.getTotal()));
            quantidadeTextField.setText(Integer.toString(item.getQuantidade()));
        }
    }

    public void adicionaNovoItem(Item item){

    }
}
