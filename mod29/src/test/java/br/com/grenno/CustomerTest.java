package test.java.br.com.grenno;

import main.java.br.com.grenno.dao.generic.jdbc.dao.CustomerDAO;
import main.java.br.com.grenno.dao.generic.jdbc.dao.interfaces.IGenericDAO;
import main.java.br.com.grenno.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private IGenericDAO<Customer> customerDAO;

    @AfterEach
    public void truncateDatabase() throws Exception {
        customerDAO = new CustomerDAO();
        for (Customer customer : customerDAO.list()) {
            customerDAO.delete(customer);
        }
    }
    @Test
    public void testAllDao() throws Exception {
        customerDAO = new CustomerDAO();

        // register customers
        Customer customer1 = new Customer("10", "Customer 10");
        Customer customer2 = new Customer("21", "Customer 21");
        Integer result = customerDAO.register(customer1);
        Integer result2 = customerDAO.register(customer2);
        assertEquals(1, (int) result);

        // list customers
        int countOnList = customerDAO.list().size();
        assertEquals(2, countOnList);

        // get customer by code from db and update
        Customer customerInDb = customerDAO.getByCode("10");
        assertNotNull(customerInDb);
        assertEquals(customer1.getName(), customerInDb.getName());
        assertEquals(customer1.getCode(), customerInDb.getCode());
        customerInDb.setName("Customer 10 Updated");
        customerInDb.setCode("11");
        Integer countOnUpdate = customerDAO.update(customerInDb);
        assertEquals(1, (int) countOnUpdate);
        Customer customerUpdated = customerDAO.getByCode("11");
        assertNotNull(customerUpdated);
        assertEquals(customerInDb.getName(), customerUpdated.getName());
        assertEquals(customerInDb.getCode(), customerUpdated.getCode());

        // delete customers
        Integer countOnDelete = customerDAO.delete(customerInDb);
        Integer countOnDelete2 = customerDAO.delete(customer2);
        assertEquals(1, (int) countOnDelete);
        assertEquals(1, (int) countOnDelete2);
    }
}
