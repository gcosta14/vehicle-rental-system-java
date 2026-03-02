import java.io.*;
import java.util.ArrayList;

public class GestorAlugueres {
    private ArrayList<Aluguer> alugueres = new ArrayList<>();

    public ArrayList<Aluguer> getAlugueres() {
        return alugueres;
    }

    public void carregar(String nomeFicheiro) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFicheiro));
            alugueres = (ArrayList<Aluguer>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sem alugueres anteriores.");
        } catch (Exception e) {
            System.out.println("Erro a ler alugueres.");
        }
    }

    public void guardar(String nomeFicheiro) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            oos.writeObject(alugueres);
            oos.close();
        } catch (Exception e) {
            System.out.println("Erro a guardar alugueres.");
        }
    }

    public void adicionar(Aluguer a) {
        alugueres.add(a);
    }
}
