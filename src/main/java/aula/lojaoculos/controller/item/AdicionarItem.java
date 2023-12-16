package aula.lojaoculos.controller.item;

import aula.lojaoculos.view.cadastros.ViewAdicionaProduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarItem implements ActionListener {

    ViewAdicionaProduto tela;

    public AdicionarItem(ViewAdicionaProduto tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.adicionarItem();
    }
}
