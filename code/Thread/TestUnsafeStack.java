public class TestUnsafeStack{
	public static void main(String[] args){
		UnsafeStack s=new UnsafeStack();
		s.push(1);
		s.push(2);
		PushThread r1=new PushThread(s);
		PopThread r2=new PopThread(s);
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
	}
}