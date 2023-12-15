package aula.lojaoculos.controller.produto.oculosEscuro;

import aula.lojaoculos.view.cadastros.ViewOculosEscuros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarOculosEscuro implements ActionListener {

    private final ViewOculosEscuros tela;

    public RegistrarOculosEscuro(ViewOculosEscuros tela) {
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
