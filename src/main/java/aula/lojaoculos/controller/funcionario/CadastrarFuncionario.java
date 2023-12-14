package aula.lojaoculos.controller.funcionario;
package aula.lojaoculos.view.ViewCadastraFuncionario;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
