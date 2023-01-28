
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class Updatebean {
    private String name;
    private String days;
    private String place;
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public void updatedata() throws ClassNotFoundException, SQLException{
     try {
            
           
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
           // String sql = "UPDATE PACKAGETABLE1 SET DAYS=?,PLACE=?, PRICE=?  WHERE NAME=?";
            PreparedStatement ps = con.prepareStatement("UPDATE PACKAGETABLE1 SET DAYS=?,PLACE=?, PRICE=?  WHERE NAME=?");
          
             ps.setString(1, days);
              ps.setString(2, place);
               ps.setString(3, price);
                 ps.setString(4, name);
              ps.executeUpdate();
     }
     catch(ClassNotFoundException | SQLException e){
       System.out.println("some problem is found");
     }
      
  }

}
