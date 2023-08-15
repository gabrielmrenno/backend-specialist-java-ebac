package main.java.br.com.grenno.services;

import main.java.br.com.grenno.dao.CustomerDAO;
import main.java.br.com.grenno.dao.ICustomerDAO;
import main.java.br.com.grenno.domain.Customer;

public class CustomerService implements ICustomerService {
    private final ICustomerDAO customerDAO;

    public CustomerService(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public Customer findByDoc(Long doc) {
        return customerDAO.findByDoc(doc);
    }

    @Override
    public void delete(Long doc) {
        customerDAO.delete(doc);
    }

    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);
    }
}
