import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        readNameAndSort(scanner);
        readNameAndGender(scanner);
    }

    private static void readNameAndSort(Scanner scanner) {
        System.out.println("***** readNameAndSort *****");
        System.out.println("Insira nomes separados por vírgula:");

        String input = scanner.nextLine();
        // Splitting input into String Array
        String[] names = input.trim().split(",");

        List<String> namesList = new ArrayList<>();

        // Getting out spaces and putting on List
        for (String name : names) {
            namesList.add(name.trim());
        }

        // sorting
        Collections.sort(namesList);

        System.out.println(namesList);
    }

    private static void readNameAndGender(Scanner scanner) {
        System.out.println("***** readNameAndGender *****");
        System.out.println("Insira nomes e genero separados por vírgula, por exemplo: Gabriel-M, ...");

        String input = scanner.nextLine();

        // Splitting
        String[] namesAndGenders = input.split(",");

        List<String> malePeople = new ArrayList<>();
        List<String> femalePeople = new ArrayList<>();
        List<String> othersPeople = new ArrayList<>();

        for (String nameAndGender : namesAndGenders) {
            String[] splittedNameAndGender = nameAndGender.split("-");
            String name = splittedNameAndGender[0];
            String gender = splittedNameAndGender[1];

            if (gender.equals("M")) {
                malePeople.add(name.trim());
            } else if (gender.equals("F")) {
                femalePeople.add(name.trim());
            } else {
                othersPeople.add(name.trim());
            }
        }

        System.out.println("Masculino: " + malePeople);
        System.out.println("Feminino: " + femalePeople);
        System.out.println("Outros: " + othersPeople);

    }
}