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
 * @author Sanjeewa Kulathunga 
 */
public class Login{
    private String UserEmail;
    private String UserPassword;
    
    
    public Login(String Email,String Password){
        this.UserEmail=Email;
        this.UserPassword=Password;
    }
    public int getValidUser(){
        int UserID=-1;
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="Select userID from user where email=? and password=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setString(1,this.getUserEmail());
            stmt.setString(2,this.getUserPassword());
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                UserID=rs.getInt("userID");
            }
            if(UserID!=-1){
                return UserID;
            }
            stmt.close();
            rs.close();
           System.out.print(UserID);
        }catch(SQLException e){}
        return 0;
    }
    public boolean isValidEmail(){
        int UserID=-1;
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="Select userID from user where email=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setString(1,this.getUserEmail());
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                UserID=rs.getInt("userID");
            }
            if(UserID!=-1){
                return true;
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){}
       return false;
    }
    public boolean isValidPassword(){
        int UserID=-1;
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="Select userID from user where password=? and Email=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setString(1,this.getUserPassword());
            stmt.setString(2,this.getUserEmail());
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                UserID=rs.getInt("userID");
            }
            if(UserID!=-1){
                return true;
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){}
       return false;
    }
    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }
    
    
}
