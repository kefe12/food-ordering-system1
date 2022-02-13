package menu;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class loginval {
    
    public static boolean validate(String name, String pass) {
        boolean status = false;
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java2021", "1616");
            //CallableStatement callobj=con.prepareCall("{call SsELECTUSe(?)}");
           DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select * from customer where cust_name=? and cust_password=?");
          //  PreparedStatement ps = con.prepareStatement("select * from customer where cust_email=? and cust_password=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
