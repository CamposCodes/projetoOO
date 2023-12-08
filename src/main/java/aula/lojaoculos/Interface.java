package aula.lojaoculos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Interface extends JFrame {
    
    public Interface(){
        setTitle("Loja de Oculos");
        setSize(800,500);
        //finaliza o programa ao fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //abre janela no meio da tela
        setLocationRelativeTo(null);

        //Botão login
        setLayout(null);
        // cria
        JButton jButton = new JButton("Entrar");
        jButton.setBounds(275,200,250,70);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(new Color(237,241,238));
        jButton.setBackground(new Color(9,10,9));
        // adiciona no frame
        add(jButton);
        
        //Ação 
        jButton.addActionListener(e->{
            JOptionPane.showMessageDialog(null, "Bem-vindo a loja");         
        });
        
        //caixas de texto
        JTextField userText = new JTextField("Login");
        userText.setBounds(275,30,250,50);
        userText.setFont(new Font("Arial", Font.ITALIC, 20));
        userText.setText("Login");
        add(userText);
        
        JTextField senhaText = new JTextField("Senha");
        senhaText.setBounds(275,100,250,50);
        senhaText.setFont(new Font("Arial", Font.ITALIC, 20));
        senhaText.setText("Senha");
        add(senhaText);
        
        setVisible(true);
    }


}
