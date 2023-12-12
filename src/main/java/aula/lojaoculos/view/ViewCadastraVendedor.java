
package aula.lojaoculos.view;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewCadastraVendedor extends JFrame {

    public ViewCadastraVendedor() {
        setTitle("Cadastro de Vendedor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2, 10, 10));

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel nomeLabel = createLabel("Nome:", labelFont);
        JTextField nomeTextField = createTextField();

        JLabel dataNascimentoLabel = createLabel("Data de Nascimento:", labelFont);
        JTextField dataNascimentoTextField = createTextField();

        JLabel emailLabel = createLabel("Email:", labelFont);
        JTextField emailTextField = createTextField();

        JLabel cpfLabel = createLabel("CPF:", labelFont);
        JTextField cpfTextField = createTextField();

        JLabel telefoneLabel = createLabel("Telefone:", labelFont);
        JTextField telefoneTextField = createTextField();

        JLabel cargoLabel = createLabel("Cargo:", labelFont);
        JTextField cargoTextField = createTextField();

        JLabel loginLabel = createLabel("Login:", labelFont);
        JTextField loginTextField = createTextField();

        JLabel senhaLabel = createLabel("Senha:", labelFont);
        JPasswordField senhaPasswordField = new JPasswordField();

        JButton registrarButton = createButton("Registrar", 150, 40, labelFont, Color.WHITE, Color.BLACK);
        registrarButton.addActionListener(e -> {
            String nome = nomeTextField.getText();
            String dataNascimento = dataNascimentoTextField.getText();
            String email = emailTextField.getText();
            String cpf = cpfTextField.getText();
            String telefone = telefoneTextField.getText();
            String cargo = cargoTextField.getText();
            String login = loginTextField.getText();
            String senha = String.valueOf(senhaPasswordField.getPassword());

            if (validarEmail(email) && validarDataNascimento(dataNascimento) &&
                validarTelefone(telefone) && validarCPF(cpf)) {
                // Faça o que for necessário com os dados validados
                // Por exemplo, adicionar ao banco de dados ou realizar outra operação
                // Aqui você pode colocar o código para lidar com os dados inseridos após a validação
                System.out.println("Dados válidos! Realizando o cadastro...");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, preencha os campos corretamente.");
            }
        });

        add(nomeLabel);
        add(nomeTextField);
        add(dataNascimentoLabel);
        add(dataNascimentoTextField);
        add(emailLabel);
        add(emailTextField);
        add(cpfLabel);
        add(cpfTextField);
        add(telefoneLabel);
        add(telefoneTextField);
        add(cargoLabel);
        add(cargoTextField);
        add(loginLabel);
        add(loginTextField);
        add(senhaLabel);
        add(senhaPasswordField);
        add(registrarButton);

        setVisible(true);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private JTextField createTextField() {
        return new JTextField();
    }

    private JButton createButton(String text, int width, int height, Font font, Color foregroundColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(font);
        button.setForeground(foregroundColor);
        button.setBackground(backgroundColor);
        return button;
    }

    private boolean validarEmail(String email) {
        // Regex para validar e-mail
        String regexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validarDataNascimento(String dataNascimento) {
        // Regex para validar data de nascimento no formato dd/mm/aaaa
        String regexData = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regexData);
        Matcher matcher = pattern.matcher(dataNascimento);
        return matcher.matches();
    }

    private boolean validarTelefone(String telefone) {
        // Regex para validar telefone no formato (XX) XXXXX-XXXX
        String regexTelefone = "^\\(\\d{2}\\)\\s\\d{5}-\\d{4}$";
        Pattern pattern = Pattern.compile(regexTelefone);
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }

    private boolean validarCPF(String cpf) {
        // Você deve implementar o método de validação de CPF
        // Aqui está um exemplo de método para validar CPF:
        // return CPFValidator.validate(cpf);
        // Você pode usar bibliotecas de validação de CPF ou implementar seu próprio método
        // Essa implementação depende do seu contexto e requisitos
        return true; // Neste exemplo, retorna verdadeiro para validação de CPF
    }

}
