/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.item;

import aula.lojaoculos.model.Oculos;
import aula.lojaoculos.persistence.OculosPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.cadastros.ViewAdicionaProduto;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaItem implements WindowListener {

    private final ViewAdicionaProduto tela;

    public JanelaItem(ViewAdicionaProduto tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Oculos> oculosPersistence = new OculosPersistence();
        List<Oculos> all = oculosPersistence.findAll();
        tela.importaProdutos(all);
    }


    @Override
    public void windowClosing(WindowEvent e) {

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
