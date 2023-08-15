package main.java.br.com.grenno.dao;

import main.java.br.com.grenno.domain.Customer;

import java.util.Optional;

public interface ICustomerDAO {

    void save(Customer customer);

    Customer findByDoc(Long doc);

    void delete(Long doc);

    void update(Customer customer);
}
