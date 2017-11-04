public class RunnableThread implements Runnable{
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println("count="+i);
		}
	}

	public static void main(String[] args){
		RunnableThread rt=new RunnableThread();
		Thread t=new Thread(rt);
		t.start();
	}
}