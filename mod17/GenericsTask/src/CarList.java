import br.com.grenno.domain.Car;

import java.util.HashMap;
import java.util.Map;

public abstract class CarList<T extends Car> {
    private Map<Long, T> map;

    public abstract void getKey();

    public CarList() {
        this.map = new HashMap<>();
    }

}
