package aula.lojaoculos.controller.desconto;

import aula.lojaoculos.model.Desconto;
import aula.lojaoculos.persistence.DescontoPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.cadastros.ViewCadastraDesconto;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaDesconto implements WindowListener {
    private final ViewCadastraDesconto tela;

    public JanelaDesconto(ViewCadastraDesconto tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Desconto> descontoPersistence = new DescontoPersistence();
        List<Desconto> all = descontoPersistence.findAll();
        tela.importaDescontos(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Desconto> descontoPersistence = new DescontoPersistence();
        descontoPersistence.save(tela.getDescontos());
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
