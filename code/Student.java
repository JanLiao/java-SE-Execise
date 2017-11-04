class Person{
	private String name;
	private int age;
	private String sex;
	public String str;
	public Person(){
		this.sex = "man";
	}
	public Person(int age){
		this();
		this.age = age;
	}
	public Person(int age, String name){
		this(age);
		this.name = name;
	}

	public void show(){
		System.out.println("name="+this.name);
		System.out.println("age="+this.age);
		System.out.println("sex="+this.sex);
	}

	public String toString(){
		return "name="+name+",age="+age+",sex="+sex;
	}
}

public class Student extends Person{
	private int grade;
	private String sno;
	public Student(){
		super();
	}
	public Student(int age, String name, int grade, String sno){
		super(age, name);
		//super.name = name;
		this.grade = grade;
		this.sno = sno;
	}

	public void show(){
		super.show();
		super.str = "kkk";
		System.out.println("sno="+this.sno);
		System.out.println("grade="+this.grade);
		//System.out.println("name="+name);
	}

	public static void main(String[] args){
		Student s = new Student(12, "jan", 98, "2016");
		s.show();
	}
}