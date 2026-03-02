import java.io.Serializable;

public abstract class Veiculo implements Serializable {

    private int id;
    private String gps;

    public Veiculo(int id, String gps) {
        this.id = id;
        this.gps = gps;
    }

    public int getId() { return id; }

    public String getGps() { return gps; }

    public abstract double precoHoraEstudante();

    public abstract double precoHoraFuncionario();

    public String toString() {
        return "ID: " + id + ", GPS: " + gps;
    }
}
