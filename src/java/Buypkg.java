
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

@ManagedBean



public class Buypkg {
    private String name;
    private String days;
    private String place;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
     public void buypakg() throws ClassNotFoundException, SQLException{
     try {
            
           
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into BUYPACKAGETABLE(NAME,DAYS,PLACE) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, days);
            ps.setString(3, place);
         
            ps.executeUpdate();
     }
     catch(ClassNotFoundException | SQLException e){
       System.out.println("some problem is found");
     }
      
     }
} 


     
