public class TestThread extends Thread{
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println("count="+i);
		}
	}

	public static void main(String[] args){
		TestThread tt=new TestThread();
		tt.start();
	}
}