class Super{
	static{
		System.out.println("super class");
	}
	public static final String HELLO = "hello world";
}
class Sub extends Super{
	{
		int b = 2;
		System.out.println(b);
	}
	static{
		int a = 0;
		System.out.println(a);
	}
}

public class For{
	public static void main(String[] args){
		Super[] s = new Super[10];
		System.out.println(Super.HELLO);
	}
}