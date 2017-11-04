public class FT{
	public void caculate(int a, int b){
		a=9;
		b=8;
		System.out.println("a="+a+" "+"b="+b);
	}

	public static void main(String[] args){
		int a=0;
		int b=1;
		FT ft = new FT();
		ft.caculate(a,b);
		System.out.println("a="+a+" "+"b="+b);
	}
}