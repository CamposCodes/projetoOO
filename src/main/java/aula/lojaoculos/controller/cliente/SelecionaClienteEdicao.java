package aula.lojaoculos.controller.cliente;

import aula.lojaoculos.view.updates.ViewEditaRemoveCliente;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionaClienteEdicao implements ListSelectionListener {

    public SelecionaClienteEdicao(ViewEditaRemoveCliente tela) {
        this.tela = tela;
    }

    ViewEditaRemoveCliente tela;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizaFormulario();
    }
}
