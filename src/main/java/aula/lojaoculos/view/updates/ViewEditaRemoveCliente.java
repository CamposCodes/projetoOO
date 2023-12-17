/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.updates;
import aula.lojaoculos.controller.cliente.EditaCliente;
import aula.lojaoculos.controller.cliente.RemoveCliente;
import aula.lojaoculos.controller.cliente.SelecionaClienteEdicao;
import aula.lojaoculos.controller.venda.SelecionarCliente;
import aula.lojaoculos.exceptions.*;
import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.model.Desconto;
import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.persistence.ClientePersistence;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewEditaRemoveCliente extends JFrame {

    private DefaultListModel<Cliente> clienteListModel;
    private JPanel formPanel;
    private JButton editButton, removeButton;
    private JTextField nomeTextField, dataTextField, emailTextField, cpfTextField, telefoneTextField;

    private ClientePersistence clientePersistence = new ClientePersistence();

    JList<Cliente> clienteJList;

    List<Cliente> listaClientes;

    public ViewEditaRemoveCliente() {

    }

    public void desenha(){
        setTitle("Edita e Remove Clientes");
        setSize(900, 600); // Aumento na altura da janela para acomodar os botões
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        clienteListModel = new DefaultListModel<>();
        clienteJList = new JList<>(clienteListModel);
        clienteJList.addListSelectionListener(new SelecionaClienteEdicao(this));
        JScrollPane listScrollPane = new JScrollPane(clienteJList);
        listScrollPane.setBounds(50, 50, 250, 500);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes")); // Adiciona uma borda com título
        add(listScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(300, 50, 550, 500);
        formPanel.setBorder(BorderFactory.createTitledBorder("Editar/Remover")); // Adiciona uma borda com título
        add(formPanel);

        addLabelToFrame("Nome:", 10, 20, 150, 30);
        nomeTextField = createTextField(160, 20, 350, 30);

        addLabelToFrame("Data:", 10, 70, 150, 30);
        dataTextField = createTextField(160, 70, 350, 30);
        dataTextField.setEditable(false);

        addLabelToFrame("Email:", 10, 120, 150, 30);
        emailTextField = createTextField(160, 120, 350, 30);

        addLabelToFrame("CPF:", 10, 170, 150, 30);
        cpfTextField = createTextField(160, 170, 350, 30);
        cpfTextField.setEditable(false);

        addLabelToFrame("Telefone:", 10, 220, 150, 30);
        telefoneTextField = createTextField(160, 220, 350, 30);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        editButton = createButton("Editar", labelFont, Color.WHITE, Color.BLACK);
        editButton.addActionListener(new EditaCliente(this));
        editButton.setBounds(10, 270, 200, 30);
        formPanel.add(editButton);

        removeButton = createButton("Remover", labelFont, Color.WHITE, Color.BLACK);
        removeButton.addActionListener(new RemoveCliente(this));
        removeButton.setBounds(230, 270, 200, 30);
        formPanel.add(removeButton);

        setVisible(true);
    }

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

    public void importaClientes(List<Cliente> all) {
        DefaultListModel<Cliente> modelCliente = (DefaultListModel<Cliente>)clienteJList.getModel();

        for (Cliente c: all) {
            modelCliente.addElement(c);
        }

        if(all == null){
            this.listaClientes = new ArrayList<Cliente>();
        }else{
            this.listaClientes = all;
        }
    }

    public void atualizaFormulario() {

        limpaCampos();

        if(clienteJList.getSelectedIndex() != -1){
            Cliente cliente = clienteJList.getSelectedValue();

            nomeTextField.setText(cliente.getNome());
            Date data = cliente.getDtNasc();
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);

            String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String ano = Integer.toString(cal.get(Calendar.YEAR));

            String dataFormatada = dia + "/" + mes + "/" + ano;

            dataTextField.setText(dataFormatada);
            emailTextField.setText(cliente.getEmail());
            cpfTextField.setText(cliente.getCpf());
            telefoneTextField.setText(cliente.getTelefone());
        }
    }

    public boolean validarCampos() throws Exception {
        String nome = nomeTextField.getText();
        String dataNascimento = dataTextField.getText();
        String email = emailTextField.getText();
        String cpf = cpfTextField.getText();
        String telefone = telefoneTextField.getText();

        // Expressões regulares para validação
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String regexNome = "^[A-Za-z ]+$";
        String regexTelefone = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$";
        String regexDataNascimento = "^\\d{2}/\\d{1,2}/\\d{4}$"; // Formato dd/MM/yyyy
        Pattern patternEmail = Pattern.compile(regexEmail);
        Pattern patternNome = Pattern.compile(regexNome);
        Pattern patternTelefone = Pattern.compile(regexTelefone);
        Pattern patternDataNascimento = Pattern.compile(regexDataNascimento);

        // Validando os campos com as expressões regulares
        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherNome = patternNome.matcher(nome);
        Matcher matcherTelefone = patternTelefone.matcher(telefone);
        Matcher matcherDataNascimento = patternDataNascimento.matcher(dataNascimento);

        if(clienteJList.getSelectedIndex() == -1){
            throw new CampoVazioException("Selecione um cliente antes de editar!");
        }

        if(nome.isBlank()){
            throw new CampoVazioException("O nome é obrigatório!");
        }

        if(!matcherEmail.matches()){
            throw new FormatoException("O email deve estar no formato: exemplo@exemplo.com");
        }

        if(!matcherNome.matches()){
            throw new NomeException("O nome deve conter somente letras!");
        }

        if(!matcherTelefone.matches()){
            throw new FormatoException("O telefone deve estar no formato (dd)ddddd-dddd");
        }

        if(!matcherDataNascimento.matches()){
            throw new FormatoException("A data deve estar no formato: dd/mm/aaaa");
        }

        if(!validarCpf(cpf)){
            throw new CpfException("CPF inválido!");
        }

        return true;
    }

    public static boolean validarCpf(String cpf) throws CpfException {

        String regexCpf = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        Pattern patternCpf = Pattern.compile(regexCpf);
        Matcher macherCpf = patternCpf.matcher(cpf);

        if(!macherCpf.matches()){
            throw new CpfException("O CPF deve estar no formato: ddd.ddd.ddd-dd");
        }

        // Removendo caracteres especiais e espaços em branco do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais, o que torna o CPF inválido
        boolean digitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = 11 - (soma % 11);
        int digitoVerificador1 = (resto == 10 || resto == 11) ? 0 : resto;

        // Verifica o primeiro dígito verificador
        if (digitoVerificador1 != (cpf.charAt(9) - '0')) {
            return false;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = 11 - (soma % 11);
        int digitoVerificador2 = (resto == 10 || resto == 11) ? 0 : resto;

        // Verifica o segundo dígito verificador
        return (digitoVerificador2 == (cpf.charAt(10) - '0'));
    }

    public boolean editaCliente() {

        try {
            if (validarCampos()) {

                int selectedIndex = clienteJList.getSelectedIndex();

                if(selectedIndex != -1) {

                    DefaultListModel<Cliente> model = (DefaultListModel<Cliente>) clienteJList.getModel();

                    Cliente cliente = model.get(selectedIndex);

                    String nome = nomeTextField.getText();
                    String dataDeNascimento = dataTextField.getText();
                    String email = emailTextField.getText();
                    String cpf = cpfTextField.getText();
                    String telefone = telefoneTextField.getText();

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                    Date data = null;
                    try {
                        data = formato.parse(dataDeNascimento);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    model.remove(selectedIndex);

                    cliente.setNome(nome);
                    cliente.setCpf(cpf);
                    cliente.setDtNasc(data);
                    cliente.setEmail(email);
                    cliente.setTelefone(telefone);

                    model.add(selectedIndex, cliente);
                    listaClientes();
                    JOptionPane.showMessageDialog(null,"As alterações foram aplicadas!");
                    clientePersistence.save(this.listaClientes);
                }
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void removeCliente(){
        if(clienteJList.getSelectedIndex() != -1){
            DefaultListModel<Cliente> model = (DefaultListModel<Cliente>)clienteJList.getModel();
            model.remove(clienteJList.getSelectedIndex());

            listaClientes = listaClientes();
            clientePersistence.save(listaClientes);
        }

        limpaCampos();
    }

    public List<Cliente> listaClientes(){
        DefaultListModel<Cliente> model = (DefaultListModel<Cliente>)clienteJList.getModel();
        List<Cliente> clientes = new ArrayList<Cliente>();

        for (int i = 0; i < model.size(); i++) {
            clientes.add(model.get(i));
        }

        return clientes;
    }



    public void limpaCampos(){
        nomeTextField.setText(null);
        dataTextField.setText(null);
        emailTextField.setText(null);
        cpfTextField.setText(null);
        telefoneTextField.setText(null);
    }
}
