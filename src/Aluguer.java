import java.io.Serializable;

public class Aluguer implements Serializable {

    private Utilizador utilizador;
    private Veiculo veiculo;
    private int horas; // tempo já calculado
    private ServicoAdicional servicos;

    public Aluguer(Utilizador utilizador, Veiculo veiculo, int horas, ServicoAdicional servicos) {
        this.utilizador = utilizador;
        this.veiculo = veiculo;
        this.horas = horas;
        this.servicos = servicos;
    }

    public double calcularAluguer(){
        double precoBase = utilizador.precoHora(veiculo);

        int dias = horas / 24;
        int horasRestantes = horas % 24;

        double custoTempo = dias * (8 * precoBase) + horasRestantes * precoBase;

        int diasServicos = (horasRestantes == 0) ? dias : dias + 1;

        double custoServicos = 0;
        if (servicos.hasCapacete()) custoServicos += 5 * diasServicos;
        if (servicos.hasLuz())      custoServicos += 2.5 * diasServicos;


        double custoTotal = (custoServicos + custoTempo)* utilizador.multiplicadorUtilizador();

        return custoTotal;
    }

    public Utilizador getUtilizador() { return utilizador; }
    public Veiculo getVeiculo() { return veiculo; }
    public int getHoras() { return horas; }
    public ServicoAdicional getServicos() { return servicos; }

    public String toString() {
        return "Aluguer → " + utilizador + " | " + veiculo + " | Horas: " + horas + " | " + servicos;
    }
}
