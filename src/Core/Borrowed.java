/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import DB.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class Borrowed {
    private Person Person;
    private Media Media;
    private LocalDate BorrowedDate;
    private LocalDate ReturnDate;
    private boolean isExtended;
    
    public Borrowed(Person user,Media media){
        this.Person=user;
        this.Media=media;
        SearchBorrowed();
    }
    public void SearchBorrowed(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="SELECT BorrowDate,ReturnDate,Extended from Borrow where userID=? and mediaID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,Person.getUserID());
            stmt.setString(2,Media.getMediaID());
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                BorrowedDate = LocalDate.parse(rs.getString("BorrowDate"), formatter);
                ReturnDate= LocalDate.parse(rs.getString("ReturnDate"), formatter);
                isExtended = rs.getInt("Extended")==1;
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public void ReturnMedia(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="DELETE FROM Borrow where userID=? and mediaID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,Person.getUserID());
            stmt.setString(2,Media.getMediaID());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="UPDATE Media SET Copies=Copies+1 WHERE ID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setString(1,Media.getMediaID());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
        new RecordHistory(Person.getUserID(),Integer.parseInt(Media.getMediaID()),BorrowedDate.toString());
    }
    public void ExtendTime(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="UPDATE Borrow SET extended=?,ReturnDate=? WHERE userID=? and mediaID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,1);
            stmt.setString(2,ReturnDate.plusWeeks(2).toString());
            stmt.setInt(3,Person.getUserID());
            stmt.setString(4,Media.getMediaID());
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }

    public boolean isExtended() {
        return isExtended;
    }
    
    public LocalDate getBorrowedDate() {
        return BorrowedDate;
    }

    public LocalDate getReturnDate() {
        return ReturnDate;
    }
        
    
}
