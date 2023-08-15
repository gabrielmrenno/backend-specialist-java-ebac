package main.java.br.com.grenno.dao;

import main.java.br.com.grenno.dao.generic.GenericDAO;
import main.java.br.com.grenno.dao.generic.SingletonMap;
import main.java.br.com.grenno.domain.Customer;

import java.util.Map;
import java.util.UUID;

public class CustomerDAO extends GenericDAO<Customer> implements ICustomerDAO{
    private final SingletonMap singletonMap;

    public CustomerDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    private Map<UUID, Customer> getCustomerTable() {
        Map<UUID, Customer> customerTable = (Map<UUID, Customer>) singletonMap.getMap().get(this.getClassType());
        return customerTable;
    }

    @Override
    public Class<Customer> getClassType() {
        return Customer.class;
    }

    @Override
    public void updateData(Customer customer, Customer savedCustomer) {
        savedCustomer.setName(customer.getName());
        savedCustomer.setAddress(customer.getAddress());
        savedCustomer.setAddressNumber(customer.getAddressNumber());
        savedCustomer.setCity(customer.getCity());
        savedCustomer.setState(customer.getState());
        savedCustomer.setDoc(customer.getDoc());
        savedCustomer.setPhone(customer.getPhone());
    }

    @Override
    public Customer findByDoc(Long doc) {
        Map<UUID, Customer> customerTable = getCustomerTable();
        for (Customer customer : customerTable.values()) {
            if(customer.getDoc().equals(doc)) return customer;
        }
        return null;
    }

    @Override
    public void delete(UUID entityId) {

    }
}
