class ThreadDemo extends Thread{
    String abc;
    int n;
    ThreadDemo(String msg,int no){
        abc=msg;
        n=no;
    }
    public void run(){
        for(int i=0;i<n;i++){
            System.out.println("Message="+abc+"\n");
        }
    }
}
class Demo{
    public static void main(String abc[]){
        ThreadDemo ob1=new ThreadDemo("Hello",4);
        ThreadDemo ob2=new ThreadDemo("World",10);
        ob1.start();
        ob2.start();
        try{
        ob1.join();
        //ob2.join();
        }
        catch(InterruptedException ie){}
        System.out.println("EXIT OF MAIN THREAD...");
    }
}