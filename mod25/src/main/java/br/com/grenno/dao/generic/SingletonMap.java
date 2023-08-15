package main.java.br.com.grenno.dao.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author gabriel.renno
 * Create a singleton to map, that represents a database in our application
 */
public class SingletonMap {
    private static SingletonMap singletonMap;

    /**
     * database mock
     * A list of list (table), that has id with UUID type
     */
    protected Map<Class, Map<UUID, ?>> map;

    private SingletonMap() {
        this.map = new HashMap<>();
    }

    public static SingletonMap getInstance() {
        if(singletonMap == null) {
            singletonMap = new SingletonMap();
        }
        return singletonMap;
    }

    public Map<Class, Map<UUID, ?>> getMap() {
        return this.map;
    }
}
