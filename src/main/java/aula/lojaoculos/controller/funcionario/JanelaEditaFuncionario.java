package aula.lojaoculos.controller.funcionario;

import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.model.Oculos;
import aula.lojaoculos.persistence.FuncionarioPersistence;
import aula.lojaoculos.persistence.OculosPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.updates.ViewEditaRemoveFuncionario;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaEditaFuncionario implements WindowListener {
    private final ViewEditaRemoveFuncionario tela;

    public JanelaEditaFuncionario(ViewEditaRemoveFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Funcionario> funcionarioPersistence = new FuncionarioPersistence();
        List<Funcionario> all = funcionarioPersistence.findAll();
        tela.importaFuncionario(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Funcionario> funcionarioPersistence = new FuncionarioPersistence();
        funcionarioPersistence.save(tela.listaFuncionario());
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
