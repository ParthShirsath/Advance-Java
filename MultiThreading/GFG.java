import java.util.*;
class MyThread extends Thread {
	public void run()
	{
		try {
			System.out.println(
				"Thread " + Thread.currentThread().getId()+" is running");
		}
		catch (Exception e) {
			System.out.println("Exception is caught");
		}
	}
}
public class GFG {
	public static void main(String[] args) throws Exception
	{
		MyThread thread = new MyThread();
		thread.setName("GFG");
		thread.start();
		Thread.sleep(500);

		thread.suspend();

		System.out.println("Thread going to sleep for 5 seconds");

		Thread.sleep(5000);
		System.out.println("Thread Resumed");
		thread.resume();
	}
}
