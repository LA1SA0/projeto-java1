package petshop.model;

public class PagamentoCartao extends Pagamento {
    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado com sucesso via Cartão de Crédito.");
    }
}

