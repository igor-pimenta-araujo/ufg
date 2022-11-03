import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Sigla do estado: ");
            String abbreviationProvided = scanner.nextLine().toUpperCase();
            System.out.print(BuffReader.searchAtCsv(abbreviationProvided));
        }
    }
}