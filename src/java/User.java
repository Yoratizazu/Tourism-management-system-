

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class User {
   private String FIRSTNAME;
   private String myuser;

    public String getMyuser() {
        return myuser;
    }
  public void setMyuser(String myuser) {
        this.myuser = myuser;
    }
    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }
     private String PASSWORD;

     public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
   public String ValidPassword(String FIRSTNAME,String PASSWORD)
    {
        myuser=FIRSTNAME;
    
          DBConnection dbcon=new DBConnection();
          Connection con;
       
          try {
              con = dbcon.connMethod();
            
              PreparedStatement ps=con.prepareStatement("select FIRSTNAME,PASSWORD from PACKAGETABLE2 where FIRSTNAME=? and PASSWORD=?");
               System.out.println( getFIRSTNAME());
            ps.setString(1, FIRSTNAME);
            ps.setString(2, PASSWORD);
            ResultSet rs=ps.executeQuery();
           
        if(rs.next()){
          
              return "packageholiday"; 
            
        } else return "login page";
           
          } catch (ClassNotFoundException | SQLException ex) {
              System.out.println("error");
          }
     
      return "packageholiday";
           }
}


