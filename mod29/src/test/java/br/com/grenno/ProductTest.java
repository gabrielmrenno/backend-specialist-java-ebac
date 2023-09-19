package test.java.br.com.grenno;

import main.java.br.com.grenno.dao.generic.jdbc.dao.CustomerDAO;
import main.java.br.com.grenno.dao.generic.jdbc.dao.ProductDAO;
import main.java.br.com.grenno.dao.generic.jdbc.dao.interfaces.IGenericDAO;
import main.java.br.com.grenno.domain.Customer;
import main.java.br.com.grenno.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {
    private IGenericDAO<Product> productDAO;

    @AfterEach
    public void truncateDatabase() throws Exception {
        productDAO = new ProductDAO();
        for (Product product : productDAO.list()) {
            productDAO.delete(product);
        }
    }
    @Test
    public void testAllDao() throws Exception {
        productDAO = new ProductDAO();

        // register customers
        Product product1 = new Product("10", "Product 10", 10.0);
        Product product2 = new Product("20", "Product 21", 20.0);
        Integer result = productDAO.register(product1);
        Integer result2 = productDAO.register(product2);
        assertEquals(1, (int) result);
        assertEquals(1, (int) result2);

        // list customers
        int countOnList = productDAO.list().size();
        assertEquals(2, countOnList);

        // get customer by code from db and update
        Product productInDb = productDAO.getByCode("10");
        assertNotNull(productInDb);
        assertEquals(product1.getName(), productInDb.getName());
        assertEquals(product1.getCode(), productInDb.getCode());
        assertEquals(product1.getPrice(), productInDb.getPrice());
        productInDb.setName("Product 10 Updated");
        productInDb.setCode("11");
        Integer countOnUpdate = productDAO.update(productInDb);
        assertEquals(1, (int) countOnUpdate);
        Product productUpdated = productDAO.getByCode("11");
        assertNotNull(productUpdated);
        assertEquals(productInDb.getName(), productUpdated.getName());
        assertEquals(productInDb.getCode(), productUpdated.getCode());

        // delete customers
        Integer countOnDelete = productDAO.delete(productInDb);
        Integer countOnDelete2 = productDAO.delete(product2);
        assertEquals(1, (int) countOnDelete);
        assertEquals(1, (int) countOnDelete2);
    }
}
