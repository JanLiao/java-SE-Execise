class MyThread implements Runnable{
	String name;
	Thread t;
	boolean waitFlag;
	MyThread(String threadName){
		name = threadName;
		t = new Thread(this, name);
		System.out.println("New Thread:"+t);
		waitFlag = false;
		t.start();
	}
	public void run(){
		try{
			for(int i=10;i>0;i--){
				System.out.println(name+"--"+i);
				Thread.sleep(1000);
				synchronized(this){
					while(waitFlag){
						wait();
					}
				}
			}
		}catch(Exception e){
			System.out.println(name+"interrupt.");
			e.printStackTrace();
		}
		System.out.println(name+" exit.");
	}
	void myWait(){
		waitFlag = true;
	}
	synchronized void myNotify(){
		waitFlag = false;
		notify();
	}
}
public class TestWait{
	public static void main(String[] args){
		MyThread mt = new MyThread("Thread one");
		MyThread mt1 = new MyThread("Thread two");
		try{
			Thread.sleep(1000);
			mt.myWait();
			System.out.println("Suspend Thread one");
			Thread.sleep(1000);
			mt.myNotify();
			System.out.println("Resume Thread two");
			mt1.myWait();
			System.out.println("Suspend Thread three");
			Thread.sleep(1000);
			mt1.myNotify();
			System.out.println("Resume Thread four");
		}catch(Exception e){
			System.out.println("Main Thread Interrupt");
		}
		try{
			System.out.println("Waiting for threads to finish");
			mt.t.join();
			mt1.t.join();
		}catch(Exception e){
			System.out.println("Main Thread Interrupt");
		}
		System.out.println("Main Thread exit");
	}
}