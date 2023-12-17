/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.item;

import aula.lojaoculos.view.cadastros.ViewAdicionaProduto;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionarProduto implements ListSelectionListener {

    private ViewAdicionaProduto tela;

    public SelecionarProduto(ViewAdicionaProduto tela) {
            this.tela = tela;
        }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizarCampos();
    }

}
