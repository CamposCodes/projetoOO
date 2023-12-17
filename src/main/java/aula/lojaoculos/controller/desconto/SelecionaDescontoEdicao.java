/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.desconto;

import aula.lojaoculos.view.updates.ViewEditaRemoveCliente;
import aula.lojaoculos.view.updates.ViewEditaRemoveDesconto;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionaDescontoEdicao implements ListSelectionListener {

    private final ViewEditaRemoveDesconto tela;
    public SelecionaDescontoEdicao(ViewEditaRemoveDesconto tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizaFormulario();
    }
}
