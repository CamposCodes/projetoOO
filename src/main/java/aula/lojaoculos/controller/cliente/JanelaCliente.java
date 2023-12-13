package aula.lojaoculos.controller.cliente;

import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.persistence.ClientePersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.ViewCadastraCliente;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaCliente implements WindowListener {

    private final ViewCadastraCliente tela;

    public JanelaCliente(ViewCadastraCliente tela) {
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
        clientePersistence.save(tela.getClientes());
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
