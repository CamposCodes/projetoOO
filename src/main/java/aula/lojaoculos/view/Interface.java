package aula.lojaoculos.view;
import aula.lojaoculos.controller.cliente.JanelaCliente;
import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.exceptions.NaoEncontradoException;
import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.persistence.FuncionarioPersistence;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Interface extends JFrame {
    JTextField userText;
    JPasswordField senhaField;
    JLabel title;
    
    
    public Interface(){
        setTitle("Loja de Oculos");
        setSize(800,500);
        //finaliza o programa ao fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //abre janela no meio da tela
        setLocationRelativeTo(null);

        
        //label
        JLabel labelUser = new JLabel("Login:");
        labelUser.setBounds(275,55,90,50);
        labelUser.setFont(new Font("Arial",Font.PLAIN,16));
        add(labelUser);
        
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(275,130,90,50);
        labelSenha.setFont(new Font("Arial",Font.PLAIN,16));
        add(labelSenha);
        
        
        //caixas de texto
        userText = new JTextField();
        userText.setBounds(275,100,250,35);
        userText.setFont(new Font("Arial", Font.ITALIC, 20));
        add(userText);
        
        senhaField = new JPasswordField();
        senhaField.setBounds(275,175,250,35);
        add(senhaField);
        
        //titulo
        title = new JLabel("Loja de Óculos");
        title.setText("Loja de Óculos");
        title.setFont(new Font("Arial",Font.BOLD, 30));
        title.setBounds(275,5,500,50);
        add(title);
        
        // cria
        //Botão login
        setLayout(null);
        JButton jButton = new JButton("Entrar");
        jButton.setBounds(275,300,250,40);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(new Color(237,241,238));
        jButton.setBackground(new Color(9,10,9));
        // adiciona no frame
        add(jButton);
        
        //Ação 
        jButton.addActionListener(e->{
            try {
                if(userText.getText().isBlank() || senhaField.getText().isBlank()){
                    throw new CampoVazioException("Ambos os campos devem ser preenchidos!");
                }

                String cargo = obtemCargo(userText.getText(), senhaField.getText());

                if (cargo.equals("Gerente") || (userText.getText().equals("gerente") && senhaField.getText().equals("123"))){
                    JOptionPane.showMessageDialog(null,"Entrada Autorizada!");
                    new ViewGerente();
                } else if(cargo.equals("Vendedor")){
                    JOptionPane.showMessageDialog(null,"Entrada Autorizada!");
                    new ViewVendedor();
                } else {
                        throw new NaoEncontradoException("Usuário não encontrado"); // TODO: Tratar essa exceção
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    public String obtemCargo(String user, String password){

        FuncionarioPersistence funcionarioPersistence = new FuncionarioPersistence();
        List<Funcionario> funcionarios =  funcionarioPersistence.findAll();

        for (Funcionario funcionario:funcionarios) {
            if(user.equals(funcionario.getLogin())){
                if (password.equals(funcionario.getSenha())){
                    return funcionario.getCargo();
                }
            }
        }

        return "n/a";
    }




}
