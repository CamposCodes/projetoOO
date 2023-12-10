/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.lojaoculos.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author gcamp
 */
public class ViewCadastraCliente {
    JTextField nome;
    JTextField cpf;
    JTextField contato;
    JTextField email;
    JLabel textNome;
    JLabel textCpf;
    JLabel textContato;
    JLabel textEmail;
    
    public ViewCadastraCliente(){
        JFrame janelaOp1 = new JFrame("Sistema - Opcao 1");
        janelaOp1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaOp1.setSize(800,500);
        janelaOp1.setResizable(false);
        janelaOp1.setLocationRelativeTo(null);
        janelaOp1.setLayout(null);
                    
        //nome
        textNome = new JLabel("Nome Completo:");
        textNome.setBounds(275,20,200,40);
        textNome.setFont(new Font("Arial",Font.PLAIN,12));
        janelaOp1.add(textNome);
        //
        nome = new JTextField();
        nome.setBounds(275,60,250,30);
        nome.setFont(new Font("Arial", Font.ITALIC, 15));
        janelaOp1.add(nome);
        
        //cof
        textCpf = new JLabel("CPF");
        textCpf.setBounds(275,85,200,40);
        textCpf.setFont(new Font("Arial",Font.PLAIN,12));
        janelaOp1.add(textCpf);
        //
        cpf = new JTextField();
        cpf.setBounds(275,120,250,30);
        cpf.setFont(new Font("Arial", Font.ITALIC, 15));
        janelaOp1.add(cpf);
        
        //contato
        textContato = new JLabel("Contato");
        textContato.setBounds(275,150,200,40);
        textContato.setFont(new Font("Arial",Font.PLAIN,12));
        janelaOp1.add(textContato);
        //
        contato = new JTextField();
        contato.setBounds(275,185,250,30);
        contato.setFont(new Font("Arial", Font.ITALIC, 15));
        janelaOp1.add(contato);
        
        //email
        textEmail = new JLabel("Email");
        textEmail.setBounds(275,210,200,40);
        textEmail.setFont(new Font("Arial",Font.PLAIN,12));
        janelaOp1.add(textEmail);
        //
        email = new JTextField();
        email.setBounds(275,245,250,30);
        email.setFont(new Font("Arial", Font.ITALIC, 15));
        janelaOp1.add(email);
       
        //Botão 
        JButton buttonCadastro = new JButton("Cadastrar");
        buttonCadastro.setBounds(275,300,250,40);
        buttonCadastro.setFont(new Font("Arial", Font.BOLD, 20));
        buttonCadastro.setForeground(new Color(237,241,238));
        buttonCadastro.setBackground(new Color(9,10,9));
        // adiciona no frame
        janelaOp1.add(buttonCadastro);
        
        janelaOp1.setVisible(true);
    }
}
