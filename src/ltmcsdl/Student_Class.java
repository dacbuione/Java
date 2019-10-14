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
public class Student_Class implements URL{
    private int ID_SV,ID_CLASS;

    public Student_Class() {
    }

    public Student_Class(int ID_SV, int ID_CLASS) {
        this.ID_SV = ID_SV;
        this.ID_CLASS = ID_CLASS;
    }

    public int getID_SV() {
        return ID_SV;
    }

    public void setID_SV(int ID_SV) {
        this.ID_SV = ID_SV;
    }

    public int getID_CLASS() {
        return ID_CLASS;
    }

    public void setID_CLASS(int ID_CLASS) {
        this.ID_CLASS = ID_CLASS;
    }
    
    
    public boolean DangKy(){
        try {
            Class.forName(url);
            Connection con = DriverManager.getConnection(dbUrl);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Student_Class(id_student,id_class) VALUES(?,?)");
            stmt.setInt(1, this.ID_SV);
            stmt.setInt(2, this.ID_CLASS);
            int rs = stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
          } catch (Exception ex) {
            Logger.getLogger(Student_Class.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
