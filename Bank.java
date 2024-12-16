class accountThread extends Thread{
    deposite_withdrawl d;
    accountThread(deposite_withdrawl dw){
        d=dw;
    }
    public void run(){
        d.withdrawl(20000,this);    
    }
}
class deposite_withdrawl{
    int balance;
    public void deposite(int b){
        balance+=b;
    }
    synchronized public void withdrawl(int a,Thread t){
        System.out.println(t.getName()+" wants To withdrawls");
        System.out.println(t.getName()+" withdrawl atmost "+(balance-500)+"rs....");
        
        if(balance-a<500){
            System.out.println("InSufficiant Money...\n");
        }
        else{
            balance=balance-a;
            System.out.println("Balance after withdrawl="+balance+"\n");
        }
    }
}
class Bank{
    public static void main(String abc[]){
        deposite_withdrawl ob1=new deposite_withdrawl();
        ob1.deposite(60000);
        
        accountThread t1=new accountThread(ob1);
        t1.setName("ATM");

        accountThread t2=new accountThread(ob1);
        t2.setName("CHEUQE");
        
        accountThread t3=new accountThread(ob1);
        t3.setName("NET BANKING");
        
        t1.start();
        t2.start();
        t3.start();
    }
}