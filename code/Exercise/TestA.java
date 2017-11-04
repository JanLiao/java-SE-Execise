public class TestA{
	private int num;
	private String str;
	public TestA(int num, String str, int c){
		this(num, str);
	}

	public TestA(int num, String str){
		this.num = num;
		this.str = str;
	}

	protected static boolean Character_isHighSurrogate(char ch){
		return (ch >= 55296) && (ch <= 56319);
	}

	public void getLen(String clientId){
		int clientIdLength = 0;
    for (int i = 0; i < clientId.length() - 1; i++) {
       if (Character_isHighSurrogate(clientId.charAt(i)))
         i++;
       clientIdLength++;
    }
    System.out.println(clientIdLength);
	}
	public static void main(String[] args){
		TestA t = new TestA(22, "323", 7);
		System.out.println(t.num);
		System.out.println(t.str);
		t.getLen("chendan_test_sub");
	}
}