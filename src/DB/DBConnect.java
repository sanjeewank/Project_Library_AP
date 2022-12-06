/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class DBConnect {
    public static Connection connect() {
        Connection DBLink = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:library.db";
            
            // create a connection to the database
            DBLink = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return DBLink;
    }
}
