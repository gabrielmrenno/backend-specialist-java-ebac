import br.com.grenno.annotation.Table;
import br.com.grenno.domain.Product;

public class Main {
    public static void main(String[] args) {
        Class<Product> productClass = Product.class;

        Table annotation = productClass.getAnnotation(Table.class);

        String annotationValue = annotation.value();

        System.out.println("Annotation value: " + annotationValue);
    }
}