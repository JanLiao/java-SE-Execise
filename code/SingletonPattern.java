import java.lang.*;
public class SingletonPattern{
	private double r;
	private static SingletonPattern sp;
	private  SingletonPattern(){
		System.out.println("111");
		r=Math.random();
	}
	public static SingletonPattern getInstance(){
		System.out.println("222");
		if(sp==null){
			System.out.println("333");
			sp=new SingletonPattern();
		}
		return sp;
	}
	public double getR(){
		return r; 
	}
	public static void main(String[] args){
		SingletonPattern sp3=new SingletonPattern();
		//sp=new SingletonPattern();
		SingletonPattern sp1=SingletonPattern.getInstance();
		SingletonPattern sp2=SingletonPattern.getInstance();
		//SingletonPattern sp3=new SingletonPattern();
		System.out.println(sp3.getR());
		System.out.println(sp1.getR());
		System.out.println(sp2.getR());
	}
}