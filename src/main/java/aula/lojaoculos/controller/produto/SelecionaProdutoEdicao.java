/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.produto;

import aula.lojaoculos.view.updates.ViewEditaRemoveDesconto;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionaProdutoEdicao implements ListSelectionListener {

    private final ViewEditaRemoveProduto tela;
    public SelecionaProdutoEdicao(ViewEditaRemoveProduto tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizaFormulario();
    }
}
