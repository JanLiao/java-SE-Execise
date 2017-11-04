public class TestInterrupt extends Thread{
	public static void main(String[] args){
		TestInterrupt ti = new TestInterrupt();
		ti.start();
	}

	public void run(){
		int count = 0;
		while(!this.isInterrupted()){
			System.out.println("---"+count+"---"+this.isAlive());
			count++;
			if(count == 5){
				this.interrupt();
				System.out.println("---"+count+"---"+this.isAlive());
			}
		}
	}
}