package petshop.Produtos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

	
	    private List<Produto> produtos;

	    public Estoque() {
	        produtos = new ArrayList<>();
	        inicializarEstoque();
	    }

	    public void inicializarEstoque() {
	        produtos.add(new Produto("Ração", 30.0));
	        produtos.add(new Produto("Brinquedo", 15.0));
	        produtos.add(new Produto("Coleira", 25.0));
	        produtos.add(new Produto("Alpiste", 10.0));
	    }

	    public void listarProdutos() {
	        System.out.println("\nLista de Produtos:");
	        if (produtos.isEmpty()) {
	            System.out.println("Não há produtos no estoque.");
	        } else {
	            for (Produto produto : produtos) {
	                System.out.println(produto.getNome() + " - R$ " + produto.getPreco());
	        }
	        }
	    }

	    public Produto buscarProdutoPorNome(String nome) {
	        for (Produto produto : produtos) {
	            if (produto.getNome().equalsIgnoreCase(nome)) {
	                return produto;
	            }
	        }
	        return null;
	    }
	}


