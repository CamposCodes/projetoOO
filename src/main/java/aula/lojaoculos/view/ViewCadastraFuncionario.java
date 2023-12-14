
package aula.lojaoculos.view;

import aula.lojaoculos.controller.funcionario.CadastrarFuncionario;
import aula.lojaoculos.exceptions.*;
import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.persistence.FuncionarioPersistence;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewCadastraFuncionario extends JFrame {

    private JTextField nomeTextField, dataNascimentoTextField, emailTextField, cpfTextField, telefoneTextField, cargoTextField, loginTextField;

    private JPasswordField senhaPasswordField;

    private JComboBox<String> cargoComboBox;

    private final FuncionarioPersistence funcionarioPersistence = new FuncionarioPersistence();
    private List<Funcionario> funcionarios;

    public ViewCadastraFuncionario() { }
    public void desenha(){
        setTitle("Cadastro de Vendedor");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2, 10, 10));

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nomeTextField = new JTextField();

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento:");
        dataNascimentoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dataNascimentoTextField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailTextField = new JTextField();

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        cpfTextField = new JTextField();

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        telefoneTextField = new JTextField();

        JLabel cargoLabel = new JLabel("Cargo:");
        cargoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        String[] cargos = {"Gerente", "Vendedor"};
        cargoComboBox = new JComboBox<>(cargos);


        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        loginTextField = new JTextField();

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        senhaPasswordField = new JPasswordField();

        JButton registrarButton = new JButton("Registrar");
        registrarButton.setFont(labelFont);
        registrarButton.setPreferredSize(new Dimension(150, 40));
        registrarButton.setForeground(Color.WHITE);
        registrarButton.setBackground(Color.BLACK);
        registrarButton.addActionListener(new CadastrarFuncionario(this));

        this.add(nomeLabel);
        this.add(nomeTextField);
        this.add(dataNascimentoLabel);
        this.add(dataNascimentoTextField);
        this.add(emailLabel);
        this.add(emailTextField);
        this.add(cpfLabel);
        this.add(cpfTextField);
        this.add(telefoneLabel);
        this.add(telefoneTextField);
        this.add(cargoLabel);
        this.add(cargoComboBox);
        this.add(loginLabel);
        this.add(loginTextField);
        this.add(senhaLabel);
        this.add(senhaPasswordField);
        this.add(registrarButton);

        setVisible(true);
    }

    public boolean validarCampos() throws Exception {
        String nome = nomeTextField.getText();
        String dataNascimento = dataNascimentoTextField.getText();
        String email = emailTextField.getText();
        String cpf = cpfTextField.getText();
        String telefone = telefoneTextField.getText();
        String login = loginTextField.getText();
        String senha = senhaPasswordField.getText();

        // Expressões regulares para validação
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String regexNome = "^[A-Za-z ]+$";
        String regexTelefone = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$";
        String regexDataNascimento = "^\\d{2}/\\d{2}/\\d{4}$"; // Formato dd/MM/yyyy
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

        if(!matcherEmail.matches()){
            throw new EmailException("O email deve estar no formato: exemplo@exemplo.com");
        }

        if(!matcherNome.matches()){
            throw new NomeException("O nome deve conter somente letras!");
        }

        if(!matcherTelefone.matches()){
            throw new TelefoneException("O telefone deve estar no formato (dd)ddddd-dddd");
        }

        if(!matcherDataNascimento.matches()){
            throw new DataException("A data deve estar no formato: dd/mm/aaaa");
        }

        if(!validarCpf(cpf)){
            throw new CpfException("CPF inválido!");
        }

        if(login.isBlank()){
            throw new CampoVazioException("O campo LOGIN é obrigatório");
        }

        if(senha.isBlank()){
            throw new CampoVazioException("O campo SENHA é obrigatório");
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

    public boolean cadastraFuncionario() {

        try {
            if(validarCampos()){
                String nome = nomeTextField.getText();
                String dataDeNascimento = dataNascimentoTextField.getText();
                String email = emailTextField.getText();
                String cpf = cpfTextField.getText();
                String telefone = telefoneTextField.getText();
                String cargo = (String) cargoComboBox.getSelectedItem();
                String login = loginTextField.getText();
                String senha = senhaPasswordField.getText();

                for (Funcionario funcionario:funcionarios) {
                    if(login.equals(funcionario.getLogin())){
                        throw new JaCadastradoException("Esse login já está em uso!");
                    }
                }

                for (Funcionario funcionario:funcionarios) {
                    if(cpf.equals(funcionario.getCpf())){
                        throw new JaCadastradoException("Já existe um funcionário com esse CPF!");
                    }
                }

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                Date data = null;
                try {
                    data = formato.parse(dataDeNascimento);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                funcionarios.add(new Funcionario(nome, data, email, cpf, telefone, cargo, login, senha));
                funcionarioPersistence.save(this.funcionarios);

                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public void importaFuncionarios(List<Funcionario> all) {
        if(all == null){
            this.funcionarios = new ArrayList<Funcionario>();
        }else{
            this.funcionarios = all;
        }
    }


    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
