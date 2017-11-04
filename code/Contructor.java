class Sup{
	public Sup(int length){
		int len = length;
		System.out.println("Sup");
		System.out.println(len);
	}
	public Sup(){
		System.out.println(88);
	}
}
class Sub extends Sup{
	public Sub(int length){
		//super(length);
		System.out.println("Sub");
		System.out.println(15);
	}
}
public class Contructor{
	public static void main(String[] args){
		Sub s = new Sub(10);
	}
}