class Parent{
	public Parent(String s){}
	protected Parent(){}
}
public class ConTest extends Parent{
	private String str;
	public ConTest(){
		//super("ss");
	}
	public static void main(String[] args){
		ConTest ct=new ConTest();
	}
}