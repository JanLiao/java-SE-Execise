public class PopThread implements Runnable{
	private StackInterface s;

	public PopThread(StackInterface s){
		this.s=s;
	}

	public void run(){
		System.out.println("-->"+s.pop()[1]+"<--");
	}
}