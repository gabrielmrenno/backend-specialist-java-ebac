package main.java.br.com.grenno.dao.generic;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface IGenericDAO<T extends Entity> {
    public void save(T entity);

    public void update(T entity);

    public T getById(UUID entityId);

    public Collection<T> list();

    public void delete(UUID entityId);
}
