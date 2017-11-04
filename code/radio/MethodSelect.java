class Bird{}

class Parrot extends Bird{}

class Fish{}

class Shark extends Fish{}

public class MethodSelect{
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
		ms.select(parrot,shark);
	}
}