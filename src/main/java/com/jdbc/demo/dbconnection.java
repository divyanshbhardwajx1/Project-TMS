
package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {

   private static final String URL = "jdbc:mysql://localhost:3306/user_management" ;

   private static final String USER = "root";

   private static final String PASSWORD = "SQLroot@123";
 
   public static void main(String[] args){

     /*  Connection connection = null ;
      try {
         connection = DriverManager.getConnection(URL,USER,PASSWORD);
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management?user=root&password=SQLroot@123");
         System.out.println("Connection Established between Java and DB successfully");  
      } catch (SQLException e) {
          System.out.println("Error while connecting to db" + e.getMessage());

      }*/

      UserDao userDao = new UserDaoImpl();

      User user = new User("Peter", "peter@gmail.com", "Peter@123");
      userDao.addUser(user);
      System.out.println("New user added");

      User savedUser = userDao.getUserById(2);
      System.out.println(user);

    }

}
