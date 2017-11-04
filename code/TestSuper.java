class Super{
	protected int height = 1;
	protected static int wide = 0;
	public  void doThing(){
		System.out.println("555");
	}

	public static void run(){
		System.out.println("999");
	}
}

class Sub extends Super{
	protected int height = 5;
	public void doThing(){
		System.out.println("6666");
	}

	public static void run(){
		System.out.println("888");
	}
}

public class TestSuper{
	public static void main(String[] args){
		Sub s = new Sub();
		s.doThing();
		s.run();
		//s.wide = 8;
		System.out.println(s.height);
		System.out.println(s.wide);

		Super st = new Super();
		st.wide = 5;
		System.out.println(st.height);
		System.out.println(st.wide);
		System.out.println(s.wide);


		Super sp = new Sub();
		sp.doThing();
		sp.run();

		Sub ss = (Sub)sp;
		ss.doThing();
		ss.run();
	}
}