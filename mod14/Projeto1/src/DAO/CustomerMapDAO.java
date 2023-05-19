package DAO;

import domain.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerMapDAO implements ICustomerDAO {

    private Map<Long, Customer> map;

    public CustomerMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean register(Customer customer) {
        if(this.map.containsKey(customer.getDoc())) {
            return false;
        }
        this.map.put(customer.getDoc(), customer);
        return true;
    }

    @Override
    public void delete(Long doc) {
        Customer registeredCustomer = this.map.get(doc);

        if(registeredCustomer != null) {
            this.map.remove(registeredCustomer.getDoc(), registeredCustomer);
        }
    }

    @Override
    public void update(Customer customer) {
        Customer registeredCustomer = this.map.get(customer.getDoc());

        if(registeredCustomer != null) {
            registeredCustomer.setName(customer.getName());
            registeredCustomer.setPhone(customer.getPhone());
            registeredCustomer.setNumber(customer.getNumber());
            registeredCustomer.setAddress(customer.getAddress());
            registeredCustomer.setCity(customer.getCity());
            registeredCustomer.setState(customer.getAddress());
        }
    }

    @Override
    public Customer find(Long doc) {
        return this.map.get(doc);
    }

    @Override
    public Collection<Customer> fetchAll() {
        return this.map.values();
    }
}
