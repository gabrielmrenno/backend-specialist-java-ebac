package test.java.br.com.grenno.dao;

import main.java.br.com.grenno.dao.ICustomerDAO;
import main.java.br.com.grenno.dao.generic.GenericDAO;
import main.java.br.com.grenno.domain.Customer;

import java.util.*;

public class CustomerDAOMock extends GenericDAO<Customer> implements ICustomerDAO {
    private final List<Customer> customerList;

    @Override
    public Class<Customer> getClassType() {
        return Customer.class;
    }

    @Override
    public void updateData(Customer entity, Customer savedEntity) {

    }
    public CustomerDAOMock() {
        this.customerList = new ArrayList<>();
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findByDoc(Long doc) {
        for (Customer customer : customerList) {
            if (customer.getDoc().equals(doc)) return customer;
        }
        return null;
    }

    @Override
    public void delete(UUID customerId) {
        Customer customerFound = this.getById(customerId);
        System.out.println();
        if (customerFound == null) {
            throw new IllegalStateException("Customer not found");
        }
        customerList.remove(customerFound);
    }

    @Override
    public Customer getById(UUID entityId) {
        return customerList.stream()
                .filter(customer -> customer.getId().equals(entityId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Customer> list() {
        return customerList;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }
    public void clearCustomerList() {
        this.customerList.clear();
    }
}
