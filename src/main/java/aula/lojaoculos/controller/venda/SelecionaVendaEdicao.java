package aula.lojaoculos.controller.venda;

import aula.lojaoculos.view.updates.ViewEditaRemoveVenda;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionaVendaEdicao implements ListSelectionListener {

    public SelecionaVendaEdicao(ViewEditaRemoveVenda tela) {
        this.tela = tela;
    }

    private final ViewEditaRemoveVenda tela;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizaFormulario();
    }
}
