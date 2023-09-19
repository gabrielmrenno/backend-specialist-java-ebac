package main.java.br.com.grenno.dao.generic.jdbc.dao;

import main.java.br.com.grenno.dao.generic.jdbc.ConnectionFactory;
import main.java.br.com.grenno.dao.generic.jdbc.dao.interfaces.IGenericDAO;
import main.java.br.com.grenno.domain.Customer;
import main.java.br.com.grenno.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IGenericDAO<Product> {
    @Override
    public Integer register(Product product) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            // set sql command
            String sql = "INSERT INTO product (id, name, code, price) VALUES (nextval('sq_customer'), ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            // replace ? with string:
            statement.setString(1, product.getName());
            statement.setString(2, product.getCode());
            statement.setDouble(3, product.getPrice());
            return statement.executeUpdate();
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    @Override
    public Integer update(Product product) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE product SET NAME = ?, CODE = ?, PRICE = ? WHERE ID = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getCode());
            statement.setDouble(3, product.getPrice());
            statement.setLong(4, product.getId());
            return statement.executeUpdate();
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    @Override
    public Product getByCode(String code) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM product WHERE CODE = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, code);
            resultSet = statement.executeQuery();
            // pass by each line in result
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("ID"));
                product.setCode(resultSet.getString("CODE"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
            }
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return product;
    }

    @Override
    public List<Product> list() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> productArrayList = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM product";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("ID"));
                product.setCode(resultSet.getString("CODE"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getDouble("PRICE"));
                productArrayList.add(product);
            }
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return productArrayList;
    }

    @Override
    public Integer delete(Product product) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM product WHERE CODE = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getCode());
            return statement.executeUpdate();
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
