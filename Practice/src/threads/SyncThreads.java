package threads;

//Implementing Synchronization among Threads
class Thread1{
	synchronized void call(){//synchronized or not
		System.out.println("First statement..");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){}
		System.out.println("Second Statement");
	}
}
class Thread2 extends Thread{
	Thread1 t;
	public Thread2(Thread1 t){
		this.t=t;
	}
	public void run(){
		t.call();
	}
}
public class SyncThreads{
	public static void main(String arg[]){
		Thread1 obj1=new Thread1();
		Thread2 obj2=new Thread2(obj1);
		Thread2 obj3=new Thread2(obj1);
		obj2.start();
		obj3.start();
	}
}