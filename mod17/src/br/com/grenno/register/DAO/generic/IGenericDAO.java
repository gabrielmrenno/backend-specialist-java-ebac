package br.com.grenno.register.DAO.generic;

import br.com.grenno.register.domain.IPersistent;
import br.com.grenno.register.domain.Product;

import java.util.Collection;

public interface IGenericDAO<T extends IPersistent> {
    public Boolean register(T entity);
    public void delete(Long primaryKey);
    public void update(T entity);
    public T find(Long primaryKey);
    public Collection<T> fetchAll();
}
