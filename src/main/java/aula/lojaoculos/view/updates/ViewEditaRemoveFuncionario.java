/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.view.updates;

import aula.lojaoculos.controller.funcionario.EditaFuncionario;
import aula.lojaoculos.controller.funcionario.RemoveFuncionario;
import aula.lojaoculos.controller.funcionario.SelecionaFuncionarioEdicao;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.CpfException;
import aula.lojaoculos.exceptions.FormatoException;
import aula.lojaoculos.exceptions.NomeException;
import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.model.Desconto;
import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.persistence.FuncionarioPersistence;

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

public class ViewEditaRemoveFuncionario extends JFrame {
    private DefaultListModel<Funcionario> funcionarioListModel;
    private JPanel formPanel;
    private JButton editButton, removeButton;
    private JTextField nomeTextField, dataNascimentoTextField, emailTextField, cpfTextField, telefoneTextField, loginTextField, senhaTextField;
    private JComboBox<String> cargoComboBox;

    private FuncionarioPersistence funcionarioPersistence = new FuncionarioPersistence();
    private List<Funcionario> listaFuncionario;
    private JList<Funcionario> funcionarioJlist;

    public ViewEditaRemoveFuncionario() {

    }

    public void desenha(){
        setTitle("Edita e Remove Vendedores");
        setSize(900, 600); // Aumento na altura da janela para acomodar os botões
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        funcionarioListModel = new DefaultListModel<>();
        funcionarioJlist = new JList<>(funcionarioListModel);
        funcionarioJlist.addListSelectionListener(new SelecionaFuncionarioEdicao(this));
        JScrollPane listScrollPane = new JScrollPane(funcionarioJlist);
        listScrollPane.setBounds(50, 50, 250, 500);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Funcionários")); // Adiciona uma borda com título
        add(listScrollPane);

        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(300, 50, 550, 500);
        formPanel.setBorder(BorderFactory.createTitledBorder("Editar/Remover")); // Adiciona uma borda com título
        add(formPanel);

        addLabelToFrame("Nome:", 10, 20, 150, 30);
        nomeTextField = createTextField(160, 20, 350, 30);

        addLabelToFrame("Data de Nascimento:", 10, 70, 150, 30);
        dataNascimentoTextField = createTextField(160, 70, 350, 30);
        dataNascimentoTextField.setEditable(false);

        addLabelToFrame("Email:", 10, 120, 150, 30);
        emailTextField = createTextField(160, 120, 350, 30);

        addLabelToFrame("CPF:", 10, 170, 150, 30);
        cpfTextField = createTextField(160, 170, 350, 30);
        cpfTextField.setEditable(false);

        addLabelToFrame("Telefone:", 10, 220, 150, 30);
        telefoneTextField = createTextField(160, 220, 350, 30);

        addLabelToFrame("Login:", 10, 270, 150, 30);
        loginTextField = createTextField(160, 270, 350, 30);
        loginTextField.setEditable(false);

        addLabelToFrame("Senha:", 10, 320, 150, 30);
        senhaTextField = createTextField(160, 320, 350, 30);

        addLabelToFrame("Cargo:", 10, 370, 150, 30);
        String[] opcoesCargo = {"Gerente", "Vendedor"};
        cargoComboBox = new JComboBox<>(opcoesCargo);
        cargoComboBox.setBounds(160, 370, 350, 30);
        formPanel.add(cargoComboBox);

        Font labelFont = new Font("Arial", Font.PLAIN, 16);

        editButton = createButton("Editar", labelFont, Color.WHITE, Color.BLACK);
        editButton.addActionListener(new EditaFuncionario(this));
        editButton.setBounds(10, 420, 200, 30);
        formPanel.add(editButton);

        removeButton = createButton("Remover", labelFont, Color.WHITE, Color.BLACK);
        removeButton.addActionListener(new RemoveFuncionario(this));
        removeButton.setBounds(230, 420, 200, 30);
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

    public void editaFuncionario() {

        try {
            if (validarCampos()) {

                int selectedIndex = funcionarioJlist.getSelectedIndex();

                if(selectedIndex != -1) {

                    DefaultListModel<Funcionario> model = (DefaultListModel<Funcionario>) funcionarioJlist.getModel();

                    Funcionario funcionario = model.get(selectedIndex);

                    String nome = nomeTextField.getText();
                    String email = emailTextField.getText();
                    String telefone = telefoneTextField.getText();
                    String cargo = (String) cargoComboBox.getSelectedItem();

                    model.remove(selectedIndex);

                    funcionario.setNome(nome);
                    funcionario.setEmail(email);
                    funcionario.setTelefone(telefone);
                    funcionario.setCargo(cargo);

                    if(!senhaTextField.getText().isBlank()){
                        funcionario.setSenha(senhaTextField.getText());
                    }

                    model.add(selectedIndex, funcionario);
                    listaFuncionario();
                    JOptionPane.showMessageDialog(null,"As alterações foram aplicadas!");
                    funcionarioPersistence.save(this.listaFuncionario);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean validarCampos() throws Exception {
        String nome = nomeTextField.getText();
        String dataNascimento = dataNascimentoTextField.getText();
        String email = emailTextField.getText();
        String cpf = cpfTextField.getText();
        String telefone = telefoneTextField.getText();
        String login = loginTextField.getText();
        String senha = senhaTextField.getText();

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

        if(nome.isBlank()){
            throw new CampoVazioException("O nome é obrigatório!");
        }

        if(!matcherNome.matches()){
            throw new NomeException("O nome deve conter somente letras!");
        }

        if(!matcherTelefone.matches()){
            throw new FormatoException("O telefone deve estar no formato (dd)ddddd-dddd");
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


    public void importaFuncionario(List<Funcionario> all) {
        DefaultListModel<Funcionario> modelDesconto = (DefaultListModel<Funcionario>)funcionarioJlist.getModel();

        for (Funcionario c: all) {
            modelDesconto.addElement(c);
        }

        if(all == null){
            this.listaFuncionario = new ArrayList<Funcionario>();
        }else{
            this.listaFuncionario = all;
        }
    }

    public List<Funcionario> listaFuncionario() {
        DefaultListModel<Funcionario> model = (DefaultListModel<Funcionario>)funcionarioJlist.getModel();
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        for (int i = 0; i < model.size(); i++) {
            funcionarios.add(model.get(i));
        }

        return funcionarios;
    }

    public void removeFuncionario() {
        if(funcionarioJlist.getSelectedIndex() != -1){
            DefaultListModel<Funcionario> model = (DefaultListModel<Funcionario>)funcionarioJlist.getModel();
            model.remove(funcionarioJlist.getSelectedIndex());

            listaFuncionario = listaFuncionario();
            funcionarioPersistence.save(listaFuncionario);
        }
        limpaCampos();
    }

    private void limpaCampos() {
        nomeTextField.setText(null);
        dataNascimentoTextField.setText(null);
        emailTextField.setText(null);
        cpfTextField.setText(null);
        telefoneTextField.setText(null);
        loginTextField.setText(null);
        senhaTextField.setText(null);
    }

    public void atualizaFormulario() {

        limpaCampos();

        if(funcionarioJlist.getSelectedIndex() != -1){
            Funcionario funcionario = funcionarioJlist.getSelectedValue();

            nomeTextField.setText(funcionario.getNome());
            Date data = funcionario.getDtNasc();
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);

            String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(cal.get(Calendar.MONTH) + 1);
            String ano = Integer.toString(cal.get(Calendar.YEAR));

            String dataFormatada = dia + "/" + mes + "/" + ano;

            dataNascimentoTextField.setText(dataFormatada);
            emailTextField.setText(funcionario.getEmail());
            cpfTextField.setText(funcionario.getCpf());
            telefoneTextField.setText(funcionario.getTelefone());
            loginTextField.setText(funcionario.getLogin());
            if(funcionario.getCargo().equals("Gerente")){
                cargoComboBox.setSelectedIndex(0);
            }else {
                cargoComboBox.setSelectedIndex(1);
            }
        }
    }
}
