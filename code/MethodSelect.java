class Bird{}

class Parrot extends Bird{}

class Fish{}

class Shark extends Fish{}

public class MethodSelect{
	public void test(Integer in){
		System.out.println(in+"==");
	}

	public void test(int...a){
		System.out.println(a.length);
		for(int i:a){
			System.out.println(i);
		}
	}

	public void select(Parrot p,Shark s){
		System.out.println("oooo");
	}

	public void select(Bird bird,Fish fish){
		System.out.println("success kkk");
	}

	public void select(Bird bird,Shark shark){
		System.out.println("success");
	}

	public void select(Parrot parrot,Fish fish){
		System.out.println("success ok");
	}


	public static void main(String[] args){
		MethodSelect ms=new MethodSelect();
		Parrot p=new Parrot();
		Shark s=new Shark();
		//ms.select(p,s);
		ms.test(5,09,6);
		ms.test(8);
	}
}