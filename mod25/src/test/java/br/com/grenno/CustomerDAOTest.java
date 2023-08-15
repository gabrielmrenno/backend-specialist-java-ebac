package test.java.br.com.grenno;

import main.java.br.com.grenno.dao.ICustomerDAO;
import main.java.br.com.grenno.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.java.br.com.grenno.dao.CustomerDAOMock;

public class CustomerDAOTest {
    private final ICustomerDAO customerDAO;
    private Customer customer;

    @BeforeEach
    public void init() {
        customer = new Customer(
                "Gabriel",
                12312312312L,
                119999999L,
                "Av. Alferes Renó",
                180,
                "Piranguinho",
                "MG"
        );
        customerDAO.save(customer);
    }

    public CustomerDAOTest() {
        this.customerDAO= new CustomerDAOMock();
    }
    @Test
    public void findCustomer(){
        Customer customerFound = customerDAO.findByDoc(customer.getDoc());
        Assertions.assertNotNull(customerFound);
    }
}
