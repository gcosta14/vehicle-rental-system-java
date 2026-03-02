import java.io.Serializable;

public class ServicoAdicional implements Serializable {

    private boolean capacete;
    private boolean luz;

    public ServicoAdicional(boolean capacete, boolean luz) {
        this.capacete = capacete;
        this.luz = luz;
    }

    public boolean hasCapacete() { return capacete; }

    public boolean hasLuz() { return luz; }

    public String toString() {
        return "Capacete: " + capacete + ", Luz: " + luz;
    }
}
