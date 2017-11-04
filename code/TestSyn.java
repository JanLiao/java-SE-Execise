public class TestSyn{
	public static void main(String[] args){
		MyThread mt = new MyThread(1);
		mt.start();
		MyThread mt1 = new MyThread(3);
		mt1.start();
	}
}

class MyThread extends Thread{
	private int val;
	public MyThread(){

	}
	public MyThread(int v){
		val = v;
	}

	public synchronized void printVal(int v){
		for(int i=0;i<100;i++){
			System.out.print(v);
		}
	}
	public void run(){
		printVal(val);
	}
}