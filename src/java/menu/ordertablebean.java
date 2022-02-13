package menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "orderbean")
@SessionScoped
public class ordertablebean {

    static String deletemenu(int foodid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ordertable> getUserList() {
        List<ordertable> list = new ArrayList<ordertable>();
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from ordertable ");
            while (rs.next()) {
                ordertable usr = new ordertable();
                usr.setFoodid(rs.getString("food id"));
                 usr.setName(rs.getString("foodName"));
              usr.setCust_name(rs.getString("cust_name"));
             usr.setId(rs.getString("customer id"));
                list.add(usr);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }
}
