/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.cliente;

import aula.lojaoculos.view.cadastros.ViewCadastraCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarCliente implements ActionListener {

    private final ViewCadastraCliente tela;

    public CadastrarCliente(ViewCadastraCliente tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tela.cadastraCliente()) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            tela.dispose(); // Fecha a janela após o cadastro
        }
    }

}
