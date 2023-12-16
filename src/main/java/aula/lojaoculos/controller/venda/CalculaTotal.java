package aula.lojaoculos.controller.venda;

import aula.lojaoculos.view.cadastros.ViewCadastraVenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculaTotal implements ActionListener {

    private final ViewCadastraVenda tela;
    public CalculaTotal(ViewCadastraVenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.calculaTotal();
    }
}
