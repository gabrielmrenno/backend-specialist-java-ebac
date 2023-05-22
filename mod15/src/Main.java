import br.com.grenno.factory.CarFactory;
import br.com.grenno.factory.SUVFactory;
import br.com.grenno.factory.SedanFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating a Sedan car");
        CarFactory sedanCar = new SedanFactory();
        sedanCar.deliverCar();

        System.out.println("Creating a SUV car");
        CarFactory suvCar = new SUVFactory();
        suvCar.deliverCar();
    }
}