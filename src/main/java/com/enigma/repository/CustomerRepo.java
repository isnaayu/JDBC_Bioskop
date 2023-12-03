package com.enigma.repository;

import com.enigma.configuration.DbConnector;
import com.enigma.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    DbConnector dbConnector = new DbConnector();
    private Connection conn = dbConnector.startConnect();

    List<Customer> CustomerList = new ArrayList<>();
    public List<Customer> getAll(){
        List<Customer> data = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM m_customer");
            ResultSet result = pr.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String birth_date = result.getString("birth_date");
                data.add(new Customer(id, name, birth_date));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public void save(Customer customer){
        try {
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("INSERT INTO m_customer (name, birth_date) VALUES (?,?)");
            pr.setString(1,customer.getName());
            pr.setDate(2, Date.valueOf(customer.getBirth_date()));
            pr.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Customer update(Integer id){
        return null;
    }

    public Customer delete(Integer id){
        return null;
    }

    public Customer getByID(Integer id){
        Customer customer = null;
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM m_customer WHERE id=?");
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();
            while (result.next()){
                id = result.getInt("id");
                String name = result.getString("name");
                String birth_date = result.getString("birth_date");
                customer = new Customer(id, name, birth_date);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customer;
    }
}
