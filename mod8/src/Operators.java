public class Operators {
    public static void main( String[] args ) {
        arithmeticOperations();
        assignmentOperations();
    }

    private static void assignmentOperations() {
        int number1 = 10;
        int number2 = 10;
        int number3 = number1 + number2;
        number3 += number2; // number3 = number3 + number2
    }


    public static void arithmeticOperations() {
        int num1 = 10;
        int num2 = 20;

        int num3 = num1 + num2;
        int num4 = num1 - num2;
        int num5 = num2 / num1;
        int num6 = num1 * num2;
        int num7 = (10 + 10)/2;

        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(num7);
    }
}
