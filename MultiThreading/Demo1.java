import java.io.*;
class ThreadDemo1 implements Runnable{
    String abc;
    ThreadDemo1(String msg){
        abc=msg;
    }
    public void run(){
            System.out.println("Message="+abc+"\n");
    }
}
public class Demo1{
    public static void main(String abc[]){
        ThreadDemo1 ob1=new ThreadDemo1("Hello");
        Thread t1=new Thread(ob1);
        t1.start();
        t1.suspend();

        // t1.resume();
    }
}