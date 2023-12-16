package aula.lojaoculos.view.cadastros;

import aula.lojaoculos.controller.item.JanelaItem;
import aula.lojaoculos.controller.venda.*;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.NaoEncontradoException;
import aula.lojaoculos.exceptions.ValorMinimoException;
import aula.lojaoculos.model.*;
import aula.lojaoculos.persistence.ClientePersistence;
import aula.lojaoculos.persistence.VendaPersistence;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class ViewCadastraVenda extends JFrame {

    private JPanel formPanel;
    private JTextField modeloTextField, marcaTextField, precoTextField, valorTotalTextField, quantidadeTextField, clienteNomeTextField, clienteCpfTextField, vendedorNomeTextField, vendedorCpfTextField, codigoCupomTextField, creditosDoClienteTextField;
    private JList<Cliente> clienteList;
    private JList<Funcionario> funcionarioList;
    private JList<Item> itemList;
    private JButton confirmarButton, adicionarProdutoButton, removerItemButton, calcularTotalButton;

    private List<Desconto> listaDescontos;
    private List<Cliente> listaClientes;

    private Desconto descontoSelecionadoAux;
    private List<Venda> listaVendas;

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
        codigoCupomTextField.addActionListener(new AdicionaCupom(this));
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
        calcularTotalButton.addActionListener(new CalculaTotal(this));
        calcularTotalButton.setBounds(335, 520, 175, 30);
        formPanel.add(calcularTotalButton);

        // Botões Confirmar, Adicionar Produto e Cancelar
        confirmarButton = createButton("Confirmar", labelFont, Color.WHITE, Color.BLACK);
        confirmarButton.addActionListener(new ConfirmarVenda(this));
        confirmarButton.setEnabled(false);
        confirmarButton.setBounds(10, 570, 150, 30);
        formPanel.add(confirmarButton);

        adicionarProdutoButton = createButton("Adicionar Item", labelFont, Color.WHITE, Color.BLACK);
        adicionarProdutoButton.setBounds(170, 570, 200, 30);
        adicionarProdutoButton.addActionListener(new AbreTelaAdiciona(this));


        formPanel.add(adicionarProdutoButton);

        removerItemButton = createButton("Remover Item", labelFont, Color.WHITE, Color.BLACK);
        removerItemButton.addActionListener(new RemoverItem(this));
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

    public void importaListas(List<Cliente> clientes, List<Funcionario> funcionarios, List<Desconto> descontos, List<Venda> vendas){
        DefaultListModel<Cliente> modelCliente = (DefaultListModel<Cliente>)clienteList.getModel();

        if(descontos == null){
            this.listaClientes = new ArrayList<Cliente>();
        }else{
            this.listaClientes = clientes;
        }

        for (Cliente c: clientes) {
            modelCliente.addElement(c);
        }

        DefaultListModel<Funcionario> modelFuncionario = (DefaultListModel<Funcionario>)funcionarioList.getModel();

        for (Funcionario f: funcionarios) {
            modelFuncionario.addElement(f);
        }

        if(descontos == null){
            this.listaDescontos = new ArrayList<Desconto>();
        }else{
            this.listaDescontos = descontos;
        }

        if(vendas == null){
            this.listaVendas = new ArrayList<Venda>();
        }else{
            this.listaVendas = vendas;
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
        DefaultListModel<Item> lista = (DefaultListModel<Item>) itemList.getModel();
        lista.addElement(item);
    }

    public void calculaTotal() {
        if(descontoSelecionadoAux == null){
            Double precoFinal = calculaValorTotalFinal();

            precoFinal = precoFinal - Double.parseDouble(creditosDoClienteTextField.getText());

            if(precoFinal < 0.0){
                precoFinal = 0.0;
            }

            if(Double.parseDouble(creditosDoClienteTextField.getText()) != 0.0){
                JOptionPane.showMessageDialog(null,"O cliente economizará R$" + creditosDoClienteTextField.getText() +" com essa compra com seus créditos!");
            }

            this.valorTotalTextField.setText(Double.toString(precoFinal));
        }else {
            calculaTotalDesconto();
        }

        confirmarButton.setEnabled(true);
    }

    public void calculaTotalDesconto(){

        Double precoFinal = calculaValorTotalFinal();

        String descontoGenericoNome = descontoSelecionadoAux.getClass().getSimpleName();

        if(descontoGenericoNome.equals("Cupom")){
            Double precoComDesconto = null;
            try {
                precoComDesconto = descontoSelecionadoAux.calculaDesconto(precoFinal);
            } catch (ValorMinimoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            }

            if(precoComDesconto < 0.){
                precoComDesconto = 0.0;
            }

            precoFinal = precoComDesconto;
        }

        this.valorTotalTextField.setText(Double.toString(precoFinal));

    }

    private Double calculaValorTotalFinal() {
        Double precoFinal = 0.0;

        ArrayList<Item> listaDeItens = new ArrayList<>();
        for(int i = 0; i< itemList.getModel().getSize();i++){
            listaDeItens.add(itemList.getModel().getElementAt(i));
        }

        for (Item item: listaDeItens) {
            precoFinal += item.getTotal();
        }

        return precoFinal;
    }

    public void removeItem() {
        try {
            DefaultListModel<Item> lista = (DefaultListModel<Item>) itemList.getModel();
            lista.remove(itemList.getSelectedIndex());
            limpaCamposOculos();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Selecione um item antes de remover!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void limpaCamposOculos(){
        modeloTextField.setText(null);
        marcaTextField.setText(null);
        precoTextField.setText(null);
        quantidadeTextField.setText(null);
    }


    public void adicionaCupom() throws NaoEncontradoException {
        for (Desconto desconto: listaDescontos) {
            if(desconto.getCodigo().equals(codigoCupomTextField.getText())){
                descontoSelecionadoAux = desconto;
                JOptionPane.showMessageDialog(null,"Cupom aplicado!");
                calculaTotal();
                return;
            }
        }

        throw new NaoEncontradoException("Cupom não encontrado!");

    }

    public void confirmarVenda() throws CampoVazioException {
        if(clienteList.getSelectedIndex() == -1){
            throw new CampoVazioException("O cliente não pode ser vazio!");
        }

        if(funcionarioList.getSelectedIndex() == -1){
            throw new CampoVazioException("O funcionário não pode ser vazio!");
        }

        if(itemList.getModel().getSize() == 0){
            throw new CampoVazioException("A lista de itens não pode estar vazia!");
        }

        if(valorTotalTextField.getText() == null){
            throw new CampoVazioException("Calcule o valor total antes de prosseguir!");
        }

        Double creditosCliente = Double.parseDouble(creditosDoClienteTextField.getText());

        for (Cliente cliente: listaClientes) {
            if(cliente.getCpf().equals(clienteCpfTextField.getText())){
                cliente.setCreditosNaLoja(0.0);
            }
        }

        if(descontoSelecionadoAux != null){
            String descontoGenericoNome = descontoSelecionadoAux.getClass().getSimpleName();

            if(descontoGenericoNome.equals("Cashback")){
                Double cashback = null;
                try {
                    cashback = descontoSelecionadoAux.calculaDesconto(Double.parseDouble(valorTotalTextField.getText()));
                } catch (ValorMinimoException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
                }

                JOptionPane.showMessageDialog(null,"O cliente ganhará R$"+ cashback + " em créditos com essa compra!" );

                for (Cliente cliente: listaClientes) {
                    if(cliente.getCpf().equals(clienteCpfTextField.getText())){
                        cliente.setCreditosNaLoja(cashback);
                    }
                }
            }
        }
        ClientePersistence clientePersistence = new ClientePersistence();
        clientePersistence.save(listaClientes);

        VendaPersistence vendaPersistence = new VendaPersistence();

        Double valorTotal = Double.parseDouble(valorTotalTextField.getText());
        Funcionario vendedor = funcionarioList.getSelectedValue();
        Cliente cliente = clienteList.getSelectedValue();
        String codigoDesconto = codigoCupomTextField.getText();
        listaVendas.add(new Venda(valorTotal, vendedor, cliente, codigoDesconto, creditosCliente, 0));

        vendaPersistence.save(listaVendas);
        this.dispose();
    }
}

