/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmcsdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ltmcsdl.URL.dbUrl;
import static ltmcsdl.URL.url;

/**
 *
 * @author Admin
 */
public class classDB implements URL {
    private int id;
    private String class_name;

    public classDB() {
    }

    public classDB(int id) {
        this.id = id;
    }

    public classDB(int id, String class_name) {
        this.id = id;
        this.class_name = class_name;
    }

    public classDB(String class_name) {
        this.class_name = class_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    
    public boolean createClass(){
        try {
            Class.forName(url);
            Connection con = DriverManager.getConnection(dbUrl);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Class(class_name) VALUES(?)");
            stmt.setString(1,this.class_name);
            int rs = stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
          } catch (Exception ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean DeleteClass(int id){
        try {
            Class.forName(url);
            Connection con = DriverManager.getConnection(dbUrl);
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Class WHERE id = ?");
            stmt.setInt(1,id);
            int rs = stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
          } catch (Exception ex) {
            Logger.getLogger(classDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
