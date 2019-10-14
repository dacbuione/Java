/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmcsdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ltmcsdl.URL.dbUrl;
import static ltmcsdl.URL.url;

/**
 *
 * @author Admin
 */
public class DayOff implements URL {
    private int id_student;
    private Date dayoff;

    public DayOff() {
    }

    public DayOff(int id_student, Date dayoff) {
        this.id_student = id_student;
        this.dayoff = dayoff;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public Date getDayoff() {
        return dayoff;
    }

    public void setDayoff(Date dayoff) {
        this.dayoff = dayoff;
    }
    
    public boolean DangKy(){
        try {
            Class.forName(url);
            Connection con = DriverManager.getConnection(dbUrl);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Dayoff(id_student,dayoff) VALUES(?,?)");
            stmt.setInt(1, this.id_student);
            stmt.setDate(2, (java.sql.Date) this.dayoff);
            int rs = stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
          } catch (Exception ex) {
            Logger.getLogger(DayOff.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
