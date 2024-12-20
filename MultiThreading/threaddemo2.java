class threaddemo2 extends Thread{
    Thread t;
    String msg;
    int n;
    threaddemo2(String msg,int no){
        this.msg=msg;
        n=no;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        for(int i=0;i<n;i++){
            System.out.println("Message="+msg+"\n");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){}
        }
    }
}
class demo{
    public static void main(String abc[]){
        threaddemo2 ob1=new threaddemo2("Good Morning",10);
        threaddemo2 ob2=new threaddemo2("Good Evening",10);
        
    }
}