public class Final{
	private final int age;

	public Final(int age){
		this.age = age;
	}

	public int getAge(){
		return this.age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public void addAge(int aa){
		this.age = this.age+aa;
	}


	public static void main(String[] args){
		Final f = new Final(8);
		// f.addAge(12);
		Final f1 = new Final(12);
		System.out.println("age="+f.getAge());
		System.out.println("age="+f1.getAge());
	}
}