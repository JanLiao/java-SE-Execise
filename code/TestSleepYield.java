import java.io.*;
public class TestSleepYield{
	public static void main(String[] args){
		MyThread t1=new MyThread("t1线程");
		MyThread t2=new MyThread("t2线程");
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}
}

class MyThread extends Thread{
	public MyThread(String s){
		super(s);
	}
	public void run(){
		for(int i=1;i<=30;i++){
			if(i%5==0){
				// try{
				// 	sleep(2000);
				// }catch(Exception e){
				// 	e.printStackTrace();
				// }
				yield();
			}

			System.out.println(getName()+":"+i);
		}
	}
}