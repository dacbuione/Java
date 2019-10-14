/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmcsdl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class trangchu {

    public static void main(String a[]) {
        Scanner nhap = new Scanner(System.in);
        student st = new student();
        student stx = new student();
        classDB cl = new classDB();
        classDB clx = new classDB();
        Student_Class sc = new Student_Class();
        DayOff df = new DayOff();
        String name, class_name;
        int age, ID_SV, ID_CLASS;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        int chon = 0;
        do {

            System.out.println("1.Them Student:");
            System.out.println("2.Them Class");
            System.out.println("3.DK 1 SV vao 1 Class");
            System.out.println("4.DK ngay nghi");
            System.out.println("5.Tim kiem SV");
            System.out.println("6.Tim kiem Class");
            System.out.println("7.Tim kiem thong tin ngay nghi");
            System.out.println("8.Xoa 1 SV");
            System.out.println("9.Xoa 1 Class");
            System.out.println("10.Exit");
            System.out.print("Chon: ");
            chon = nhap.nextInt();
            System.out.println("------------------------------------");
            switch (chon) {
                case 1:
                    System.out.println("Nhap name: ");
                    name = nhap.nextLine();
                    nhap.next();
                    System.out.println("Nhap tuoi: ");
                    age = Integer.parseInt(nhap.next());
                    st = new student(age, name);
                    if (st.createStudent() == true) {
                        System.out.println("Da them thanh cong");
                    } else {
                        System.out.println("That bai");
                    }
                    ;
                    break;
                case 2:
                    System.out.println("Nhap class_name: ");
                    class_name = nhap.next();
                    nhap.nextLine();
                    System.out.println(class_name);
                    cl = new classDB(class_name);
                    if (cl.createClass() == true) {
                        System.out.println("Da them thanh cong");
                    } else {
                        System.out.println("That bai");
                    }
                    ;
                    break;
                case 3:
                    System.out.println("Nhap ID_SV:");
                    ID_SV = Integer.parseInt(nhap.next());
                    System.out.println("Nhap ID_Class:");
                    ID_CLASS = Integer.parseInt(nhap.next());
                    sc = new Student_Class(ID_SV, ID_CLASS);
                    if (sc.DangKy() == true) {
                        System.out.println("Da them thanh cong");
                    } else {
                        System.out.println("That bai");
                    }
                    ;
                    break;
                case 4:
                    System.out.println("Nhap ID_SV:");
                    ID_SV = Integer.parseInt(nhap.next());
                    df = new DayOff(ID_SV, date);
                    if (df.DangKy() == true) {
                        System.out.println("Da them thanh cong");
                    } else {
                        System.out.println("That bai");
                    }
                    break;
                case 5: 
                    
                    ;
                    break;
                case 6: 
                    ;
                    break;
                case 7: 
                    ;
                    break;
                case 8: 
                    System.out.println("Nhap ID SV: ");
                    ID_SV = Integer.parseInt(nhap.next());
                    stx = new student(ID_SV);
                    if (stx.DeleteStudent(ID_SV) == true) {
                        System.out.println("Da xoa thanh cong");
                    } else {
                        System.out.println("That bai");
                    }
                    break;
                case 9: 
                    System.out.println("Nhap ID CLASS: ");
                    ID_CLASS = Integer.parseInt(nhap.next());
                    clx = new classDB(ID_CLASS);
                    if (clx.DeleteClass(ID_CLASS) == true) {
                        System.out.println("Da xoa thanh cong");
                    } else {
                        System.out.println("That bai");
                    }
                    ;
                    break;
            }
        } while (chon < 10);
    }
}
