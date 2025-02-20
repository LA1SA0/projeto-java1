package petshop;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import petshop.model.Cliente;
import petshop.Produtos.Produto;
import petshop.Produtos.Pedido;
import petshop.Pagamentos.Pagamento;
import petshop.Pagamentos.PagamentoCartao;
import petshop.Pagamentos.PagamentoBoleto;
import petshop.Produtos.Estoque;

public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        Estoque estoque = new Estoque();
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
            System.out.println("           10 - Ver Estoque                          ");
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
                    float saldo = 0;

                    try {
                        System.out.print("Digite o saldo inicial do cliente: ");
                        saldo = leia.nextFloat();
                        if (saldo < 0) {
                            throw new IllegalArgumentException("O saldo não pode ser negativo.");
                        }
                    } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
                        leia.nextLine(); 
                        break;
                    }

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

                    Produto produto = null;
                    try {
                        System.out.print("Digite o nome do produto: ");
                        String nomeProduto = leia.nextLine();
                        System.out.print("Digite o preço do produto: ");
                        float precoProduto = leia.nextFloat();

                        if (precoProduto < 0) {
                            throw new IllegalArgumentException("O preço não pode ser negativo.");
                        }

                        produto = new Produto(nomeProduto, precoProduto);
                    } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar produto: " + e.getMessage());
                        leia.nextLine(); 
                        break;
                    }

                    System.out.println("Escolha a forma de pagamento: (1) Cartão (2) Boleto");
                    int opcaoPagamento = leia.nextInt();
                    Pagamento metodoPagamento;

                    if (opcaoPagamento == 1) {
                        metodoPagamento = new PagamentoCartao("CartaoDeCredito");
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

                case 5:
                    System.out.print("Digite o nome do cliente para buscar os pedidos: ");
                    leia.nextLine();
                    String nomeClientePedidoBuscar = leia.nextLine();
                    boolean pedidoEncontrado = false;
                    for (Pedido pedido : pedidos) {
                        if (pedido.getCliente().getNome().equalsIgnoreCase(nomeClientePedidoBuscar)) {
                            pedido.exibirPedido();
                            pedidoEncontrado = true;
                        }
                    }
                    if (!pedidoEncontrado) {
                        System.out.println("Não há pedidos para o cliente informado.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o nome do cliente para atualizar: ");
                    leia.nextLine();
                    String nomeClienteAtualizar = leia.nextLine();
                    Cliente clienteAtualizar = null;

                    for (Cliente c : clientes) {
                        if (c.getNome().equalsIgnoreCase(nomeClienteAtualizar)) {
                            clienteAtualizar = c;
                            break;
                        }
                    }

                    if (clienteAtualizar != null) {
                        System.out.print("Digite o novo saldo: ");
                        float novoSaldo = leia.nextFloat();
                        clienteAtualizar.setSaldoCarteira(novoSaldo);
                        System.out.println("Dados do cliente atualizados com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o nome do cliente para remover: ");
                    leia.nextLine();
                    String nomeRemover = leia.nextLine();
                    Cliente clienteRemover = null;

                    for (Cliente c : clientes) {
                        if (c.getNome().equalsIgnoreCase(nomeRemover)) {
                            clienteRemover = c;
                            break;
                        }
                    }

                    if (clienteRemover != null) {
                        clientes.remove(clienteRemover);
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 8:
                    System.out.print("Digite o nome do cliente para cancelar o pedido: ");
                    leia.nextLine();
                    String nomeClienteCancelar = leia.nextLine();
                    Pedido pedidoCancelar = null;

                    for (Pedido pedido : pedidos) {
                        if (pedido.getCliente().getNome().equalsIgnoreCase(nomeClienteCancelar)) {
                            pedidoCancelar = pedido;
                            break;
                        }
                    }

                    if (pedidoCancelar != null) {
                        pedidos.remove(pedidoCancelar);
                        System.out.println("Pedido cancelado com sucesso!");
                    } else {
                        System.out.println("Pedido não encontrado.");
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

                case 10:
                    estoque.listarProdutos();
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}

