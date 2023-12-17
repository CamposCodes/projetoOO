/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.produto;

import aula.lojaoculos.view.updates.ViewEditaRemoveDesconto;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditaProduto implements ActionListener {

    private final ViewEditaRemoveProduto tela;

    public EditaProduto(ViewEditaRemoveProduto tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.editaProduto();
    }
}
