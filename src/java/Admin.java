
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean  
@SessionScoped
public class Admin  {
     private String password;
  
    private String username;
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String validatePassword() throws SQLException, ClassNotFoundException {
       
   boolean valid =validate(username,password);
        if (valid) {
             
              DBConnection dbcon = new DBConnection();
            Connection con=dbcon.connMethod() ;
           
            PreparedStatement ps = con.prepareStatement("select USERTYPE from USERTABLE where USERNAME=? " );
            ps.setString(1, username);       
                  
            ResultSet rs = ps.executeQuery();
           if(rs.next()) {
               
               System.out.println("ther is errorr");
            String USERTYPE =rs.getString(1);
           System.out.println(USERTYPE);
            if ("Admin".equals(USERTYPE)) {
                return "wellcomepage";
            } 
            else{
                System.out.println("Erooor");
            }
            }
        } 
    return "admin page";
    
}  public static boolean validate(String username, String password) {
        boolean status = false;
       try{
           DBConnection dbcon=new DBConnection();
           Connection con=dbcon.connMethod();
           PreparedStatement ps=con.prepareStatement("select * from USERTABLE where USERNAME=? and PASSWORD=?");
                   ps.setString(1,username);
                   ps.setString(2, password);
                   ResultSet rs= ps.executeQuery();
                   status= rs.next();
                     
           }catch(Exception e)
           {
               System.out.println(e);
           }
           return status;
   }

}
