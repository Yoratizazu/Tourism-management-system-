
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Bean1 {
 
public List<Packagebean1>list;  
public List<Packagebean1>getList() throws ClassNotFoundException{
    list=new ArrayList<>();
 
    try {

      Statement st;
      DBConnection obj = new DBConnection();
       Connection conn = obj.connMethod();
        st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from PACKAGETABLE1");
        while(rs.next()){
        String var1=rs.getString("NAME");
        String var2=rs.getString("DAYS");
        String var3=rs.getString("PLACE");
        String var4=rs.getString("PRICE");
     
      list.add(new Packagebean1(var1,var2,var3, var4));
 }
        
    } catch (SQLException ex) { 
        Logger.getLogger(Packagebean1.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}


   
    
}
