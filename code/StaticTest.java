public class StaticTest{
	private static int i;
	private final int j=0;
	private final int k =21;
	private static final int age = 55;

	public StaticTest(int k){
		//this.k = k;
	}

	public StaticTest(){

	}

	public final void show(int age){
		//this.age = age;
		System.out.println(k);
	}

	static {
		System.out.println("is processing");
		i++;
		System.out.println("i="+i);
		//System.out.println("j="+j);
	}
	public static void main(String[] args){
		//j=9;
		//System.out.println("j="+j);
		//k = 9;
		//StaticTest st = new StaticTest();
		//st.show(22);
		StaticTest st1 = new StaticTest(12);
		System.out.println("age="+st1.age);
		System.out.println("k="+st1.k);
		//st1.show(80);
	}
}