package br.com.grenno.register.DAO;

import br.com.grenno.register.DAO.generic.GenericDAO;
import br.com.grenno.register.domain.IPersistent;
import br.com.grenno.register.domain.Product;

import java.util.Collection;

public class ProductDAO extends GenericDAO<Product> {
    @Override
    public Class getClassType() {
        return Product.class;
    }

    @Override
    public void updateSpecificEntity(Product entityDataToUpdate, Product registeredObject) {
        registeredObject.setCode(entityDataToUpdate.getCode());
        registeredObject.setName(entityDataToUpdate.getName());
    }
}
