package petshop.model;

public class PagamentoBoleto extends Pagamento {
    private String codigoBoleto;

    public PagamentoBoleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado com sucesso via Boleto Bancário.");
    }
}

	

