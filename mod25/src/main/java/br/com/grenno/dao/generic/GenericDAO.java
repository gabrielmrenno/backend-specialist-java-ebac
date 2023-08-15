package main.java.br.com.grenno.dao.generic;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public abstract class GenericDAO<T extends Entity> implements IGenericDAO<T> {
    /**
     * Get unique instance of db
     */
    private final SingletonMap singletonMap;
    public abstract Class<T> getClassType();
    public abstract void updateData(T entity, T savedEntity);
    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }
    private Map<UUID, T> getTable() {
        Map<UUID, T> table = (Map<UUID, T>) this.singletonMap.getMap().get(getClassType());
        if (table == null) {
            table = new HashMap<>();
            this.singletonMap.getMap().put(getClassType(), table);
        }
        return table;
    }
    public void save(T entity) {
        Map<UUID, T> table = getTable();
        UUID entityId = entity.getId();
        if(table.containsKey(entityId)) {
            throw new IllegalStateException(entity.getClass() + "Already exists");
        }
        table.put(entityId, entity);
    }

    public void update(T entity) {
        Map<UUID, T> table = getTable();
        UUID entityId = entity.getId();
        T savedObject = table.get(entityId);
        if(savedObject != null) updateData(entity, savedObject);
    }

    public T getById(UUID entityId) {
        Map<UUID, T> table = getTable();
        return table.get(entityId);
    }

    public Collection<T> list() {
        Map<UUID, T> table = getTable();
        return table.values();
    }
}
