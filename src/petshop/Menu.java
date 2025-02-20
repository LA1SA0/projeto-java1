package petshop;

import java.util.InputMismatchException;
import java.util.Scanner;
import petshop.Cores;


public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao, pedidoId, clienteId, tipoPagamento, quantidade;
		String nomeCliente, nomePet, produto;
		float saldoCarteira, precoProduto, valorPagamento;
		
		while (true) {
			
			System.out.println( Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    PETZILLA                         ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Cliente                    ");
			System.out.println("            2 - Listar Pedidos                       ");
			System.out.println("            3 - Buscar Clientes                      ");
			System.out.println("            4 - Buscar Pedidos                       ");
			System.out.println("            5 - Atualizar Dados do Cliente           ");
			System.out.println("            6 - Remover Cliente                      ");
			System.out.println("            7 - Cancelar Pedido                      ");
			System.out.println("            8 - Pagar Pedido                         ");
			System.out.println("            9 - Adicionar Crédito                    ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println("\\nPetzilla - O monstro das ofertas e dos cuidados para seu pet!");
				
	             		leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "\n Cadastrar clientes");
				break;
				
			case 2:
				System.out.println(Cores.TEXT_WHITE + "\n Listar Pedidos");
				
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "\n Buscar Clientes");
				
				break;
				
			case 4:
				System.out.println(Cores.TEXT_WHITE + "\n Buscar Pedidos");
				
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "\n Atualizar Dados do Cliente");
				
				break;
				
			case 6:
				System.out.println(Cores.TEXT_WHITE + "\n Remover Cliente");
				
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "\n Cancelar Pedido");
				
				break;
				
			case 8:
				System.out.println(Cores.TEXT_WHITE + "\n Pagar Pedido");
				
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE + "\n Adicionar Crédito");
				
				break;
				
			case 0:
				System.out.println(Cores.TEXT_WHITE + "\n Terminado");
				break;
				
			default:
				System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);
				
				
				break;
		}
		
	}
	
	}
	
}
