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
            Customer customer = customerDAO.findById(1098);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
                    customer.getEmail());
            customer.setEmail("messiiiiii@wh.gov");
            customer.setFirstName("Leonel Andres");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
                    customer.getEmail());
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
