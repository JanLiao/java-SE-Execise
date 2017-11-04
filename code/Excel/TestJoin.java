public class TestJoin extends Thread{
	private static int a = 0;
	public void run(){
		for(int i=0;i<10;i++){
			a+=i;
		}
	}

	public static void main(String[] args){
		TestJoin tj = new TestJoin();
		tj.start();
		System.out.println(a);
	}
}