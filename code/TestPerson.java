class Person{
	private int age;
	public void getAge(){
		System.out.println("11111");
	}
}

class Teacher extends Person{
	private String numt;
}

class Student extends Person{
	private String id;
	public void getId(){
		System.out.println("555");
	}
}

public class TestPerson{
	public static void main(String[] args){
	Person p=new Student();
	Person p1=new Teacher();
	//p.getId();
	//System.out.println(p.id);
	if(p instanceof Teacher){
		Teacher t=(Teacher)p;
		System.out.println("888");
	}
	if(p1 instanceof Teacher){
		Teacher t=(Teacher)p1;
		System.out.println("6666");
	}
  }
}