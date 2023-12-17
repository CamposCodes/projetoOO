/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.controller.produto.oculosEscuroGrau;

import aula.lojaoculos.view.cadastros.ViewOculosEscurosGrau;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarOculosEscuroGrau implements ActionListener {

    private final ViewOculosEscurosGrau tela;

    public RegistrarOculosEscuroGrau(ViewOculosEscurosGrau tela) {
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
