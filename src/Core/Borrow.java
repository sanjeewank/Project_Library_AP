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
import java.time.LocalDate;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class Borrow{
    private Person Person;
    private Media Media;
    private LocalDate BorrowDate;
    private LocalDate ReturnDate;
   
   public Borrow(Person p,Media m){
       this.Person=p;
       this.Media=m;
       this.BorrowDate=LocalDate.now();
       this.ReturnDate=this.getBorrowDate().plusWeeks(4);
    } 
    public void UpdateDB(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="INSERT INTO Borrow(userID,MediaID,BorrowDate,ReturnDate,Extended) VALUES(?,?,?,?,?)";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,this.getPerson().getUserID());
            stmt.setInt(2,Integer.parseInt(this.getMedia().getMediaID()));
            stmt.setString(3,this.getBorrowDate().toString());
            stmt.setString(4,this.getReturnDate().toString());
            stmt.setInt(5,0);
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
        try{
           int NewCopyCount=this.getMedia().getMediaCopies()-1;
           Connection DBLink = DBConnect.connect();
           String sql ="UPDATE Media set Copies=? WHERE ID=?";
           PreparedStatement stmt  = DBLink.prepareStatement(sql);
           stmt.setInt(1,NewCopyCount);
           stmt.setString(2,this.getMedia().getMediaID());
           stmt.executeUpdate();
           stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public boolean isFullList(){
        int MediaCount=0;
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="SELECT count(userID) as 'count' from Borrow where userID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,Person.getUserID());
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                MediaCount=rs.getInt("count");
            }
            if(MediaCount>2){
                return false;
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
        return true;
    }
    public boolean isAlreadyBorrowed(){
        try{
            String Tresult=null;
            Connection DBLink = DBConnect.connect();
            String sql ="SELECT userID from Borrow where userID=? and mediaID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,Person.getUserID());
            stmt.setInt(2,Integer.parseInt(Media.getMediaID()));
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Tresult=rs.getString("userID");
            }
            if(Tresult==null){
                return false;
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
        return true;
    }
    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person Person) {
        this.Person = Person;
    }

    public Media getMedia() {
        return Media;
    }

    public void setMedia(Media Media) {
        this.Media = Media;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate BorrowDate) {
        this.BorrowDate = BorrowDate;
    }

    public LocalDate getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(LocalDate ReturnDate) {
        this.ReturnDate = ReturnDate;
    }
    
}
