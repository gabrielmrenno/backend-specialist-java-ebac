package br.com.grenno.register.DAO;

import br.com.grenno.register.DAO.generic.GenericDAO;
import br.com.grenno.register.domain.Customer;

public class CustomerDAO extends GenericDAO<Customer> {

    @Override
    public Class<Customer> getClassType() {
        return Customer.class;
    }

    @Override
    public void updateSpecificEntity(Customer customerDataToUpdate, Customer customer) {
        customer.setName(customerDataToUpdate.getName());
        customer.setPhone(customerDataToUpdate.getPhone());
        customer.setNumber(customerDataToUpdate.getNumber());
        customer.setAddress(customerDataToUpdate.getAddress());
        customer.setCity(customerDataToUpdate.getCity());
        customer.setState(customerDataToUpdate.getAddress());
    }

    public CustomerDAO() {
        super();
    }

//    private Map<Long, Customer> map;
//
//    public CustomerMapDAO() {
//        this.map = new HashMap<>();
//    }
//
//    @Override
//    public Boolean register(Customer customer) {
//        if(this.map.containsKey(customer.getDoc())) {
//            return false;
//        }
//        this.map.put(customer.getDoc(), customer);
//        return true;
//    }
//
//    @Override
//    public void delete(Long doc) {
//        Customer registeredCustomer = this.map.get(doc);
//
//        if(registeredCustomer != null) {
//            this.map.remove(registeredCustomer.getDoc(), registeredCustomer);
//        }
//    }
//
//    @Override
//    public void update(Customer customer) {
//        Customer registeredCustomer = this.map.get(customer.getDoc());
//
//        if(registeredCustomer != null) {
//            registeredCustomer.setName(customer.getName());
//            registeredCustomer.setPhone(customer.getPhone());
//            registeredCustomer.setNumber(customer.getNumber());
//            registeredCustomer.setAddress(customer.getAddress());
//            registeredCustomer.setCity(customer.getCity());
//            registeredCustomer.setState(customer.getAddress());
//        }
//    }
//
//    @Override
//    public Customer find(Long doc) {
//        return this.map.get(doc);
//    }
//
//    @Override
//    public Collection<Customer> fetchAll() {
//        return this.map.values();
//    }
}
