/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmcsdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ltmcsdl.URL.dbUrl;
import static ltmcsdl.URL.url;

/**
 *
 * @author Admin
 */
public class student implements URL {
    private int id,age;
    private String name;

    public student() {
    }

    public student(int id) {
        this.id = id;
    }

    public student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public boolean createStudent(){
        try {
            Class.forName(url);
            Connection con = DriverManager.getConnection(dbUrl);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Student(name,age) VALUES(?,?)");
            stmt.setString(1,this.name);
            stmt.setInt(2,this.age);
            int rs = stmt.executeUpdate();
            
            stmt.close();
            con.close();
            return true;
          } catch (Exception ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean DeleteStudent(int id){
        try {
            Class.forName(url);
            Connection con = DriverManager.getConnection(dbUrl);
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Student WHERE id = ?");
            stmt.setInt(1,id);
            int rs = stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
          } catch (Exception ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
