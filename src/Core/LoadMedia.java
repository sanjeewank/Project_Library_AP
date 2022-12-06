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
import java.util.ArrayList;

/**
 *
 * @author Muhammad Adil FAYYAZ
 */
public class LoadMedia {
    private ArrayList<Media> MediaList;
    
    public LoadMedia(){
        MediaList=new ArrayList();
    }
    public void LoadRandom(){
        try{
            Connection DBLink = DBConnect.connect();
            String sql = "Select id from media order by random() limit 5;";
            Statement stmt  = DBLink.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                MediaList.add(new Media(rs.getString("id")));
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public void LoadUserList(Person User){
        try{
            Connection DBLink = DBConnect.connect();
            String sql = "SELECT m.ID FROM Media m,Borrow b where m.id=b.mediaID and B.userID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,User.getUserID());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                MediaList.add(new Media(rs.getString("id")));
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    
    public void LoadUserHistoryList(Person User){
        try{
            Connection DBLink = DBConnect.connect();
            String sql = "select mediaID from MediaHistory where userID=?";
            PreparedStatement stmt  = DBLink.prepareStatement(sql);
            stmt.setInt(1,User.getUserID());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                MediaList.add(new Media(rs.getString("mediaID")));
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public void LoadInnerCircle(Media M1,Media M2){
        MediaList.add(new Media(M1.getMediaID()));
        MediaList.add(new Media(M2.getMediaID()));
    }
    public void LoadDiscovery(Media M1,Media M2,Media M3){
        MediaList.add(new Media(M1.getMediaID()));
        MediaList.add(new Media(M2.getMediaID()));
        MediaList.add(new Media(M3.getMediaID()));
    }
    public ArrayList<Media> getMediaList() {
        return MediaList;
    }
    
}
