import java.util.*;
import java.sql.*;
public class JDBC5 {
    public static void main(String abc[]) throws Exception{
        Connection con;
        Statement stmt;
        boolean ans;
        ResultSet rs;


        try {

            Class.forName("org.postgresql.Driver");

            con=DriverManager.getConnection("jdbc:postgresql://localhost/parth","postgres","root");

            stmt=con.createStatement();

            ans=stmt.execute("insert into emp values(7,'ABA',20000)");

            if(ans){
                System.out.println("You Executed Select Query......");
                System.out.println("--------------------------------------------");
                System.out.println("EmpId\t\tEmpName\t\tEmpSalary");
                System.out.println("--------------------------------------------");
                rs=stmt.getResultSet();
                while(rs.next())
                {
                    System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
                }
            }
            else
            {
                System.out.println("\nYou Have Executed Non-Select Query.....");
                int x=stmt.getUpdateCount();
                System.out.println("\nNo of Rows Affected After Insert/Update/Delete="+x);
            }
        }catch(SQLException sqle){}
    }
}
