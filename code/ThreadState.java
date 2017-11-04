import java.io.*;
public class ThreadState{
	public static void main(String[] args){
		TestThreadState tts=new TestThreadState();
		Thread t=new Thread(tts);
		t.start();
	}
}

class TestThreadState implements Runnable{
	public void run(){
		for(int i=1;i<=50;i++){
			if(i%10==0){
				try{
					System.out.println("Before Sleeping:"+Thread.currentThread().isAlive());
					Thread.sleep(2000);
					System.out.println("After Sleeping:"+Thread.currentThread().isAlive());
				}catch(Exception e){
					e.printStackTrace();
				}
			}

			System.out.println("No."+i);
		}
	}
}