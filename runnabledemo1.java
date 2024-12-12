public class runnabledemo1 implements Runnable{
    String m;
    int no,time;

    runnabledemo1(String msg,int n,int t){
        m=msg;
        no=n;
        time=t;
    }
    public void run(){
        for(int i=0;i<no;i++){
            System.out.println("Message="+m+"\n");
            try{
                Thread.sleep(time);
            }catch(InterruptedException ie){}
        }
    }
}
class demo1{
    public static void main(String abc[]){
        runnabledemo1 ob1=new runnabledemo1("Java",20,400);
        runnabledemo1 ob2=new runnabledemo1("Python",10,1000);
        Thread t1=new Thread(ob1);
        Thread t2=new Thread(ob2);
        t1.start();
        t2.start();
    }
}