
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;


public class Userd {
   private String FIRSTNAME; 
      private String PASSWORD; 

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
   
@ManagedBean


public class Userinserter {
 public String UserName;
 public String Password;

 
 
 
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    

  public String Userform ()
  {
      try{
       DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into LOGINUSER(FIRSTNAME,PASSWORD) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, FIRSTNAME);
            ps.setString(2, PASSWORD);
           
            ps.executeUpdate();
      }
      catch(SQLException | ClassNotFoundException e)
      {
      
      System.out.print(e);
      }
       return "packageholiday";
  }
   
}
}
