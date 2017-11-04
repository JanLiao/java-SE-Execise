public class ObserverTest{
	public static void main(String[] args){
		Message ms = new Message();
		User u = new User(ms);
		User1 u1 = new User1(ms);
		ms.distributemsg("基金涨了5%");
	}
}