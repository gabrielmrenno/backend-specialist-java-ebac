import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número");
        // scanner.nextInt() returns an int number
        int number = scanner.nextInt();
        // boxing the variable
        Integer wrappedNumber = number;

        System.out.println("O número digitado é: " + wrappedNumber);
    }
}