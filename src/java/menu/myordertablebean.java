package menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "myorderbean")
@SessionScoped
public class myordertablebean {

    public List<myordertable> getUserList() {
        List<myordertable> list = new ArrayList<myordertable>();
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from cart   ");
            while (rs.next()) {
                myordertable usr = new myordertable();
              usr.setCust_id(rs.getString("customer id"));
                usr.setFoodname(rs.getString("foodName"));
                usr.setQunty(rs.getInt("quantity"));
                
                list.add(usr);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }
}
