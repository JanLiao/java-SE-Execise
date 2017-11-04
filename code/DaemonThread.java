public class DaemonThread extends Thread{
	public void run(){
		while(true){
			System.out.println("Thread is running....");
		}
	}

	public static void main(String[] args){
		DaemonThread dt=new DaemonThread();
		//dt.setDaemon(true);
		dt.start();
	}
}