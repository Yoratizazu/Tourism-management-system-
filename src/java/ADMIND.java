import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class ADMIND {

    public static boolean validate(String USERNAME, String PASSWORD) {
        boolean status = false;
       try{
           DBConnection dbcon=new DBConnection();
           Connection con=dbcon.connMethod();
           PreparedStatement ps=con.prepareStatement("select * from USERTABLE where USERNAME=? and PASSWORD=?");
                   ps.setString(1,USERNAME);
                   ps.setString(2, PASSWORD);
                   ResultSet rs= ps.executeQuery();
                   status= rs.next();
                     
           }catch(Exception e)
           {
               System.out.println(e);
           }
           return status;
   }
       
   }

