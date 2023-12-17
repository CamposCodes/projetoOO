/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.updates;

import aula.lojaoculos.controller.venda.EditaVenda;
import aula.lojaoculos.controller.venda.RemoveVenda;
import aula.lojaoculos.controller.venda.SelecionaVendaEdicao;
import aula.lojaoculos.model.*;
import aula.lojaoculos.persistence.VendaPersistence;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewEditaRemoveVenda extends JFrame {
    private JPanel formPanel;
    private JButton editButton, removeButton;

    private VendaPersistence vendaPersistence = new VendaPersistence();
    private JTextField modeloTextField, marcaTextField, precoTextField, corLenteTextField, grauEsquerdaTextField, grauDireitaTextField, valorTotalTextField, quantidadeTextField, clienteNomeTextField, clienteCpfTextField, vendedorNomeTextField, vendedorCpfTextField;

    List<Venda> listaVendas;
    List<Funcionario> listaFuncionarios;

    JList<Venda> vendaJlist;
    JList<Funcionario> funcionarioJlist;
    JList<Item> itemJlist;

    public ViewEditaRemoveVenda() {

    }

    public void desenha(){setTitle("Edita e Remove Vendas");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        DefaultListModel<Venda> vendaListModel = new DefaultListModel<>();
        vendaJlist = new JList<>(vendaListModel);
        vendaJlist.addListSelectionListener(new SelecionaVendaEdicao(this));
        JScrollPane vendaListScrollPane = new JScrollPane(vendaJlist);
        vendaListScrollPane.setBounds(50, 10, 250, 300);
        vendaListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Vendas"));
        add(vendaListScrollPane);

        DefaultListModel<Funcionario> funcionarioDefaultListModel = new DefaultListModel<>();
        funcionarioJlist = new JList<>(funcionarioDefaultListModel);
        JScrollPane vendedorListScrollPane = new JScrollPane(funcionarioJlist);
        vendedorListScrollPane.setBounds(50, 340, 250, 150);
        vendedorListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Vendedores"));
        add(vendedorListScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(320, 10, 550, 630);
        formPanel.setBorder(BorderFactory.createTitledBorder("Editar/Remover Venda"));
        add(formPanel);

        DefaultListModel<Item> produtoListModel = new DefaultListModel<>();
        itemJlist = new JList<>(produtoListModel);
        JScrollPane produtoListScrollPane = new JScrollPane(itemJlist);
        produtoListScrollPane.setBounds(10, 20, 510, 300);
        produtoListScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Itens"));
        formPanel.add(produtoListScrollPane);

        valorTotalTextField = createTextField(160, 320, 370, 30);
        valorTotalTextField.setEditable(false);
        JLabel valorTotalLabel = addLabelToFrame("Valor Total:", 10, 320, 150, 30);
        formPanel.add(valorTotalLabel);


        clienteNomeTextField = createTextField(160, 370, 350, 30);
        clienteNomeTextField.setEditable(false);
        JLabel clienteNomeLabel = addLabelToFrame("Nome do Cliente:", 10, 370, 150, 30);
        formPanel.add(clienteNomeLabel);

        clienteCpfTextField = createTextField(160, 420, 350, 30);
        clienteCpfTextField.setEditable(false);
        JLabel clienteCpfLabel = addLabelToFrame("CPF do Cliente:", 10, 420, 150, 30);
        formPanel.add(clienteCpfLabel);

        vendedorNomeTextField = createTextField(160, 470, 350, 30);
        vendedorNomeTextField.setEditable(false);
        JLabel vendedorNomeLabel = addLabelToFrame("Vendedor:", 10, 470, 150, 30);
        formPanel.add(vendedorNomeLabel);

        vendedorCpfTextField = createTextField(160, 520, 350, 30);
        vendedorCpfTextField.setEditable(false);
        JLabel vendedorCpfLabel = addLabelToFrame("CPF do Vendedor:", 10, 520, 150, 30);
        formPanel.add(vendedorCpfLabel);

        // Botões Editar e Remover
        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        editButton = createButton("Editar", labelFont, Color.WHITE, Color.BLACK);
        editButton.addActionListener(new EditaVenda(this));
        editButton.setBounds(10, 570, 150, 30);
        formPanel.add(editButton);

        removeButton = createButton("Remover", labelFont, Color.WHITE, Color.BLACK);
        removeButton.addActionListener(new RemoveVenda(this));
        removeButton.setBounds(170, 570, 150, 30);
        formPanel.add(removeButton);

        setVisible(true);}

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
        formPanel.add(label);
        return label;
    }

    private JButton createButton(String text, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }

    public void editaVenda() {
        int selectedIndex = vendaJlist.getSelectedIndex();

        if(selectedIndex != -1 && funcionarioJlist.getSelectedIndex() != -1){
            DefaultListModel<Venda> model = (DefaultListModel<Venda>) vendaJlist.getModel();

            Venda venda = model.get(selectedIndex);
            Funcionario vendedor = funcionarioJlist.getSelectedValue();
            venda.setVendedor(vendedor);
            model.remove(selectedIndex);
            model.add(selectedIndex, venda);

            listaVendas();
            JOptionPane.showMessageDialog(null,"As alterações foram aplicadas!");
            vendaPersistence.save(listaVendas);
            vendedorNomeTextField.setText(vendedor.getNome());
            vendedorCpfTextField.setText(vendedor.getCpf());
        }

    }

    private void limpaCampos() {
        valorTotalTextField.setText(null);
        clienteNomeTextField.setText(null);
        clienteCpfTextField.setText(null);
        vendedorNomeTextField.setText(null);
        vendedorCpfTextField.setText(null);
    }

    public List<Venda> listaVendas() {
        DefaultListModel<Venda> model = (DefaultListModel<Venda>)vendaJlist.getModel();
        List<Venda> vendas = new ArrayList<Venda>();

        for (int i = 0; i < model.size(); i++) {
            vendas.add(model.get(i));
        }

        return vendas;
    }


    public void importaVendas(List<Venda> all, List<Funcionario> allFuncionario) {
        DefaultListModel<Venda> modelVenda = (DefaultListModel<Venda>)vendaJlist.getModel();

        for (Venda v: all) {
            modelVenda.addElement(v);
        }

        DefaultListModel<Funcionario> modelFuncionario = (DefaultListModel<Funcionario>)funcionarioJlist.getModel();

        for (Funcionario f: allFuncionario) {
            modelFuncionario.addElement(f);
        }

        if(all == null){
            this.listaVendas = new ArrayList<Venda>();
        }else{
            this.listaVendas = all;
        }

        if(allFuncionario == null){
            this.listaFuncionarios = new ArrayList<Funcionario>();
        }else{
            this.listaFuncionarios = allFuncionario;
        }
    }

    public void removeVenda() {
        if(vendaJlist.getSelectedIndex() != -1){
            DefaultListModel<Venda> model = (DefaultListModel<Venda>)vendaJlist.getModel();
            model.remove(vendaJlist.getSelectedIndex());

            listaVendas = listaVendas();
            vendaPersistence.save(listaVendas);
        }
        limpaCampos();
    }

    public void atualizaFormulario() {
        if(vendaJlist.getSelectedIndex() != -1){
            valorTotalTextField.setText(Double.toString(vendaJlist.getSelectedValue().getValor()));
            clienteNomeTextField.setText(vendaJlist.getSelectedValue().getCliente().getNome());
            clienteCpfTextField.setText(vendaJlist.getSelectedValue().getCliente().getCpf());
            vendedorNomeTextField.setText(vendaJlist.getSelectedValue().getVendedor().getNome());
            vendedorCpfTextField.setText(vendaJlist.getSelectedValue().getVendedor().getCpf());
        }
    }
}
