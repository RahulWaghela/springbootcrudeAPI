package com.example.demo.respository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Usermodel;
import com.example.demo.utils.Dbconnection;

import org.springframework.stereotype.Repository;

@Repository

public class Userrepository {

    // Read user Get request
    public List<Usermodel> getUserData() throws ClassNotFoundException {
        String readQuery = "SELECT * FROM employees";

        List<Usermodel> list = new ArrayList<>();
        try {
            Connection connection = Dbconnection.getConnection();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(readQuery);
            while (rs.next()) {
                String name = rs.getString("name");
                String department = rs.getString("department");
                String email = rs.getString("email");
                Long phone = rs.getLong("phone");
                Long salary = rs.getLong("salary");

                Usermodel user = new Usermodel(name, department, email, phone, salary);
                list.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Create New user post request
    public void createNewUser(Usermodel usermodel) {
        try {
            String sql = "INSERT INTO employees (name, department, email, phone, salary) VALUES (?, ?, ?, ?, ?)";
            Connection connection = Dbconnection.getConnection();
            connection.setAutoCommit(true);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usermodel.getName());
            preparedStatement.setString(2, usermodel.getDepartment());
            preparedStatement.setString(3, usermodel.getEmail());
            preparedStatement.setLong(4, usermodel.getPhone());
            preparedStatement.setLong(5, usermodel.getSalary());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User created successfully.");
            } else {
                System.out.println("User creation failed.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Delete user Delete requesrt
    public void deleteUser(String id) throws ClassNotFoundException {
        String deleteQuery = "DELETE FROM employees WHERE id = ?";
        try {
            Connection connection = Dbconnection.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

            preparedStatement.setLong(1, Long.parseLong(id));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No user found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("Error while deleting user: " + e.getMessage());
        }
    }
}
