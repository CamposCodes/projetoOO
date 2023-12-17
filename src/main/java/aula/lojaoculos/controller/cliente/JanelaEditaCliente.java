/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.cliente;

import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.persistence.ClientePersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.updates.ViewEditaRemoveCliente;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaEditaCliente implements WindowListener {

    private final ViewEditaRemoveCliente tela;

    public JanelaEditaCliente(ViewEditaRemoveCliente tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Cliente> clientePersistence = new ClientePersistence();
        List<Cliente> all = clientePersistence.findAll();
        tela.importaClientes(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Cliente> clientePersistence = new ClientePersistence();
        clientePersistence.save(tela.listaClientes());
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
