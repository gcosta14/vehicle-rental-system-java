import java.io.Serializable;

public abstract class Utilizador implements Serializable {

    private int numeroMecanografico;
    private String metodoPagamento;

    public Utilizador(int numeroMecanografico, String metodoPagamento) {
        this.numeroMecanografico = numeroMecanografico;
        this.metodoPagamento = metodoPagamento;
    }

    public int getNumeroMecanografico() { return numeroMecanografico; }

    public String getMetodoPagamento() { return metodoPagamento; }

    public abstract double multiplicadorUtilizador();

    public abstract double precoHora(Veiculo v);

    public String toString() {
        return "Num Mec: " + numeroMecanografico + ", Pagamento: " + metodoPagamento;
    }
}
