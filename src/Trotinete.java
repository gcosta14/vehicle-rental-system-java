public class Trotinete extends Veiculo {

    private int nivelBateria;
    private boolean lcd;

    public Trotinete(int id, String gps, int nivelBateria, boolean lcd) {
        super(id, gps);
        this.nivelBateria = nivelBateria;
        this.lcd = lcd;
    }

    public int getNivelBateria() { return nivelBateria; }

    public boolean hasLcd() { return lcd; }

    public double precoHoraEstudante() { return lcd ? 1.10 : 1.0; }

    public double precoHoraFuncionario() { return lcd ? 2.6 : 2.5; }

    public String toString() {
        return "Trotinete: " + super.toString() + ", Bateria: " + nivelBateria + "%, LCD: " + lcd;
    }
}
