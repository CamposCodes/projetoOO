  package aula.lojaoculos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

import aula.lojaoculos.controller.AdicionaOculos;
import aula.lojaoculos.controller.CadastraCliente;
import aula.lojaoculos.controller.RegistraVenda;

public class ViewCadastraCliente extends JFrame {
    JTextField nomeText, dataNascimentoText, emailText, cpfText, telefoneText;

    public ViewCadastraCliente() {
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

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    // Realizar ação de cadastro aqui
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    dispose(); // Fecha a janela após o cadastro
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos corretamente!",
                            "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    // Método para validar os campos
    private boolean validarCampos() {
        String nome = nomeText.getText();
        String dataNascimento = dataNascimentoText.getText();
        String email = emailText.getText();
        String cpf = cpfText.getText();
        String telefone = telefoneText.getText();

        // Expressões regulares para validação
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String regexTelefone = "^\\d{10,11}$";
        String regexDataNascimento = "^\\d{2}/\\d{2}/\\d{4}$"; // Formato dd/MM/yyyy
        Pattern patternEmail = Pattern.compile(regexEmail);
        Pattern patternTelefone = Pattern.compile(regexTelefone);
        Pattern patternDataNascimento = Pattern.compile(regexDataNascimento);

        // Validando os campos com as expressões regulares
        Matcher matcherEmail = patternEmail.matcher(email);
        Matcher matcherTelefone = patternTelefone.matcher(telefone);
        Matcher matcherDataNascimento = patternDataNascimento.matcher(dataNascimento);

        return !nome.isEmpty() && matcherEmail.matches() && matcherTelefone.matches() && matcherDataNascimento.matches() && validarCPF(cpf);
    }
}


 