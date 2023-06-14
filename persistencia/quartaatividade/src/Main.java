import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static CandidatoRepository candidatoRepository = new CandidatoRepository();

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1 - Listar candidatos");
            System.out.println("2 - Inserir candidato");
            System.out.println("3 - Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    ListarCandidatos();
                    break;
                case 2:
                    InserirCandidato();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void InserirCandidato() {
        Scanner scanner = new Scanner(System.in);
        Candidato candidato = new Candidato();
        System.out.println("Insira o nome: ");
        candidato.setNome(scanner.nextLine());
        System.out.println("Insira o sexo (m/f): ");
        candidato.setSexo(scanner.nextLine().charAt(0));
        System.out.println("Insira a data de nascimento (yyyy-MM-dd): ");
        candidato.setDataNasc(java.sql.Date.valueOf(scanner.nextLine()));
        System.out.println("Insira o cargo pretendido: ");
        candidato.setCargoPretendido(scanner.nextLine());
        System.out.println("Insira o texto do curriculo: ");
        candidato.setTextoCurriculo(scanner.nextLine());

        candidatoRepository.InsertCandidato(candidato);
    }

    private static void ListarCandidatos() {
        ArrayList<Candidato> candidatos = candidatoRepository.SelectCandidatos();

        for(Candidato candidato: candidatos) {
            System.out.printf(candidato.printCandidatos());
            System.out.println("--------------------");
        }
    }
}
