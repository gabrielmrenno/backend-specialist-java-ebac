package main.java.br.com.grenno.services;

import main.java.br.com.grenno.dao.CustomerDAO;
import main.java.br.com.grenno.dao.ICustomerDAO;
import main.java.br.com.grenno.domain.Customer;

import java.util.UUID;

public class CustomerService {
    private final ICustomerDAO customerDAO;

    public CustomerService(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    public Customer findByDoc(Long doc) {
        return customerDAO.findByDoc(doc);
    }
    public void delete(UUID customerId) {
        customerDAO.delete(customerId);
    }
    public void update(Customer customer) {
        customerDAO.update(customer);
    }
}
