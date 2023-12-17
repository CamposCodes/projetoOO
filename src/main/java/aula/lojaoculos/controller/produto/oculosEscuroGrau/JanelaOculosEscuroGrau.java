/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.produto.oculosEscuroGrau;

import aula.lojaoculos.model.Oculos;
import aula.lojaoculos.persistence.OculosPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.cadastros.ViewOculosEscurosGrau;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaOculosEscuroGrau implements WindowListener {

    private final ViewOculosEscurosGrau tela;

    public JanelaOculosEscuroGrau(ViewOculosEscurosGrau tela) {
        this.tela = tela;
    }


    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Oculos> oculosPersistence = new OculosPersistence();
        List<Oculos> all = oculosPersistence.findAll();
        tela.importaOculos(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Oculos> oculosPersistence = new OculosPersistence();
        oculosPersistence.save(tela.getListaOculos());
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
