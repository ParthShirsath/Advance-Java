class A implements Runnable
{
    synchronized public void run(){
        for(int i=0;i<5;i++){
            System.out.println("A of i="+i);
        }
    }
}
class B implements Runnable{
    synchronized public void run(){
        for(int i=0;i<5;i++){
            System.out.println("B of i="+i);
        }
    }
}
public class Synchronized_method {
    public static void main(String[] args) {
        A ob1=new A();
        B ob2=new B();

        Thread t1=new Thread(ob1);
        Thread t2=new Thread(ob2);
    
        t1.start();
        t2.start();
    }
}
