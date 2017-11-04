import java.io.*;
class Animal{
	private int a = 0;
	public void getA(){
		System.out.println(a);
	}
}
public class GetClass{
	public static void main(String[] args){
	    Class c3 = null;
		Class c1 = Animal.class;
		System.out.println(c1);
		Animal animal = new Animal();
		Class c2 = animal.getClass();
		System.out.println(c2);
		try{
		    c3 = Class.forName("Animal");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(c3);
		if(c1 == c2){
			System.out.println("相等1");
		}
		if(c1 == c3){
			System.out.println("相等2");
		}
		if(c3 == c2){
			System.out.println("相等3");
		}
	}
}