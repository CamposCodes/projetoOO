/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.lojaoculos.model;

/**
 *
 * @author gcamp
 */
public class Cliente {
    private String nome;
    private String cpf;
    private String celular;
    private String email;

    // Construtor que recebe CPF, celular e email
    public Cliente(String cpf, String celular, String email, String nome) {
        if (validarCpf(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.nome = nome;
    }

    // Getters e Setters para os atributos
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (validarCpf(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido!");
        }
        
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public static boolean validarCpf(String cpf) {
        // Removendo caracteres especiais e espaços em branco do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais, o que torna o CPF inválido
        boolean digitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                digitosIguais = false;
                break;
            }
        }
        if (digitosIguais) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = 11 - (soma % 11);
        int digitoVerificador1 = (resto == 10 || resto == 11) ? 0 : resto;

        // Verifica o primeiro dígito verificador
        if (digitoVerificador1 != (cpf.charAt(9) - '0')) {
            return false;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = 11 - (soma % 11);
        int digitoVerificador2 = (resto == 10 || resto == 11) ? 0 : resto;

        // Verifica o segundo dígito verificador
        return (digitoVerificador2 == (cpf.charAt(10) - '0'));
    }
}