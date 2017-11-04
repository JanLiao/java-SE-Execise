public class User1 implements Observer{
	private Subject subject;
	public User1(Subject subject){
		this.subject = subject;
		subject.registerObserver(this);
	}
	public void update(String msg){
		System.out.println("我收到一条微信理财的信息:"+msg+"对于我来说这无关紧要!");
	}
}