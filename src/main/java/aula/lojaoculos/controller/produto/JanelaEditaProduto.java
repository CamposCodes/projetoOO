package aula.lojaoculos.controller.produto;

import aula.lojaoculos.model.Desconto;
import aula.lojaoculos.model.Oculos;
import aula.lojaoculos.persistence.DescontoPersistence;
import aula.lojaoculos.persistence.OculosPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.updates.ViewEditaRemoveDesconto;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaEditaProduto implements WindowListener {
    private final ViewEditaRemoveProduto tela;

    public JanelaEditaProduto(ViewEditaRemoveProduto tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Oculos> oculosPersistence = new OculosPersistence();
        List<Oculos> all = oculosPersistence.findAll();
        tela.importaProduto(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Oculos> oculosPersistence = new OculosPersistence();
        oculosPersistence.save(tela.listaProduto());
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
