
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Buypkg {
    private String name;
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
public void buypakg() throws ClassNotFoundException, SQLException{
     try {
           DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into BUYPACKAGE(NAME) values(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
           
            ps.executeUpdate();
     }
     catch(ClassNotFoundException | SQLException e){
       System.out.println("some problem is found");
     }
      
     }
} 


     
