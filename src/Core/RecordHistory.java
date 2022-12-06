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

/**
 *
 * @author Muhammad Adil FAYYAZ
 */
public class RecordHistory {
    private int UserID;
    private int MediaID;
    private String BorrowDate;
    
    public RecordHistory(int UID,int MID,String BorrowDate){
        this.UserID=UID;
        this.MediaID=MID;
        this.BorrowDate=BorrowDate;
        UpdateDB();
    }
    public void UpdateDB(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql ="INSERT INTO MediaHistory(userID,mediaID,BorrowDate) VALUES(?,?,?)";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,this.UserID);
            stmt.setInt(2,this.MediaID);
            stmt.setString(3,this.BorrowDate);
            stmt.executeUpdate();
            stmt.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
}
