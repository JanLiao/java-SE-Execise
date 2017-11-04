public class Divide{
	public static void main(String args[]){
		String str1="abc";
		String str2=new String("abc").intern();
		String str3="abc";
		String str4=str1;
		String str5=new String("abc");
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1==str4);
		System.out.println(str5==str2);
		boolean a;
		boolean b;
		//a=1&2;
		//b=1|2;
		String s;
		byte c=2;
		byte g=3;
		byte f='a';
		char d='a';
		int m=c+d;
		double h=1.2588;
		double i=1;
		System.out.println(""+h);
		System.out.println(""+h+i);
        //d+=c;
		System.out.println(m);
		System.out.println(f);
		System.out.println(c+g);
		//System.out.println(a+"ss"+b);
		System.out.println("ss="+17/3);
		System.out.println("ss=="+17.0/0);

		outer:
		for(int j=0;j<10;j++){
			System.out.println("输出:"+j);
			inner:
			   while(true){
			   	     try{
			   	    int k=System.in.read();
			   	    System.out.println("内部输出:"+k);
			   	    if(k=='a')   break inner;
			   	    if(k=='b')  break outer;
			   	}catch(Exception e){
			   		e.printStackTrace();
			   	}
			   }
		}
	}
}