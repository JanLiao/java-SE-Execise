public class TestJoin1 extends Thread{
	private static int a = 0;
	public void run(){
		for(int i=0;i<10;i++){
			a+=i;
		}
	}

	public static void main(String[] args){
		TestJoin1 tj = new TestJoin1();
		tj.start();
		try{
			tj.join();
		}catch(Exception e){
			e.printStackTrace();
		}
//		tj.join();
		System.out.println(a);
	}
}