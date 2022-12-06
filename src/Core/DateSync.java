/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Muhammad Adil FAYYAZ
 */
public class DateSync {
    private LocalDate Today;
    
    public DateSync(){
        Today=LocalDate.now();
        setDate();
    }
    //second constructor for development purposes
    public DateSync(LocalDate date){
        Today=date;
        setDate();
    }
    public void setDate(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="UPDATE today SET today=? WHERE Datekey=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setString(1,Today.toString());
            stmt.setString(2,"TodayKey");
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }

    public LocalDate getToday() {
        return Today;
    }

    public void setToday(LocalDate Today) {
        this.Today = Today;
    }
    
}
