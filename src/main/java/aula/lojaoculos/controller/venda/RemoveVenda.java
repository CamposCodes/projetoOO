package aula.lojaoculos.controller.venda;

import aula.lojaoculos.view.updates.ViewEditaRemoveCliente;
import aula.lojaoculos.view.updates.ViewEditaRemoveVenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveVenda implements ActionListener {

    ViewEditaRemoveVenda tela;

    public RemoveVenda(ViewEditaRemoveVenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.removeVenda();
    }
}
