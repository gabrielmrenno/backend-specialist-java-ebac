import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("As notas devem ser de 0 a 10:");
        System.out.println("Digite a primeira nota:");
        double grade1 = s.nextDouble();
        System.out.println("Digite a segunda nota:");
        double grade2 = s.nextDouble();
        System.out.println("Digite a terceira nota:");
        double grade3 = s.nextDouble();
        System.out.println("Digite a quarta nota:");
        double grade4 = s.nextDouble();

        double average = (grade1 + grade2 + grade3 + grade4) / 4;

        if(average >= 5 && average < 7) {
            System.out.println("Recuperação");
        }
        else if (average >= 7) {
            System.out.println("Aprovado");
        }
        else {
            System.out.println("Reprovado");
        }
    }
}