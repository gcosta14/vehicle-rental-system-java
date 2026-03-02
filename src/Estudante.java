public class Estudante extends Utilizador {

    private String curso;
    private String polo;

    public Estudante(int numeroMecanografico, String metodoPagamento, String curso, String polo) {
        super(numeroMecanografico, metodoPagamento);
        this.curso = curso;
        this.polo = polo;
    }


    public String getCurso() { return curso; }

    public String getPolo() { return polo; }

    public double multiplicadorUtilizador() { return 1.0; }

    public double precoHora(Veiculo v){ return v.precoHoraEstudante(); }

    public String toString() {
        return super.toString() + ", Curso: " + curso + ", Polo: " + polo;
    }
}
