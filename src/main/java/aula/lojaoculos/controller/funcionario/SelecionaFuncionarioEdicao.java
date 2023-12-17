/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.funcionario;

import aula.lojaoculos.view.updates.ViewEditaRemoveFuncionario;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionaFuncionarioEdicao implements ListSelectionListener {

    private final ViewEditaRemoveFuncionario tela;
    public SelecionaFuncionarioEdicao(ViewEditaRemoveFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizaFormulario();
    }
}
