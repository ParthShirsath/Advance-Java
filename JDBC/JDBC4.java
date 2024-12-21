import java.util.*;
import java.sql.*;
public class JDBC4 {
    public static void main(String abc[]) throws Exception{
        Connection con;
        PreparedStatement pstmt;
        try{
        Class.forName("org.postgresql.Driver");

        con=DriverManager.getConnection("jdbc:postgresql://localhost/parth","postgres","root");

        pstmt=con.prepareStatement("insert into emp values(?,?,?)");

        int eid;
        String ename;
        float esal;

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<5;i++){
            System.out.println("\nEnter The Emp Id=");
            eid=sc.nextInt();
            System.out.println("Enter The Emp Name=");
            ename=sc.next();
            System.out.println("Enter The Emp Salary=");
            esal=sc.nextFloat();
            try{
            pstmt.setInt(1,eid);
            pstmt.setString(2,ename);
            pstmt.setFloat(3,esal);

            pstmt.executeUpdate();
            }catch(SQLException e){
                System.out.println("\nEmployee Id Already Exists...");
                continue;
            }

            System.out.println("\nRecord Insert SuccessFully....");
        }
    }catch(SQLException e){
        System.out.println(e);
    }
    }    
}  
