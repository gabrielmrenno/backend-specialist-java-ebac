import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Linha:" + i);
            values.add(i);
        }

        for (Integer i : values) {
            System.out.println("Linha:" + i);
        }
        values.forEach(i-> System.out.println("Linha:" + i));
    }
}