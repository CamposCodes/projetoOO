package aula.lojaoculos.controller.funcionario;

import aula.lojaoculos.view.updates.ViewEditaRemoveFuncionario;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditaFuncionario implements ActionListener {

    private final ViewEditaRemoveFuncionario tela;

    public EditaFuncionario(ViewEditaRemoveFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.editaFuncionario();
    }
}
