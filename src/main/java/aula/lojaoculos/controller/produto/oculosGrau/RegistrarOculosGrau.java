/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.produto.oculosGrau;

import aula.lojaoculos.view.cadastros.ViewOculosGrau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarOculosGrau implements ActionListener {

    private final ViewOculosGrau tela;

    public RegistrarOculosGrau(ViewOculosGrau tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tela.cadastraProduto()) {
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            tela.dispose(); // Fecha a janela após o cadastro
        }
    }
}
