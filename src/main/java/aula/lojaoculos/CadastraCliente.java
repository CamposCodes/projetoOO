package aula.lojaoculos;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CadastraCliente {
    JTextField nome;
    JTextField cpf;
    JTextField contato;
    JLabel textNome;
    JLabel textCpf;
    JLabel textContato;
    
    public CadastraCliente(){
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
        
        janelaOp1.setVisible(true);
    }
}
