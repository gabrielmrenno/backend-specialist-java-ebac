package test.java.br.com.grenno.dao;

import main.java.br.com.grenno.dao.ICustomerDAO;
import main.java.br.com.grenno.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOMock implements ICustomerDAO {
    private final List<Customer> customerList;

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
    public void delete(Long doc) {
        Customer customerFound = this.findByDoc(doc);
        if (customerFound == null) {
            throw new IllegalStateException("Customer not found");
        }
        customerList.remove(customerFound);
    }

    @Override
    public void update(Customer customer) {

    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }
    public void clearCustomerList() {
        this.customerList.clear();
    }
}
