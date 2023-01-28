
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="addPackageBean")
@RequestScoped
public class AddPackageBean {
   private String name;
   private String place;
   private String days;
   private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
  public void PackageData() throws ClassNotFoundException, SQLException{
     try {
            
           
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into PACKAGETABLE1(NAME,DAYS,PLACE,PRICE) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, days);
            ps.setString(3, place);
            ps.setString(4, price);
            ps.executeUpdate();
     }
     catch(ClassNotFoundException | SQLException e){
       System.out.println("some problem is found");
     }
      
  }


     
     
     
}
