package petshop.Produtos;

import petshop.model.Cliente;
import petshop.Produtos.Produto;
import petshop.Pagamentos.Pagamento;

public class Pedido {
    private Cliente cliente;
    private Produto produto;
    private boolean pago;
    private Pagamento metodoPagamento;

    public Pedido(Cliente cliente, Produto produto, Pagamento metodoPagamento) {
        this.cliente = cliente;
        this.produto = produto;
        this.pago = false;
        this.metodoPagamento = metodoPagamento;
    }

    public void pagarPedido() {
        if (!pago) {
            if (cliente.getSaldoCarteira() >= produto.getPreco()) {
                metodoPagamento.processarPagamento(produto.getPreco());
                this.pago = true;
                System.out.println("Pedido pago com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para pagar o pedido.");
            }
        } else {
            System.out.println("O pedido já foi pago.");
        }
    }

    public void exibirPedido() {
        System.out.println("Pedido do cliente " + cliente.getNome() + " - Produto: " + produto.getNome() + " - Pago: " + (pago ? "Sim" : "Não"));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}

