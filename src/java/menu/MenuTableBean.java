package menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "menubean")
@SessionScoped
public class MenuTableBean {

    public List<MenuTable> getUserList() {
        List<MenuTable> list = new ArrayList<MenuTable>();
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from menu");
            while (rs.next()) {
                    MenuTable usr = new MenuTable();
                usr.setId(rs.getString("food id"));
                 usr.setName(rs.getString("food Name"));
              usr.setType(rs.getString("food type"));
             usr.setCat(rs.getString("food category"));
              usr.setDesc(rs.getString("food description"));
             usr.setPrice(rs.getString("food price"));
                list.add(usr);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }
}
