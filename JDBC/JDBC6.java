import java.util.*;
import java.sql.*;
class JDBC6{
    public static void main(String abc[]) throws Exception{
        Connection con;
        PreparedStatement psinsert , psdelete , pssearch , psupdatename , psupdatesal;
        ResultSet rs;
        Statement stmt;
        int ch1,ch2,eid;
        String ename;
        float esal;

        Scanner sc = new Scanner(System.in);

        try{
            Class.forName("org.postgresql.Driver");

            con=DriverManager.getConnection("jdbc:postgresql://localhost/parth","postgres","root");

            psinsert = con.prepareStatement("insert into emp values(?,?,?)");

            psdelete = con.prepareStatement("delete from emp where empid=?");

            pssearch = con.prepareStatement("select * from emp where empid=?");

            psupdatename = con.prepareStatement("update emp set ename=? where empid=?");

            psupdatesal = con.prepareStatement("update emp set esal=? where empid=?");

            stmt=con.createStatement();

            do{
                System.out.println("\n\nMENU:-\n");
                System.out.println("1:-Insert\n");
                System.out.println("2:-Update\n");
                System.out.println("3:-Delete\n");
                System.out.println("4:-Search\n");
                System.out.println("5:-View/Display Table\n");
                System.out.println("6:-Exit\n");
                System.out.println("Enter The Choice=");
                ch1 = sc.nextInt();
                switch(ch1){
                    case 1:try{
                            System.out.println("Enter The Emp Id=");
                            eid=sc.nextInt();
                            System.out.println("Enter The Emp Name=");
                            ename=sc.next();
                            System.out.println("Enter The Emp Salary=");
                            esal=sc.nextFloat();

                            psinsert.setInt(1,eid);
                            psinsert.setString(2,ename);
                            psinsert.setFloat(3,esal);

                            psinsert.executeUpdate();

                        }catch(SQLException sqle){
                            System.out.println("\nEmpId Already Exists....");
                            continue;
                        }                
                        System.out.println("\nRecord Inserted Successfully.....");
                            break;
                    case 2: try{
                            System.out.println("Enter The Employee Id=");
                            eid=sc.nextInt();

                            System.out.println("1:-Update Name");
                            System.out.println("2:-Update Salary");

                            System.out.println("Enter The Choice which you want to update=");;
                            ch2=sc.nextInt();

                            if(ch2==1){
                                try{
                                System.out.println("\nEnter The Emp Name=");
                                ename=sc.next();
                                psupdatename.setString(1,ename);
                                psupdatename.setInt(2,eid);

                                int k=psupdatename.executeUpdate();
                                if(k==0){
                                    System.out.println("\nEmpId Doesnot Found....");
                                }
                                else{
                                    System.out.println("\nNo of Rows Affected After Update="+k);
                                }
                            }catch(InputMismatchException imme){
                                System.out.println(imme);
                            }                    
                            }else if(ch2==2){
                                System.out.println("\nEnter The Emp salary=");
                                esal=sc.nextFloat();
                                psupdatesal.setInt(2,eid);
                                psupdatesal.setFloat(1,esal);

                                int k=psupdatesal.executeUpdate();
                                if(k==0){
                                    System.out.println("\nEmpId Doesnot Found....");
                                }
                                else{
                                    System.out.println("\nNo of Rows Affected After Update="+k);
                                }
                            }else if(ch2>3){
                                System.out.println("\nWrong Choice Selection...");
                                continue;
                            }else{
                                System.out.println("\nEmpId Doesnot Found....");
                                continue;
                            }
                        }catch(SQLException sqle){
                            System.out.println(sqle);
                        }
                        break;
                    case 3: System.out.println("Enter The Employee Id=");
                            eid=sc.nextInt();
                            
                            psdelete.setInt(1,eid);

                            int k=psdelete.executeUpdate();

                            if(k==0){
                                System.out.println("\nEmp Id Not Found........");
                            }
                            else{
                                System.out.println("\nNo of Rows Affected After delete="+k);
                            }
                            break;
                    case 4: try{
                            System.out.println("Enter The Employee Id to Search the Record=");
                            eid=sc.nextInt();
                            pssearch.setInt(1,eid);

                            rs=pssearch.executeQuery();
                            if(rs.isBeforeFirst()){
                                rs.next();
                                System.out.println("----------------------------------------");
                                System.out.println("EmpId\t\tEmpName\t\tEmpSalary");
                                System.out.println("----------------------------------------");
                                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
                            }
                            else{
                                System.out.println("\nEmpId not found.......");
                            }
                        }catch(SQLException sqle){
                            System.out.println(sqle);
                        }
                            break;
                    case 5:rs=stmt.executeQuery("select * from emp");
                            if(rs.isBeforeFirst()){
                            System.out.println("--------------------------------------------");
                            System.out.println("EmpId\t\tEmpName\t\tEmpSalary");
                            System.out.println("--------------------------------------------");
                            while(rs.next()){
                                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getFloat(3));
                                }
                        }else{
                            System.out.println("Table is Empty......");
                        }
                        break;                            
                }

            }while(ch1!=6);

        }
        catch(Exception sqle){
            System.out.println(sqle);
        }
    }
}