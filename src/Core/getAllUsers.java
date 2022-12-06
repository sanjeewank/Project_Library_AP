/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class getAllUsers {
    private ArrayList<Person> UserList;
    
    public getAllUsers(){
        UserList=new ArrayList();
        getAll();
    }
    public void getAll(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql = "select userID from user";
            Statement stmt  = DBLink.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                UserList.add(new Person(rs.getString("userID")));
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }

    public ArrayList<Person> getUserList() {
        return UserList;
    }
    
}
