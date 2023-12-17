/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.venda;

import aula.lojaoculos.view.cadastros.ViewCadastraVenda;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionarItem implements ListSelectionListener {

    ViewCadastraVenda tela;

    public SelecionarItem(ViewCadastraVenda tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizarCampos();
    }
}
