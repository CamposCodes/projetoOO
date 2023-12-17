/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.funcionario;

import aula.lojaoculos.view.updates.ViewEditaRemoveFuncionario;
import aula.lojaoculos.view.updates.ViewEditaRemoveProduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveFuncionario implements ActionListener {

    private final ViewEditaRemoveFuncionario tela;

    public RemoveFuncionario(ViewEditaRemoveFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.removeFuncionario();
    }
}
