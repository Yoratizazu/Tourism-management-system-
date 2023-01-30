import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Delete {
private String name;

    public String getName() {
        return name;
    }
             
    public void setName(String name) {
        this.name = name;
    }
public void Deletedata() throws ClassNotFoundException, SQLException{
     try {
            
           
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "DELETE FROM PACKAGETABLE1 WHERE NAME =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
              ps.executeUpdate();
     }
     catch(ClassNotFoundException | SQLException e){
       System.out.println("some problem is found");
     }
      
  }

   }