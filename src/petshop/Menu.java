package petshop;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import petshop.model.Cliente;
import petshop.model.Produto;
import petshop.model.Pedido;
import petshop.model.Pagamento;
import petshop.model.PagamentoCartao;
import petshop.model.PagamentoBoleto;

public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        int opcao;

        while (true) {
            System.out.println("*****************************************************");
            System.out.println("                    PETZILLA                         ");
            System.out.println("*****************************************************");
            System.out.println("            1 - Cadastrar Cliente                    ");
            System.out.println("            2 - Cadastrar Pedido                     ");
            System.out.println("            3 - Listar Pedidos                       ");
            System.out.println("            4 - Buscar Clientes                      ");
            System.out.println("            5 - Buscar Pedidos                       ");
            System.out.println("            6 - Atualizar Dados do Cliente           ");
            System.out.println("            7 - Remover Cliente                      ");
            System.out.println("            8 - Cancelar Pedido                      ");
            System.out.println("            9 - Pagar Pedido                         ");
            System.out.println("            10 - Adicionar Crédito                   ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada: ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = -1;
            }

            if (opcao == 0) {
                System.out.println("\nPetzilla - O monstro das ofertas e dos cuidados para seu pet!");
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    leia.nextLine();
                    String nome = leia.nextLine();
                    System.out.print("Digite o saldo inicial do cliente: ");
                    float saldo = leia.nextFloat();
                    clientes.add(new Cliente(nome, saldo));
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do cliente para o pedido: ");
                    leia.nextLine();
                    String nomeClientePedido = leia.nextLine();
                    Cliente clientePedido = null;
                    for (Cliente c : clientes) {
                        if (c.getNome().equalsIgnoreCase(nomeClientePedido)) {
                            clientePedido = c;
                            break;
                        }
                    }
                    if (clientePedido == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = leia.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    float precoProduto = leia.nextFloat();
                    Produto produto = new Produto(nomeProduto, precoProduto);
                    System.out.println("Escolha a forma de pagamento: (1) Pagamento (2) Cartão (3) Boleto");
                    int opcaoPagamento = leia.nextInt();
                    Pagamento metodoPagamento;
                    
                    if (opcaoPagamento == 1) {
                        metodoPagamento = new PagamentoCartao("CartaoDeCredito");
                    } else if (opcaoPagamento == 2) {
                        leia.nextLine();
                        System.out.print("Digite o número do cartão: ");
                        String numeroCartao = leia.nextLine();
                        metodoPagamento = new PagamentoCartao(numeroCartao);
                    } else {
                        leia.nextLine();
                        System.out.print("Digite o código do boleto: ");
                        String codigoBoleto = leia.nextLine();
                        metodoPagamento = new PagamentoBoleto(codigoBoleto);
                    }
                    pedidos.add(new Pedido(clientePedido, produto, metodoPagamento));
                    System.out.println("Pedido cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("\nListar Pedidos");
                    if (pedidos.isEmpty()) {
                        System.out.println("Não há pedidos registrados.");
                    } else {
                        for (Pedido pedido : pedidos) {
                            pedido.exibirPedido();
                        }
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do cliente para buscar: ");
                    leia.nextLine();
                    String nomeBuscar = leia.nextLine();
                    boolean encontrado = false;
                    for (Cliente cliente : clientes) {
                        if (cliente.getNome().equalsIgnoreCase(nomeBuscar)) {
                            System.out.println("Cliente encontrado: " + cliente.getNome());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 9:
                    System.out.print("Digite o nome do cliente para pagar o pedido: ");
                    leia.nextLine();
                    String nomeClientePagar = leia.nextLine();
                    Pedido pedidoPagar = null;
                    for (Pedido pedido : pedidos) {
                        if (pedido.getCliente().getNome().equalsIgnoreCase(nomeClientePagar)) {
                            pedidoPagar = pedido;
                            break;
                        }
                    }
                    if (pedidoPagar != null && !pedidoPagar.isPago()) {
                        pedidoPagar.pagarPedido();
                        System.out.println("Pedido pago com sucesso!");
                    } else {
                        System.out.println("Pedido não encontrado ou já foi pago.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
