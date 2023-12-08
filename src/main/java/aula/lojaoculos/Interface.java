package aula.lojaoculos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    JTextField userText;
    JTextField senhaText;
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
        
        senhaText = new JTextField();
        senhaText.setBounds(275,175,250,35);
        senhaText.setFont(new Font("Arial", Font.ITALIC, 20));
        add(senhaText);
        
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
            if("chefe".equals(userText.getText()) || "vendedor".equals(userText.getText()) && "1234".equals(senhaText.getText())){
                JOptionPane.showMessageDialog(null,"Entrada Autorizada!"); 
                //NOVA JANELA
                JFrame janelaPrincipal = new JFrame("Sistema");
                janelaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setSize(800,500);
                setResizable(false);
                setLocationRelativeTo(null);
                
                //texto do topo
                JLabel textTopo = new JLabel("Opções");
                textTopo.setFont(new Font("Arial",Font.BOLD, 30));
                textTopo.setBounds(350,10,500,50);
                janelaPrincipal.add( textTopo);
                
                //menu opções
                janelaPrincipal.setLayout(null);
                JButton opcao1 = new JButton("Cadastrar cliente");
                opcao1.setBounds(275,100,275,40);
                opcao1.setForeground(new Color(237,241,238));
                opcao1.setBackground(new Color(9,10,9));
                opcao1.setFont(new Font("Arial", Font.BOLD, 20));
                //acao opção 1
                opcao1.addActionListener( op1 -> {new CadastraCliente();});
                
                JButton opcao2 = new JButton("Adicionar ao estoque");              
                opcao2.setBounds(275,150,275,40);
                opcao2.setForeground(new Color(237,241,238));
                opcao2.setBackground(new Color(9,10,9));
                opcao2.setFont(new Font("Arial", Font.BOLD, 20));   
                opcao2.addActionListener( op2 -> {new AdicionaOculos();});
                
                JButton opcao3 = new JButton("Registrar venda");
                opcao3.setBounds(275,200,275,40);
                opcao3.setForeground(new Color(237,241,238));
                opcao3.setBackground(new Color(9,10,9));
                opcao3.setFont(new Font("Arial", Font.BOLD, 20));
                opcao3.addActionListener( op3 -> {new RegistraVenda();});
                
                janelaPrincipal.add(opcao1);
                janelaPrincipal.add(opcao2);
                janelaPrincipal.add(opcao3);
                
                janelaPrincipal.setSize(800, 500);
                janelaPrincipal.setLocationRelativeTo(null); // Centraliza a nova janela
                janelaPrincipal.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null,"Entrada Negada!","Alerta",JOptionPane.ERROR_MESSAGE);  
            }
        });

        setVisible(true);
    }


}
