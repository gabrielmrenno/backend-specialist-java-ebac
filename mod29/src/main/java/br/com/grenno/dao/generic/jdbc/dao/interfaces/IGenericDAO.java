package main.java.br.com.grenno.dao.generic.jdbc.dao.interfaces;

import main.java.br.com.grenno.domain.Customer;

import java.util.List;

public interface IGenericDAO<T> {
    Integer register(T entity) throws Exception;
    Integer update(T entity) throws Exception;
    T getByCode(String code) throws Exception;
    List<T> list() throws Exception;
    Integer delete(T entity) throws Exception;
}
