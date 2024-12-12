class threaddemo1 extends Thread{
    String msg;
    int n,t;

    threaddemo1(String m,int no,int time){
        msg=m;
        n=no;
        t=time;
    }
    public void run(){
        for(int i=0;i<n;i++){
            System.out.println("Message="+msg+"\n");
            try{
                Thread.sleep(t);
            }catch(InterruptedException ie){}
        }
    }
}
class demo{
    public static void main(String abc[]){
        threaddemo1 ob1=new threaddemo1("Hello",15,1000);
        ob1.start();
        threaddemo1 ob2=new threaddemo1("I Am Parth",20,2000);
        ob2.start();
        
    }
}