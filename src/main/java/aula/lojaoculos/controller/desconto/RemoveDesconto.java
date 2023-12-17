/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.desconto;

import aula.lojaoculos.view.updates.ViewEditaRemoveDesconto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveDesconto implements ActionListener {

    private final ViewEditaRemoveDesconto tela;

    public RemoveDesconto(ViewEditaRemoveDesconto tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.removeDesconto();
    }
}
