import java.io.*;
public class TestJoin{
	static int[] a=new int[30];
	public static void main(String[] args){
		JoinThread tj=new JoinThread();
		Thread t=new Thread(tj);
		t.start();
		try{
			t.join();
		}catch(Exception e){
			e.printStackTrace();
		}
        for(int i=0;i<30;i++){
        	
		System.out.println("complement a["+i+"] :"+a[i]);
        }
	}
	static class JoinThread implements Runnable{
		public void run(){
			for(int i=0;i<30;i++){
				System.out.println("init a["+i+"] :"+(30-i));
				a[i]=i-60;
			}
		}
	}
}
