import java.util.*;
import java.sql.*;
class JDBC3{
    public static void main(String abc[]) throws Exception{
        Connection con=null;
        ResultSet rs=null;
        Statement stmt;

        Class.forName("org.postgresql.Driver");

        con = DriverManager.getConnection("jdbc:postgresql://localhost/parth","postgres","root");

        stmt = con.createStatement();

        Scanner sc=new Scanner(System.in);

        int eid,ch;
        String ename;
        float esal;

        do{
        System.out.println("\n\nMENU:-\n");
        System.out.println("1:-Insert\n");
        System.out.println("2:-Update\n");
        System.out.println("3:-Delete\n");
        System.out.println("4:-Search\n");
        System.out.println("5:-View/Display Table\n");
        System.out.println("6:-Exit\n");
        System.out.println("Enter The Choice=");
        ch = sc.nextInt();
        switch(ch){
            case 1 :try{
                    System.out.println("Enter The Emp Id=");
                    eid=sc.nextInt();
                    System.out.println("Enter The Emp Name=");
                    ename=sc.next();
                    System.out.println("Enter The Emp Salary=");
                    esal=sc.nextFloat();

                    stmt.executeUpdate("insert into emp values("+eid+",'"+ename+"',"+esal+")");
                    System.out.println("\nRecord Inserted SuccessFully.......");
            }catch(SQLException sqle){
                System.out.println("EmpId is Already Exit or there is some Error");
            }
                    break;
            case 2 :System.out.println("Enter The Employee Id=");
                    eid=sc.nextInt();

                    System.out.println("1:-Update Name");
                    System.out.println("2:-Update Salary");

                    System.out.println("Enter The Choice which you want to update=");;
                    int ch1=sc.nextInt();

                    if(ch1==1){
                        System.out.println("\nEnter The Emp Name=");
                        ename=sc.next();
                        stmt.executeUpdate("update emp set ename='"+ename+"' where empid="+eid);
                        System.out.println("Record Update Successfully...");
                    }
                    else if(ch1==2){
                        System.out.println("\nEnter The Emp Salary=");
                        esal=sc.nextFloat();
                        stmt.executeUpdate("update emp set esal="+esal+" where empid="+eid);
                        System.out.println("\nRecord Update Successfully...");
                    }else{
                        System.out.println("Invalid Employee Id");
                    }
                  break;
            case 3: System.out.println("Enter The Employee Id to Delete the Record=");
                    eid=sc.nextInt();
                    int k=stmt.executeUpdate("delete from emp where empid="+eid);
                    if(k==0){
                        System.out.println("EmpID Not Found....");
                    }
                    else{
                    System.out.println("Record delete Successfully....");
                    }
                  break;
            case 4: System.out.println("Enter The Employee Id to Search the Record=");
                    eid=sc.nextInt();
                    rs=stmt.executeQuery("select * from emp where empid="+eid);
                    if(rs.isBeforeFirst()){
                        rs.next();
                        System.out.println("--------------------------------------------");
                        System.out.println("EmpId\t\tEmpName\t\tEmpSalary");
                        System.out.println("--------------------------------------------");
                        System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
                    }
                    else{
                        System.out.println(eid+" not found");
                    }
                    break;
            case 5: rs=stmt.executeQuery("select * from emp");
                    if(rs.isBeforeFirst()){
                    System.out.println("--------------------------------------------");
                    System.out.println("EmpId\t\tEmpName\t\tEmpSalary");
                    System.out.println("--------------------------------------------");
                    while(rs.next()){
                        System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
                    }
                }
                else{
                    System.out.println("Table is Empty......");
                }
                  break;
        }
        }while(ch!=6);
    }
}