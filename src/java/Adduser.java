
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="adduser")
@RequestScoped
public class Adduser {
   private String FIRSTNAME; 
   private String LASTNAME; 
   private String EMAIL ; 
   private String CITY; 
private String MOBILE; 
private String NAME; 
private String PASSWORD; 

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getMOBILE() {
        return MOBILE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }
   
    public void PackageData3() throws ClassNotFoundException, SQLException{
     try {
            
           
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into PACKAGETABLE2(FIRSTNAME,LASTNAME,EMAIL,CITY,MOBILE,NAME,PASSWORD) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, FIRSTNAME);
            ps.setString(2, LASTNAME);
            ps.setString(3, EMAIL);
            ps.setString(4, CITY);
            ps.setString(5, MOBILE);
             ps.setString(6, NAME);
               ps.setString(7, PASSWORD);
            
            ps.executeUpdate();
     }
     catch(ClassNotFoundException | SQLException e){
       System.out.println("some problem is found");
     }
      
  }
}
