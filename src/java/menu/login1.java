package menu;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


//import com.journaldev.jsf.util.SessionUtils;
@ManagedBean()
@SessionScoped
@RequestScoped
public class login1 implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() throws SQLException, ClassNotFoundException {
        boolean valid = loginval.validate(user, pwd);
        if (valid) {
              DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select USERTYPE from customer where cust_name=?");
            ps.setString(1, user);       
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userType =rs.getString(1);
            //HttpSession session = Session.getSession();
            //session.setAttribute("username", user);
            if ("Admin".equals(userType)) {
                return "Home";
            } else {
                return "AdminHome";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "loginpage";
        }
    }

    //logout event, invalidate session
    public String logout() {
       // HttpSession session = Session.getSession();
        //session.invalidate();
        return "loginpage";
    }
}
