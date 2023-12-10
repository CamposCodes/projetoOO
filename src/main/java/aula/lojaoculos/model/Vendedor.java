package aula.lojaoculos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vendedor {
    private List<Cliente> clientes;
    private List<Oculos> oculosDisponiveis;

    public Vendedor() {
        this.clientes = new ArrayList<>();
        this.oculosDisponiveis = new ArrayList<>();
    }

    // Método para cadastrar um cliente
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
    }

    // Método para adicionar óculos ao estoque
    public void adicionarOculos(Oculos oculos) {
        oculosDisponiveis.add(oculos);
        System.out.println("Óculos do tipo " + oculos.getTipo() + " adicionado ao estoque!");
    }

    // Método para realizar uma venda de óculos para um cliente
    public void venderOculos(Cliente cliente, Oculos oculos) {
        if (clientes.contains(cliente) && oculosDisponiveis.contains(oculos)) {
            System.out.println("Venda realizada para o cliente " + cliente.getNome() + " - Óculos do tipo "
                    + oculos.getTipo() + " vendido com sucesso!");
            oculosDisponiveis.remove(oculos); // Remover o óculos vendido do estoque
        } else {
            System.out.println("Cliente ou óculos não encontrados. Venda não realizada.");
        }
    }
    
    public void registrarVenda() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite o valor da venda: ");
        double valorVenda = scanner.nextDouble();

        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("Venda registrada para o cliente " + clienteEncontrado.getNome() + " - Valor: R$" + valorVenda);
        } else {
            System.out.println("Cliente não encontrado. Venda não registrada.");
        }
    }

}