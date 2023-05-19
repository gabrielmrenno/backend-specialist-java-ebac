package br.com.grenno.dao;

import br.com.grenno.domain.Customer;

import java.util.Collection;

public interface ICustomerDAO {
    public Boolean register(Customer customer);
    public void delete(Long doc);
    public void update(Customer customer);
    public Customer find(Long doc);
    public Collection<Customer> fetchAll();
}
