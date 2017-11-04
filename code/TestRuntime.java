import java.io.*;
public class TestRuntime{
	{
		init();
	}
	private int a=10;
	private int b=15;
	public void init(){
		System.out.println(a+b);
	}
	public static void main(String[] args){
		TestRuntime tr=new TestRuntime();
		Runtime rt=Runtime.getRuntime();
		//Runtime rt1=(new Runtime()).getRuntime();
		if(args.length!=1){
			System.out.println("err");
		}else{
			try{

			rt.exec(args[0]);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}