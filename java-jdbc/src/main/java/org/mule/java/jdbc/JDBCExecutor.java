package org.mule.java.jdbc;

import org.mule.java.jdbc.util.CustomerDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCExecutor
{
    public static void main( String[] args )
    {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager(
                "localhost",
                "hplussport",
                "postgres",
                "password");

        try{
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("Leonel");
            customer.setLastName("Messi");
            customer.setEmail("leomessi@gmail.com");
            customer.setPhone("132456798");
            customer.setAddress("Alvear 575");
            customer.setCity("Miameee");
            customer.setState("VA");
            customer.setZipCode("22121");

            customerDAO.create(customer);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
