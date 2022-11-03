import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Boolean keepGoing = true;

        Scanner scanner = new Scanner(System.in);

        while (Boolean.TRUE.equals(keepGoing)) {
            System.out.println("nome da pessoa: "); String name = scanner.nextLine();
            System.out.println("idade da pessoa: "); Integer age = scanner.nextInt();
            System.out.println("salario da pessoa: "); Double income = scanner.nextDouble();
            try {
                SavePerson.save(name, age, income);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String shouldContinue = "";
            while (!shouldContinue.toLowerCase().equals("n") && !shouldContinue.toLowerCase().equals("s")) {
                scanner.nextLine();
                System.out.print("Inserir outra pessoa? (S/N): ");
                shouldContinue = scanner.nextLine();
                if (shouldContinue.toLowerCase().equals("n")) { keepGoing = false; }
            }
        }
        scanner.close();
    }
}
