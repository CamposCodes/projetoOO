package aula.lojaoculos.controller.funcionario;

import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.persistence.ClientePersistence;
import aula.lojaoculos.persistence.FuncionarioPersistence;
import aula.lojaoculos.persistence.Persistence;
import aula.lojaoculos.view.ViewCadastraFuncionario;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaFuncionario implements WindowListener {

    private final ViewCadastraFuncionario tela;

    public JanelaFuncionario(ViewCadastraFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Funcionario> funcionarioPersistence = new FuncionarioPersistence();
        List<Funcionario> all = funcionarioPersistence.findAll();
        tela.importaFuncionarios(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Funcionario> funcionarioPersistence = new FuncionarioPersistence();
        funcionarioPersistence.save(tela.getFuncionarios());
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
