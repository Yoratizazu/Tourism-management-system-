
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Dependent

@ManagedBean(name = "tableveiw")
@SessionScoped
public class tableveiw {


    public List<AddPackageBean> getUserList() {
        List<AddPackageBean> list = new ArrayList<>();
        try {
        
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from PACKAGETABLE1");
            while (rs.next()) {
                AddPackageBean admin = new AddPackageBean();
         
               admin.setName(rs.getString("NAME"));
                admin.setDays(rs.getString("DAYS"));
                admin.setPlace(rs.getString("PLACE"));
                admin.setPrice(rs.getString("PRICE"));
               
                
              
                list.add(admin);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }

}

