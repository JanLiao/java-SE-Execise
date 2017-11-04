public class TestSyn1{
	public static void main(String[] args){
		int[] a = new int[0];
//		System.out.println(a[0]);
		MyThread mt = new MyThread(1);
		mt.start();
		MyThread mt1 = new MyThread(3);
		mt1.start();
	}
}

class MyThread extends Thread{
	private int val;
//	private static byte[] lock = new byte[1];
	private static byte[] lock = new byte[0];
	public MyThread(){

	}
	public MyThread(int v){
		val = v;
	}

	public void printVal(int v){
		synchronized(lock){		
			for(int i=0;i<100;i++){
				System.out.print(v);
			}
		}
	}
	public void run(){
		printVal(val);
	}
}