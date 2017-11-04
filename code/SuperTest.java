class Super{
	public void doThing(){
		System.out.println("Parent");
	}
}

class Sub extends Super{
	public void doThing(){
		super.doThing();
		System.out.println("Children");
	}
}
public class SuperTest{

	public void test(){
		Super s = new Sub();
		s.doThing();
	}
	public static void main(String[] args){
		SuperTest st = new SuperTest();
		st.test();
	}
}