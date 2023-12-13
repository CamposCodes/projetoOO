package aula.lojaoculos.controller.cliente;

import aula.lojaoculos.view.ViewCadastraCliente;

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
            if (tela.validarCampos()) {
                tela.cadastraCliente();
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                tela.dispose(); // Fecha a janela após o cadastro
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, preencha os campos corretamente!",
                        "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }

}
