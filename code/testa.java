public class testa{
	public static void main(String[] args){
		int i=5;
		String s=new String("55");
		String t=new String("55");
		int j=10;
		String s1="55";
		String t1="55";
		String s2=s;
		String t2=s;
		System.out.println(s==t);
		System.out.println(s1==t1);
		System.out.println(s2==t2);
		System.out.println(~i);
		System.out.println(~j);
		System.out.println(i+~j);
	}
}