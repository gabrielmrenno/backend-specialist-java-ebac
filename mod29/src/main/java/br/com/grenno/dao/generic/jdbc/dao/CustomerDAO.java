package main.java.br.com.grenno.dao.generic.jdbc.dao;

import main.java.br.com.grenno.dao.generic.jdbc.ConnectionFactory;
import main.java.br.com.grenno.dao.generic.jdbc.dao.interfaces.IGenericDAO;
import main.java.br.com.grenno.domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements IGenericDAO<Customer> {
    @Override
    public Integer register(Customer customer) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            // set sql command
            String sql = "INSERT INTO customer (id, name, code) VALUES (nextval('sq_customer'), ?, ?)";
            statement = connection.prepareStatement(sql);
            // replace ? with string:
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCode());
            return statement.executeUpdate();
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    @Override
    public Integer update(Customer customer) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE customer SET NAME = ?, CODE = ? WHERE ID = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCode());
            statement.setLong(3, customer.getId());
            return statement.executeUpdate();
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    @Override
    public Customer getByCode(String code) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM customer WHERE CODE = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, code);
            resultSet = statement.executeQuery();
            // pass by each line in result
            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("ID"));
                customer.setCode(resultSet.getString("CODE"));
                customer.setName(resultSet.getString("NAME"));
            }
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return customer;
    }

    @Override
    public List<Customer> list() throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM customer";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("ID"));
                customer.setCode(resultSet.getString("CODE"));
                customer.setName(resultSet.getString("NAME"));
                customerList.add(customer);
            }
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return customerList;
    }

    @Override
    public Integer delete(Customer customer) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM customer WHERE CODE = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCode());
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
