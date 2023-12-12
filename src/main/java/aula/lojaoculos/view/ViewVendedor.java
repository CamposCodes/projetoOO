package aula.lojaoculos.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewVendedor extends JFrame {
    public ViewVendedor() {
        setTitle("Tela Inicial de Vendedor");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50)); // Configura o layout para centralizar

        JButton cadastrarClienteButton = new JButton("Cadastrar Cliente");
        cadastrarClienteButton.setPreferredSize(new Dimension(200, 40));
        cadastrarClienteButton.setForeground(Color.WHITE);
        cadastrarClienteButton.setBackground(Color.BLACK);
        add(cadastrarClienteButton);
        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraVenda();
            }
        });

        JButton cadastrarVendaButton = new JButton("Cadastrar Venda");
        cadastrarVendaButton.setPreferredSize(new Dimension(200, 40));
        cadastrarVendaButton.setForeground(Color.WHITE);
        cadastrarVendaButton.setBackground(Color.BLACK);
        add(cadastrarVendaButton);
        cadastrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewCadastraVenda();
            }
        });

        JButton sairButton = new JButton("Sair");
        sairButton.setPreferredSize(new Dimension(200, 40));
        sairButton.setForeground(Color.WHITE);
        sairButton.setBackground(Color.BLACK);
        add(sairButton);
          sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        setVisible(true);
    }
}
