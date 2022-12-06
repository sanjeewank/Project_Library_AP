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

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class Media {
    private String MediaID;
    private String MediaName;
    private String MediaAuthor;
    private int MediaCopies;
    private String MediaDesciption;
    
    public Media(String ID){
        try{
            Connection DBLink = DBConnect.connect();
            String sql = "Select * from media where ID="+ID+";";
            Statement stmt  = DBLink.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.MediaID=rs.getString("ID");
                this.MediaName=rs.getString("Name");
                this.MediaAuthor=rs.getString("Author");
                this.MediaCopies=rs.getInt("Copies");
                this.MediaDesciption=rs.getString("Description");
            }
            stmt.close();
            rs.close();
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    public boolean isAvailable(){
        return this.getMediaCopies()>0;
    }
    public String getMediaID() {
        return MediaID;
    }

    public void setMediaID(String MediaID) {
        this.MediaID = MediaID;
    }

    public String getMediaName() {
        return MediaName;
    }

    public void setMediaName(String MediaName) {
        this.MediaName = MediaName;
    }

    public String getMediaAuthor() {
        return MediaAuthor;
    }

    public void setMediaAuthor(String MediaAuthor) {
        this.MediaAuthor = MediaAuthor;
    }

    public int getMediaCopies() {
        return MediaCopies;
    }

    public void setMediaCopies(int MediaCopies) {
        this.MediaCopies = MediaCopies;
    }

    public String getMediaDesciption() {
        return MediaDesciption;
    }

    public void setMediaDesciption(String MediaDesciption) {
        this.MediaDesciption = MediaDesciption;
    }
    
}
