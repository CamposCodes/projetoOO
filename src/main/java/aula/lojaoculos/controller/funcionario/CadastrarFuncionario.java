package aula.lojaoculos.controller.funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import aula.lojaoculos.view.cadastros.ViewCadastraFuncionario;

public class CadastrarFuncionario implements ActionListener {

    private final ViewCadastraFuncionario tela;

    public CadastrarFuncionario(ViewCadastraFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tela.cadastraFuncionario()) {
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            tela.dispose(); // Fecha a janela após o cadastro
        }
    }
}
