/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.venda;

import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.model.Venda;
import aula.lojaoculos.persistence.FuncionarioPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.persistence.VendaPersistence;
import aula.lojaoculos.view.updates.ViewEditaRemoveVenda;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaEditaVenda implements WindowListener {

    private final ViewEditaRemoveVenda tela;

    public JanelaEditaVenda(ViewEditaRemoveVenda tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Venda> vendaPersistence = new VendaPersistence();
        Persistence<Funcionario> funcionarioPersistence = new FuncionarioPersistence();
        List<Funcionario> allFuncionario = funcionarioPersistence.findAll();
        List<Venda> all = vendaPersistence.findAll();
        tela.importaVendas(all, allFuncionario);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Venda> vendaPersistence = new VendaPersistence();
        vendaPersistence.save(tela.listaVendas());
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
