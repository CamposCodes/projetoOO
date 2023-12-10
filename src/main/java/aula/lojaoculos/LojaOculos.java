package aula.lojaoculos;
import java.time.LocalDate;
import java.util.Scanner;

public class LojaOculos {

    public static void main(String[] args) {
        
        //inicializa telas
        new Interface();
        
        Scanner scanner = new Scanner(System.in);

        Chefe chefe = new Chefe();
        Vendedor vendedor = new Vendedor();
        CalculadoraVendas calculadoraVendas = chefe.getCalculadoraVendas();

        System.out.println("Bem-vindo à Loja de Óculos!");

        while (true) {
            System.out.println("Faça login como Chefe ou Vendedor (chefe/vendedor) ou sair para encerrar:");
            String login = scanner.nextLine();

            if (login.equalsIgnoreCase("chefe")) {
                System.out.println("Login como Chefe realizado com sucesso!");

                while (true) {
                    System.out.println("O que deseja fazer, Chefe?");
                    System.out.println("1. Consultar vendas por dia");
                    System.out.println("2. Sair");

                    int opcaoChefe = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    if (opcaoChefe == 1) {
                        System.out.println("Digite a data no formato (aaaa-mm-dd):");
                        String dataString = scanner.nextLine();
                        LocalDate data = LocalDate.parse(dataString);

                        double totalVendas = calculadoraVendas.getTotalVendasPorDia(data);
                        System.out.println("Total de vendas no dia " + data + ": " + totalVendas);
                    } else if (opcaoChefe == 2) {
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else if (login.equalsIgnoreCase("vendedor")) {
                System.out.println("Login como Vendedor realizado com sucesso!");

                while (true) {
                    System.out.println("O que deseja fazer, Vendedor?");
                    System.out.println("1. Cadastrar cliente");
                    System.out.println("2. Adicionar óculos ao estoque");
                    System.out.println("3. Registrar venda");
                    System.out.println("4. Sair");

                    int opcaoVendedor = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    if (opcaoVendedor == 1) {
                        System.out.println("Digite o nome do cliente:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o CPF do cliente:");
                        String cpf = scanner.nextLine();
                        System.out.println("Digite o celular do cliente:");
                        String celular = scanner.nextLine();
                        System.out.println("Digite o e-mail do cliente:");
                        String email = scanner.nextLine();

                        Cliente cliente = new Cliente(cpf, celular, email, nome);
                        vendedor.cadastrarCliente(cliente);
                    } else if (opcaoVendedor == 2) {
                        System.out.println("Adicionando óculos ao estoque...");1
                        System.out.println("Adicionando óculos ao estoque...");
                        // Aqui você pode implementar a lógica para adicionar óculos ao estoque
                    } else if (opcaoVendedor == 3) {
                        System.out.println("Digite o valor da venda:");
                    } else if (opcaoVendedor == 4) {
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else if (login.equalsIgnoreCase("sair")) {
                break;
            } else {
                System.out.println("Opção de login inválida!");
            }
        }

        System.out.println("Encerrando a Loja de Óculos. Até mais!");
        scanner.close();
    }
}
