import java.util.Random;
public class SumUsingThreads extends Thread{
    int x[];
    int l,u;
    int total=0;
    SumUsingThreads(int a[],int l,int u){
        this.l=l;
        this.u=u;
        x=a;
    }
    public void run(){
        for(int i=l;i<u;i++){
            total+=x[i];
        }
    }
}
class demo{
    public static void main(String abc[]){
        int a[]=new int[100];
        int i,upperbound,lowerbound;
        Random r=new Random();
        for(i=0;i<a.length;i++){
            a[i]=r.nextInt(50);
        }

        SumUsingThreads ob[]=new SumUsingThreads[5];
        
        lowerbound=0;
        upperbound=19;

        for(i=0;i<5;i++){
            ob[i]=new SumUsingThreads(a,lowerbound,upperbound);
            upperbound+=20;
            lowerbound+=20;
        }

        for(i=0;i<5;i++){
            ob[i].start();
        }

        try{
            for(i=0;i<5;i++){
                ob[i].join();
            }
        }catch(InterruptedException ie){}

        int grandtotal=0;
        for(i=0;i<5;i++){
            System.out.println("Total of Thread"+i+"="+ob[i].total);
            grandtotal+=ob[i].total;
        }
        System.out.println("\nGrand Total="+grandtotal);

    }

}
