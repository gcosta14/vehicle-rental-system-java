public class Bicicleta extends Veiculo {

    private boolean duasPessoas;

    public Bicicleta(int id, String gps, boolean duasPessoas) {
        super(id, gps);
        this.duasPessoas = duasPessoas;
    }

    public boolean isDuasPessoas() { return duasPessoas; }

    public double precoHoraEstudante() { return duasPessoas ? 2.0 : 1.0; }

    public double precoHoraFuncionario() { return duasPessoas ? 3.0 : 2.0; }

    public String toString() {
        return "Bicicleta: " + super.toString() + ", Duas pessoas: " + duasPessoas;
    }
}
