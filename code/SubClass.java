class SuperClass{
	protected static int s =9;
	public static void start(){
		System.out.println("sss");
	}
}
public class SubClass extends SuperClass{
	public static void main(String[] args){
		System.out.println(s);
		System.out.println(SuperClass.s);
		start();
	}
}