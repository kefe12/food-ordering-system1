package menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserTableBean {

    public List<UserTable> getUserList() {
        List<UserTable> list = new ArrayList<UserTable>();
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from customer");
            while (rs.next()) {
                UserTable usr = new UserTable();
                usr.setId(rs.getString("cust_id"));
                usr.setName(rs.getString("cust_name"));
                usr.setEmail(rs.getString("cust_email"));
               usr.setPassword(rs.getString("cust_password"));
                usr.setAdress(rs.getString("cust_adress"));
                usr.setContact(rs.getString("cust_contact_no"));

                list.add(usr);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }
}
