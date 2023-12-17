/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.cliente;

import aula.lojaoculos.view.updates.ViewEditaRemoveCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCliente implements ActionListener {

    ViewEditaRemoveCliente tela;

    public RemoveCliente(ViewEditaRemoveCliente tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.removeCliente();
    }
}
