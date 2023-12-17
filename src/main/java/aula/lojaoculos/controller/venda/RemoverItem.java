/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.venda;

import aula.lojaoculos.view.cadastros.ViewCadastraVenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverItem implements ActionListener {

    private final ViewCadastraVenda tela;

    public RemoverItem(ViewCadastraVenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.removeItem();
    }
}
