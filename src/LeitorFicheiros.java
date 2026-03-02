import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitorFicheiros {

    public static ArrayList<Utilizador> carregarUtilizadores(String nomeFicheiro) {
        ArrayList<Utilizador> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
            String linha;

            while ((linha = br.readLine()) != null) {

                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(";");
                String tipo = partes[0];

                if (tipo.equals("estudante")) {
                    int mec = Integer.parseInt(partes[1]);
                    String pag = partes[2];
                    String curso = partes[3];
                    String polo = partes[4];
                    lista.add(new Estudante(mec, pag, curso, polo));
                }

                else if (tipo.equals("docente")) {
                    int mec = Integer.parseInt(partes[1]);
                    String pag = partes[2];
                    int ano = Integer.parseInt(partes[3]);
                    List<String> facs = Arrays.asList(partes[4].split(","));
                    lista.add(new Docente(mec, pag, ano, facs));
                }

                else if (tipo.equals("naodocente")) {
                    int mec = Integer.parseInt(partes[1]);
                    String pag = partes[2];
                    int ano = Integer.parseInt(partes[3]);
                    String servico = partes[4];
                    lista.add(new NaoDocente(mec, pag, ano, servico));
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Erro a ler utilizadores.");
        }

        return lista;
    }


    public static ArrayList<Veiculo> carregarVeiculos(String nomeFicheiro) {
        ArrayList<Veiculo> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro));
            String linha;

            while ((linha = br.readLine()) != null) {

                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(";");
                String tipo = partes[0];

                if (tipo.equals("bicicleta")) {
                    int id = Integer.parseInt(partes[1]);
                    String gps = partes[2];
                    boolean duas = Boolean.parseBoolean(partes[3]);
                    lista.add(new Bicicleta(id, gps, duas));
                }

                else if (tipo.equals("trotinete")) {
                    int id = Integer.parseInt(partes[1]);
                    String gps = partes[2];
                    int bateria = Integer.parseInt(partes[3]);
                    boolean lcd = Boolean.parseBoolean(partes[4]);
                    lista.add(new Trotinete(id, gps, bateria, lcd));
                }

                else if (tipo.equals("ebike")) {
                    int id = Integer.parseInt(partes[1]);
                    String gps = partes[2];
                    int bateria = Integer.parseInt(partes[3]);
                    boolean removivel = Boolean.parseBoolean(partes[4]);
                    lista.add(new EBike(id, gps, bateria, removivel));
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Erro a ler veículos.");
        }

        return lista;
    }
}
