package aula.lojaoculos.controller.venda;


import aula.lojaoculos.model.Cliente;
import aula.lojaoculos.model.Desconto;
import aula.lojaoculos.model.Funcionario;
import aula.lojaoculos.model.Venda;
import aula.lojaoculos.persistence.*;
import aula.lojaoculos.view.cadastros.ViewCadastraFuncionario;
import aula.lojaoculos.view.cadastros.ViewCadastraVenda;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class JanelaVenda implements WindowListener {

    private final ViewCadastraVenda tela;

    public JanelaVenda(ViewCadastraVenda tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Funcionario> funcionarioPersistence = new FuncionarioPersistence();
        Persistence<Cliente> clientePersistence = new ClientePersistence();
        Persistence<Desconto> descontoPersistence = new DescontoPersistence();
        Persistence<Venda> vendaPersistence = new VendaPersistence();
        List<Funcionario> allFuncionarios = funcionarioPersistence.findAll();
        List<Cliente> allClientes = clientePersistence.findAll();
        List<Desconto> allDescontos = descontoPersistence.findAll();
        List<Venda> allVendas = vendaPersistence.findAll();
        tela.importaListas(allClientes, allFuncionarios, allDescontos, allVendas);
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
