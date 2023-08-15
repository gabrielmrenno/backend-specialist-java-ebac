package test.java.br.com.grenno;

import main.java.br.com.grenno.domain.Customer;
import main.java.br.com.grenno.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.java.br.com.grenno.dao.CustomerDAOMock;

public class CustomerTest {

    private final CustomerService customerService;
    private final CustomerDAOMock customerDAO;
    private Customer customer;

    public CustomerTest() {
        customerDAO = new CustomerDAOMock();
        this.customerService = new CustomerService(customerDAO);
    }

    @BeforeEach
    public void init() {
        customer = new Customer(
                null,
                "Gabriel",
                12312312312L,
                119999999L,
                "Av. Alferes Renó",
                180,
                "Piranguinho",
                "MG"
        );
        customerService.save(customer);
    }

    @Test
    public void searchCustomer() {
        Customer customerFound = customerService.findByDoc(customer.getDoc());
        Assertions.assertNotNull(customerFound);
    }

    @Test
    public void saveCustomer() {
        customerService.save(customer);
        Assertions.assertEquals(2, customerDAO.getCustomerList().size());
    }

    @Test
    public void deleteCustomer() {
        customerService.delete(customer.getId());
        Assertions.assertEquals(0, customerDAO.getCustomerList().size());
    }

    public void updateCustomer() {
        customer.setName("Another name");
        customerService.update(customer);
        Customer customerInDB = customerDAO.findByDoc(customer.getDoc());
        Assertions.assertEquals("Another name", customerInDB.getName());
    }
}
