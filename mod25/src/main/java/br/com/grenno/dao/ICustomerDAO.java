package main.java.br.com.grenno.dao;

import main.java.br.com.grenno.dao.generic.IGenericDAO;
import main.java.br.com.grenno.domain.Customer;

import java.util.Optional;

public interface ICustomerDAO extends IGenericDAO<Customer> {
    Customer findByDoc(Long doc);
}
