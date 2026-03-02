public class EBike extends Veiculo {

    private int nivelBateria;
    private boolean bateriaRemovivel;

    public EBike(int id, String gps, int nivelBateria, boolean bateriaRemovivel) {
        super(id, gps);
        this.nivelBateria = nivelBateria;
        this.bateriaRemovivel = bateriaRemovivel;
    }

    public int getNivelBateria() { return nivelBateria; }

    public boolean isBateriaRemovivel() { return bateriaRemovivel; }

    public double precoHoraEstudante() { return bateriaRemovivel ? 1.50 : 1.25; }

    public double precoHoraFuncionario() { return bateriaRemovivel ? 3.0 : 2.75; }


    public String toString() {
        return "E-Bike: " + super.toString() + ", Bateria: " + nivelBateria + "%, Removível: " + bateriaRemovivel;
    }
}
