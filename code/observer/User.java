public class User implements Observer{
	private Subject subject;
	public User(Subject subject){
		this.subject = subject;
		subject.registerObserver(this);
	}
	public void update(String msg){
		System.out.println("我收到一条理财信息:"+msg+"对于我来说这是好信息!");
	}
}