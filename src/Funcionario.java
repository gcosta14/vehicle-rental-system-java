public abstract class Funcionario extends Utilizador{

    private int anoContrato;

    public Funcionario(int numeroMecanografico, String metodoPagamento, int anoContrato) {
        super(numeroMecanografico, metodoPagamento);
        this.anoContrato = anoContrato;
    }
    public int getAnoContrato() {return anoContrato;}

    public String toString() {
        return super.toString() + ", Ano do contrato: " + anoContrato;
    }
}
