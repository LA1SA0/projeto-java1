package petshop.model;

public class Cliente {
    private String nome;
    private float saldoCarteira;

    public Cliente(String nome, float saldoCarteira) {
        this.nome = nome;
        this.saldoCarteira = saldoCarteira;
    }

    public void pagar(float valor) {
        if (saldoCarteira >= valor) {
            saldoCarteira -= valor;
            System.out.println("Pagamento realizado com sucesso! Novo saldo: R$ " + saldoCarteira);
        } else {
            System.out.println("Saldo insuficiente para realizar o pagamento.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldoCarteira() {
        return saldoCarteira;
    }

    public void setSaldoCarteira(float saldoCarteira) {
        this.saldoCarteira = saldoCarteira;
    }

    public void adicionarCredito(float valor) {
        if (valor > 0) {
            saldoCarteira += valor;
            System.out.println("Crédito adicionado! Novo saldo: R$ " + saldoCarteira);
        } else {
            System.out.println("Valor inválido para adicionar.");
        }
    }
}
