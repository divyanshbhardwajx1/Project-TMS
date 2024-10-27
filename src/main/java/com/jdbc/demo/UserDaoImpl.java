
package com.jdbc.demo;

import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDaoImpl implements UserDao{

   private static final String URL = "jdbc:mysql://localhost:3306/user_management" ;

   private static final String USER = "root";

   private static final String PASSWORD = "SQLroot@123";
  

    @Override
    public void addUser(User user) {
        String query = "insert into user(username,password,email)values(?,?,?)";
        try(
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query))
        
        {
          preparedStatement.setString(1, user.getUsername());
          preparedStatement.setString(2, user.getEmail());
          preparedStatement.setString(3, user.getPassword());
          preparedStatement.executeUpdate();

        }catch (SQLException exception){
            System.out.println("Error while adding user " + exception.getMessage());
        }
    }

    @Override
    public User getUserById(int user_id) {
        String query = "select * from user where user_id = ?" ;
        try(
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query))
        
        {
          preparedStatement.setInt(1,user_id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
             return new User(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getTimestamp(5),
                resultSet.getTimestamp(6)
             );    
           }
        }catch (SQLException exception){
            System.out.println("Error while adding user " + exception.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
         return null;
    }

    @Override
    public void updateUser(User user) {
        
    }

    @Override
    public void deleteUser(int id) {
        
    }


}