package aula.lojaoculos.view.cadastros;

import aula.lojaoculos.controller.cliente.CadastrarCliente;
import aula.lojaoculos.controller.cliente.JanelaCliente;
import aula.lojaoculos.exceptions.*;
import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.persistence.ClientePersistence;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

  public class ViewCadastraCliente extends JFrame {
    JTextField nomeText, dataNascimentoText, emailText, cpfText, telefoneText;

    private final ClientePersistence clientePersistence = new ClientePersistence();
    private List<Cliente> clientes;

    public ViewCadastraCliente() { }

    public void desenha(){
        setLayout(null);
        setTitle("Cadastro de Cliente");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Cadastro de Cliente");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(250, 10, 500, 50);
        add(title);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(100, 80, 90, 30);
        labelNome.setFont(new Font("Arial", Font.PLAIN, 16));
        add(labelNome);

        nomeText = new JTextField();
        nomeText.setBounds(200, 80, 250, 30);
        nomeText.setFont(new Font("Arial", Font.PLAIN, 16));
        add(nomeText);

        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        labelDataNascimento.setBounds(100, 130, 180, 30);
        labelDataNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
        add(labelDataNascimento);

        dataNascimentoText = new JTextField();
        dataNascimentoText.setBounds(280, 130, 170, 30);
        dataNascimentoText.setFont(new Font("Arial", Font.PLAIN, 16));
        add(dataNascimentoText);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(100, 180, 90, 30);
        labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        add(labelEmail);

        emailText = new JTextField();
        emailText.setBounds(200, 180, 250, 30);
        emailText.setFont(new Font("Arial", Font.PLAIN, 16));
        add(emailText);

        JLabel labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(100, 230, 90, 30);
        labelCPF.setFont(new Font("Arial", Font.PLAIN, 16));
        add(labelCPF);

        cpfText = new JTextField();
        cpfText.setBounds(200, 230, 250, 30);
        cpfText.setFont(new Font("Arial", Font.PLAIN, 16));
        add(cpfText);

        JLabel labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(100, 280, 90, 30);
        labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
        add(labelTelefone);

        telefoneText = new JTextField();
        telefoneText.setBounds(200, 280, 250, 30);
        telefoneText.setFont(new Font("Arial", Font.PLAIN, 16));
        add(telefoneText);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(300, 350, 150, 40);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setForeground(new Color(237, 241, 238));
        cadastrarButton.setBackground(new Color(9, 10, 9));
        add(cadastrarButton);

        cadastrarButton.addActionListener(new CadastrarCliente(this));

        this.addWindowListener(new JanelaCliente(this));

        setVisible(true);
    }

    // Método para validar os campos
    public boolean validarCampos() throws Exception {
        String nome = nomeText.getText();
        String dataNascimento = dataNascimentoText.getText();
        String email = emailText.getText();
        String cpf = cpfText.getText();
        String telefone = telefoneText.getText();

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

      public List<Cliente> getClientes() {
          return clientes;
      }

      public void importaClientes(List<Cliente> all) {
        if(all == null){
            this.clientes = new ArrayList<Cliente>();
        }else{
            this.clientes = all;
        }
      }

      public boolean cadastraCliente() {

          try {
              if (validarCampos()) {

                  String nome = nomeText.getText();
                  String dataDeNascimento = dataNascimentoText.getText();
                  String email = emailText.getText();
                  String cpf = cpfText.getText();
                  String telefone = telefoneText.getText();

                  for (Cliente cliente:clientes) {
                      if(cpf.equals(cliente.getCpf())){
                          throw new JaCadastradoException("Já existe um cliente cadastrados com esse CPF!");
                      }
                  }

                  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                  Date data = null;
                  try {
                      data = formato.parse(dataDeNascimento);

                  } catch (ParseException e) {
                      e.printStackTrace();
                  }

                  this.clientes.add(new Cliente(nome, data, email, cpf, telefone));
                  clientePersistence.save(this.clientes);
                  return true;
              }
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
          }
        return false;
      }
  }


 