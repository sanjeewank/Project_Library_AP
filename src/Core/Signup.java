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
import java.util.regex.Pattern;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class Signup {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    
    public Signup(String Fname,String Lname,String email,String password){
        this.FirstName=Fname;
        this.LastName=Lname;
        this.Email=email;
        this.Password=password;
    }
    public void SignupUser(){
        int MaxUser=-1;
        try{
            Connection DBLink = DBConnect.connect();
            String sql = "Select userID from user group by UserID having MAX(userID)";
            Statement stmt  = DBLink.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                MaxUser=rs.getInt("userID");
            }
            MaxUser+=1;
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="INSERT INTO user(userID,Fname,Lname,email,password) VALUES(?,?,?,?,?)";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,MaxUser);
            stmt.setString(2,this.getFirstName());
            stmt.setString(3,this.getLastName());
            stmt.setString(4,this.getEmail());
            stmt.setString(5,this.getPassword());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public boolean isEmailExsits(){
        int UserID=-1;
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="Select userID from user where email=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setString(1,this.getEmail());
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
    public boolean isValidEmail() {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
        "[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
        "A-Z]{2,7}$";

    Pattern pat = Pattern.compile(emailRegex);
    if (this.getEmail()== null)
        return false;
    return pat.matcher(this.getEmail()).matches();
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
    
}
