class Person{
	public Person(){
		System.out.println("333");
	}
	public Person(String s){
		System.out.println("5555");
	}
}

public class ToStr extends Person{
	public ToStr(){
		super("kkk");
		System.out.println(9999);
	}
	public ToStr(String s){
		super("jjjj");
		System.out.println(s);
		System.out.println(8888);
	}
	public static void main(String[] args){
		ToStr ts = new ToStr();
		ToStr ts1 = new ToStr("sssss");
		System.out.println(6666);
	}
}