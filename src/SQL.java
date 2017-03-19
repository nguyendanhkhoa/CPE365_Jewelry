/**
 * Created by khoanguyen1 on 3/18/17.
 */
import java.sql.*;
public class SQL {
        public static void main(String args[]){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(
//                        "jdbc:mysql://cslvm74.csc.calpoly.edu/knguy202","knguy202","diamonxd");
                        "jdbc:mysql://localhost:3306/zilikini_db","root","password");
//here sonoo is database name, root is username and password
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from Customers");
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                con.close();
            }catch(Exception e){ System.out.println(e);}
        }
}
