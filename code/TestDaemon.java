import java.io.*;
public class TestDaemon extends Thread{
	public static void main(String[] args){
		TestDaemon td = new TestDaemon();
		td.setDaemon(true);
		td.start();
		for(int i=0;i<10;i++){
			try{
				Thread.sleep(500);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("--DaemonThread--"+i);
		}
	}

	public void run(){
		for(int i=0;i<100;i++){
			try{
				Thread.sleep(500);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("--currentThread--"+i);
		}
	}
}