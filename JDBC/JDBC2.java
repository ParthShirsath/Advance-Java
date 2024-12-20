import java.util.*;
import java.sql.*;
class JDBC2
{
  public static void main(String[] args)throws Exception{

  Class.forName("org.postgresql.Driver");

  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/parth","postgres","root");

  Statement st=con.createStatement();
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter The Emp Id=");
  int eid=sc.nextInt();
  System.out.println("Enter The Emp Name=");
  String ename=sc.next();
  System.out.println("Enter The Emp Salary=");
  float esal=sc.nextFloat();
  
  int k=st.executeUpdate("insert into emp values("+eid+",'"+ename+"',"+esal+")");
  if(k>0){
    System.out.println("Record Insert Successfully....");
  }

  }
}