package aula.lojaoculos.controller.venda;

import aula.lojaoculos.view.cadastros.ViewCadastraVenda;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionarFuncionario implements ListSelectionListener {

    ViewCadastraVenda tela;

    public SelecionarFuncionario(ViewCadastraVenda tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizarCampos();
    }
}
