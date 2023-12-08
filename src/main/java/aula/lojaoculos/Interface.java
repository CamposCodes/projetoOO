package aula.lojaoculos;

import javax.swing.*;

public class Interface extends JFrame {
    
    public Interface(){
        setTitle("Loja de Oculos");
        setVisible(true);
        setSize(800,500);
        //finaliza o programa ao fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //abre janela no meio da tela
        setLocationRelativeTo(null);

    }
    
}
