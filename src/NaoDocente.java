public class NaoDocente extends Funcionario {

    private String servico;

    public NaoDocente(int numeroMecanografico, String metodoPagamento, int anoContrato, String servico) {
        super(numeroMecanografico, metodoPagamento, anoContrato);
        this.servico = servico;
    }

    public String getServico() { return servico; }

    public double multiplicadorUtilizador() { return 0.5; }

    public double precoHora(Veiculo v){ return v.precoHoraFuncionario(); }

    public String toString() {
        return super.toString() + ", Serviço: " + servico;
    }
}
