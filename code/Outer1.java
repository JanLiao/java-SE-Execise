public class Outer1{
	private static int size;

	public class Inner{
		public void dostuff(){
			size+=10;
		}
	}

	public void testTheInner(){
		Inner i=new Inner();
		i.dostuff();
	}

	public static void main(String[] args){
		Outer1 o=new Outer1();
		o.testTheInner();
		System.out.println(o.size);

		Outer1 o1=new Outer1();
		o1.testTheInner();
		System.out.println(o1.size);
	}
}