public class Person4{
	private String name;
	private int age;
	private String sex;

	public Person4(){
		this.sex = "nan";
	}
	public Person4(int age){
		this();
		this.age = age;
	}
	public Person4(int age, String name){
		this(age);
		this.name = name;
	}

	public String toString(){
		return name+":age="+age+",sex="+sex;
	}

	public static void main(String[] args){
		Person4 p = new Person4(12, "jan");
		System.out.println(p);
	}
}