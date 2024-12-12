public class runnabledemo3 implements Runnable{
    String m;
    int no,time;
    Thread t;
    runnabledemo3(String msg,int n,int t){
        m=msg;
        no=n;
        time=t;
        this.t=new Thread(this);
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
class demo3{
    public static void main(String abc[]){
        runnabledemo3 ob1=new runnabledemo3("Java",20,400);
        runnabledemo3 ob2=new runnabledemo3("Python",10,1000);
        ob1.t.start();
        ob2.t.start();
    }
}