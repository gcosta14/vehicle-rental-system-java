import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static int lerInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.println("Valor inválido. Introduza um número inteiro.");
            sc.next();
            System.out.print(msg);
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    public static boolean lerBoolean(String msg) {
        System.out.print(msg);
        while (!sc.hasNextBoolean()) {
            System.out.println("Valor inválido. Introduza true ou false.");
            sc.next();
            System.out.print(msg);
        }
        boolean b = sc.nextBoolean();
        sc.nextLine();
        return b;
    }

    public static String lerString(String msg) {
        System.out.print(msg);
        String s = sc.nextLine().trim();
        while (s.isEmpty()) {
            System.out.println("Valor inválido. Não pode ser vazio.");
            System.out.print(msg);
            s = sc.nextLine().trim();
        }
        return s;
    }

    public static String lerMetodoPagamento() {
        String metodo;
        do {
            metodo = lerString("Método de pagamento (cartão de crédito / referência multibanco): ");
        } while (
                !metodo.equals("cartão de crédito") &&
                        !metodo.equals("referência multibanco")
        );
        return metodo;
    }

    public static String lerPolo() {
        String polo;
        do {
            polo = lerString("Polo (Polo I / Polo II / Polo III): ");
        } while (
                !polo.equals("Polo I") &&
                        !polo.equals("Polo II") &&
                        !polo.equals("Polo III")
        );
        return polo;
    }

    public static String lerTipoUtilizador() {
        String tipo;
        do {
            tipo = lerString("Tipo (estudante/docente/naodocente): ");
        } while (
                !tipo.equals("estudante") &&
                        !tipo.equals("docente") &&
                        !tipo.equals("naodocente")
        );
        return tipo;
    }

    public static Veiculo lerVeiculoValido(ArrayList<Veiculo> veiculos) {
        Veiculo escolhido = null;
        while (escolhido == null) {
            int id = lerInt("ID do veículo: ");
            for (Veiculo v : veiculos) {
                if (v.getId() == id) {
                    escolhido = v;
                    break;
                }
            }
            if (escolhido == null) {
                System.out.println("ID inválido. Introduza um ID que exista na lista.");
            }
        }
        return escolhido;
    }


    public static void main(String[] args) {

        ArrayList<Utilizador> utilizadores =
                LeitorFicheiros.carregarUtilizadores("denis/src/utilizadores.txt");

        ArrayList<Veiculo> veiculos =
                LeitorFicheiros.carregarVeiculos("denis/src/veículos.txt");

        GestorAlugueres gestor = new GestorAlugueres();
        gestor.carregar("denis/src/alugueres.obj");

        int opcao = -1;

        while (opcao != 3) {

            System.out.println("\n--- MOBILIDADE UC ---");
            System.out.println("1. Criar Aluguer");
            System.out.println("2. Listar Alugueres");
            System.out.println("3. Terminar");

            opcao = lerInt("Opção: ");

            if (opcao == 1) {

                System.out.println("\n--- Lista de Utilizadores ---");
                for (Utilizador u2 : utilizadores)
                    System.out.println(u2.getNumeroMecanografico() + " -> " + u2);

                int mec = lerInt("\nNúmero mecanográfico do utilizador: ");

                Utilizador u = null;
                for (Utilizador x : utilizadores)
                    if (x.getNumeroMecanografico() == mec)
                        u = x;

                if (u == null) {
                    boolean criar = lerBoolean("Utilizador não encontrado. Criar novo? (true/false): ");

                    if (criar) {

                        String tipoNovo = lerTipoUtilizador();

                        if (tipoNovo.equals("estudante")) {

                            String metodo = lerMetodoPagamento();
                            String curso = lerString("Curso: ");
                            String polo = lerPolo();

                            u = new Estudante(mec, metodo, curso, polo);

                            try {
                                BufferedWriter bw = new BufferedWriter(new FileWriter("projeto/src/utilizadores.txt", true));
                                bw.write("estudante;" + mec + ";" + metodo + ";" + curso + ";" + polo);
                                bw.newLine();
                                bw.close();
                            } catch (Exception e) { }
                        }

                        else if (tipoNovo.equals("docente")) {

                            String metodo = lerMetodoPagamento();
                            int ano = lerInt("Ano de contrato: ");
                            String facs = lerString("Faculdades (separadas por vírgulas): ");

                            u = new Docente(mec, metodo, ano, Arrays.asList(facs.split(",")));

                            try {
                                BufferedWriter bw = new BufferedWriter(new FileWriter("projeto/src/utilizadores.txt", true));
                                bw.write("docente;" + mec + ";" + metodo + ";" + ano + ";" + facs);
                                bw.newLine();
                                bw.close();
                            } catch (Exception e) { }
                        }

                        else if (tipoNovo.equals("naodocente")) {

                            String metodo = lerMetodoPagamento();
                            int ano = lerInt("Ano de contrato: ");
                            String servico = lerString("Serviço: ");

                            u = new NaoDocente(mec, metodo, ano, servico);

                            try {
                                BufferedWriter bw = new BufferedWriter(new FileWriter("projeto/src/utilizadores.txt", true));
                                bw.write("naodocente;" + mec + ";" + metodo + ";" + ano + ";" + servico);
                                bw.newLine();
                                bw.close();
                            } catch (Exception e) { }
                        }

                        utilizadores.add(u);
                    } else continue;
                }

                System.out.println("\n--- Lista de Veículos ---");
                for (Veiculo v2 : veiculos)
                    System.out.println(v2.getId() + " -> " + v2);

                Veiculo v = lerVeiculoValido(veiculos);

                int horas = lerInt("Horas de utilização: ");
                boolean capacete = lerBoolean("Capacete (true/false): ");
                boolean luz = lerBoolean("Luz (true/false): ");

                ServicoAdicional serv = new ServicoAdicional(capacete, luz);

                Aluguer a = new Aluguer(u, v, horas, serv);
                gestor.adicionar(a);

                System.out.println("\nAluguer criado com sucesso!");
                System.out.println("Custo total: " + a.calcularAluguer());
            }

            else if (opcao == 2) {
                System.out.println("\n--- Lista de Alugueres ---");
                for (Aluguer a : gestor.getAlugueres()) {
                    System.out.println(a);
                    System.out.println("Custo: " + a.calcularAluguer());
                }
            }

            else if (opcao == 3) {
                System.out.println("A guardar dados...");
                gestor.guardar("projeto/src/alugueres.obj");
                System.out.println("Programa terminado.");
            }

            else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
