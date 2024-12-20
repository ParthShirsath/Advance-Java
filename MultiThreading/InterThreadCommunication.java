import java.util.*;
class acceptnumber extends Thread{
    number o;
    acceptnumber(number ob){
        o=ob;
    }
    public void run(){
        try{
            o.accept();
        }catch(Exception e){}
    }
}
class displaynumber extends Thread{
    number o;
    displaynumber(number ob){
        o=ob;
    }
    public void run(){
        try{
            o.display();
        }catch(Exception e){}
    
    }
}
class calculatenumber extends Thread{
    number o;
    calculatenumber(number ob){
        o=ob;
    }
    public void run(){
        try{
            o.calculate();
        }catch(Exception e){}
    
    }
}
class number{
    int a,b;
    int total;
    Scanner sc=new Scanner(System.in);
    synchronized public void accept() throws InterruptedException{
        System.out.println("Enter Two Numbers=");
        a=sc.nextInt();
        b=sc.nextInt();
        notifyAll();
    }
    synchronized public void display() throws InterruptedException{
        wait();
        System.out.println("First Number is="+a);
        System.out.println("Second Number is="+b);
    }
    synchronized public void calculate() throws InterruptedException{
        wait();
        total=a+b;
        System.out.println("Total="+total);
    }
}
public class InterThreadCommunication {
    public static void main(String args[]){
        number ob=new number();
        acceptnumber t1=new acceptnumber(ob);
        displaynumber t2=new displaynumber(ob);
        calculatenumber t3=new calculatenumber(ob);
        t2.start();
        t3.start();
        //starting acceptnumber thread
        try{
            Thread.sleep(3000);
            t1.start();
        }
        catch(Exception e){}
    }
}