/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.desconto;

import aula.lojaoculos.view.cadastros.ViewCadastraDesconto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDesconto implements ActionListener {
    private final ViewCadastraDesconto tela;

    public CadastrarDesconto(ViewCadastraDesconto tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tela.cadastraDesconto()) {
            JOptionPane.showMessageDialog(null, "Desconto cadastrado com sucesso!");
            tela.dispose(); // Fecha a janela após o cadastro
        }
    }
}
