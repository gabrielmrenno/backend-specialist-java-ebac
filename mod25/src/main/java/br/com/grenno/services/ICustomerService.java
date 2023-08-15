package main.java.br.com.grenno.services;

import main.java.br.com.grenno.domain.Customer;

public interface ICustomerService {
    void save(Customer customer);
    Customer findByDoc(Long doc);
    void delete(Long doc);
    void update(Customer customer);
}
