import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input: (name - M, name - F, ...)
            // example: Gabriel - M, Maria - F
        // Output: list of female person
        ArrayList<String> femalePerson = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a lista de pessoas e seu sexo separados por vírgula (ex.: Fulano - F):");
        String listOfPerson = scanner.nextLine();

        String[] personList = listOfPerson.split(",");
        for (String person : personList ) {
            String[] nameAndSex = person.trim().split("-");
            String sex = nameAndSex[1].trim();
            if (sex.equals("F")) {
                femalePerson.add(person);
            }
        }

        System.out.println(femalePerson);
    }
}