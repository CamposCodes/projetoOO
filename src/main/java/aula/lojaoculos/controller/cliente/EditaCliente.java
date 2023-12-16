package aula.lojaoculos.controller.cliente;

import aula.lojaoculos.view.updates.ViewEditaRemoveCliente;
import aula.lojaoculos.view.updates.ViewListagens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditaCliente implements ActionListener {

    private final ViewEditaRemoveCliente tela;

    public EditaCliente(ViewEditaRemoveCliente tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.editaCliente();
    }
}
