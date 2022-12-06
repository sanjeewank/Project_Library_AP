/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Muhammad Adil FAYYAZ
 */
public class Person {
    private int userID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    
    public Person(String ID){
        try{
            Connection DBLink = DBConnect.connect();
            String sql = "Select * from user where userID="+ID+";";
            Statement stmt  = DBLink.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.userID=rs.getInt("userID");
                this.FirstName=rs.getString("Fname");
                this.LastName=rs.getString("Lname");
                this.Email=rs.getString("email");
                this.Password=rs.getString("password");
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    } 

    @Override
    public String toString() {
        return String.valueOf(userID);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }
    
}
