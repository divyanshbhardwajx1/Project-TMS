
package com.jdbc.demo;

import java.sql.Timestamp;

import com.mysql.cj.callback.UsernameCallback;
import java.util.Objects;

public class User {

   private int user_id;

   private String username;

   private String email;

   private String password;

   private Timestamp created_at;

   private Timestamp updated_at;

    public User(int user_id, String username, String email, String password, Timestamp created_at, Timestamp updated_at) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
 
    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
     public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() !=o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id && Objects.equals(username,user.username) && Objects.equals(email,user.email) && Objects.equals(password,user.password);
     }

     @Override
     public int hashCode(){
        return Objects.hash(user_id,username,email,password,created_at,updated_at);
     }

    @Override
    public String toString() {
        return "{" +
            " user_id='" + getUser_id() + "'" +
            ", username='" + getUsername() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", created_at='" + getCreated_at() + "'" +
            ", updated_at='" + getUpdated_at() + "'" +
            "}";
    }

}
