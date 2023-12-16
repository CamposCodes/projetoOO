package aula.lojaoculos.controller.desconto;

import aula.lojaoculos.model.Desconto;
import aula.lojaoculos.persistence.DescontoPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.updates.ViewEditaRemoveDesconto;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaEditaDesconto implements WindowListener {
    private final ViewEditaRemoveDesconto tela;

    public JanelaEditaDesconto(ViewEditaRemoveDesconto tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Desconto> descontoPersistence = new DescontoPersistence();
        List<Desconto> all = descontoPersistence.findAll();
        tela.importaDesconto(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Desconto> descontoPersistence = new DescontoPersistence();
        descontoPersistence.save(tela.listaDescontos());
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
