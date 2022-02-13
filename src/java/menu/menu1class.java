package menu;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name="apobj")
public class menu1class {
   private String id,foodname,foodid;
private int qty;

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
  
   
    public String addCat() throws SQLException, ClassNotFoundException{
        // Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/kefe4","root","root");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cc?zeroDateTimeBehavior=CONVERT_TO_NULL ","root","");
         Statement ps=con.createStatement();
        // ps.executeUpdate("insert into CATEGORY_DETAILS values('"+cname+"','"+s1_no+"') ");
        ps.executeUpdate("insert into cart values('"+id+"','"+foodname+"','"+qty+"')" );
        con.close();
         return "succed";
    
    }
   
    public String deletemenu(String var) throws SQLException, ClassNotFoundException{
        // Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/kefe4","root","root");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cc?zeroDateTimeBehavior=CONVERT_TO_NULL ","root","");
         Statement ps=con.createStatement();
        // ps.executeUpdate("insert into CATEGORY_DETAILS values('"+cname+"','"+s1_no+"') ");
        ps.executeUpdate( "delete from cart where customer id=?");
        con.close();
         return "succed";
    
    }
     
}

  /* private  String id,name,type,category,description,price;

    private boolean edit;

    public menu1class(String id, String name, String type, String category, String description, String price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
        this.price = price;
        edit = edit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
  
}*/
