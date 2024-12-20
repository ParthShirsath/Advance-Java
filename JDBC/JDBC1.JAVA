import java.sql.*;
class JDBC1
{
   public static void main(String[] args)throws Exception{

  Class.forName("org.postgresql.Driver");

  Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/parth","postgres","root");

  Statement st=con.createStatement();

  ResultSet rs;

  rs=st.executeQuery("select * from emp");



  while(rs.next()){

   System.out.println("Emp id="+rs.getInt(1));

   System.out.println("Emp name="+rs.getString(2));

   System.out.println("Emp sal="+rs.getFloat(3));
  }
}
}