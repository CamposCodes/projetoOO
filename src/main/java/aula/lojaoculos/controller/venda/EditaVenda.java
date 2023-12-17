/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.venda;

import aula.lojaoculos.view.updates.ViewEditaRemoveCliente;
import aula.lojaoculos.view.updates.ViewEditaRemoveVenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditaVenda implements ActionListener {

    private final ViewEditaRemoveVenda tela;

    public EditaVenda(ViewEditaRemoveVenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.editaVenda();
    }
}
