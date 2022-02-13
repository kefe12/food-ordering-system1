/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;


    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="obj")
public class registerClass {
    private String name,adress,email,pass,conpass,customerid,usertype;
    private int contact;

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConpass() {
        return conpass;
    }

    public void setConpass(String conpass) {
        this.conpass = conpass;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
    
    
    public String addCat() throws SQLException, ClassNotFoundException{
    
        System.out.println("category name:"+customerid); 
         System.out.println("category name:"+name);
         System.out.println("category name:"+adress);
         System.out.println("category name:"+email);
         System.out.println("category name:"+pass);
         System.out.println("category name:"+conpass);
           System.out.println("category name:"+contact);
        // Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/kefe4","root","root");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cc?zeroDateTimeBehavior=CONVERT_TO_NULL ","root","");
         Statement ps=con.createStatement();
        // ps.executeUpdate("insert into CATEGORY_DETAILS values('"+cname+"','"+s1_no+"') ");
        ps.executeUpdate("insert into customer values('"+customerid+"','"+name+"','"+email+"','"+pass+"','"+adress+"','"+contact+"','"+usertype+"') ");
        con.close();
         return "loginpage";
    
    }
    
}


