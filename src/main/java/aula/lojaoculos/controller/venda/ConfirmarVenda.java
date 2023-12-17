/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.venda;

import aula.lojaoculos.exceptions.CampoVazioException;
import aula.lojaoculos.view.cadastros.ViewCadastraVenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarVenda implements ActionListener {

    private final ViewCadastraVenda tela;

    public ConfirmarVenda(ViewCadastraVenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            tela.confirmarVenda();
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
