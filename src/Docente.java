import java.util.List;

public class Docente extends Funcionario {

    private List<String> faculdades;

    public Docente(int numeroMecanografico, String metodoPagamento, int anoContrato, List<String> faculdades) {
        super(numeroMecanografico, metodoPagamento, anoContrato);
        this.faculdades = faculdades;
    }

    public List<String> getFaculdades() { return faculdades; }

    public double multiplicadorUtilizador() { return 1.0; }

    public double precoHora(Veiculo v){ return v.precoHoraFuncionario(); }

    public String toString() {
        return super.toString() + ", Faculdades: " + faculdades;
    }
}
