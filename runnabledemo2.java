public class runnabledemo2 implements Runnable{
    String m;
    int no,time;
    Thread t;
    runnabledemo2(String msg,int n,int t){
        m=msg;
        no=n;
        time=t;
        this.t=new Thread(this);
        this.t.start();
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
class demo2{
    public static void main(String abc[]){
        runnabledemo2 ob1=new runnabledemo2("Java",20,400);
        runnabledemo2 ob2=new runnabledemo2("Python",10,1000);
    }
}