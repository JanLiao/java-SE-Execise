public class Person2{
	private String name;
	private int age;
	private String sex;
	public Person2(){
        sex="male";
	}
	public Person2(String name){
         this();
         this.name=name;
	}
	public Person2(String name,int age){
		this(name);
         this.age=age;
	}
	public static void main(String[] args){
		Person2 person=new Person2("Jan",25);
		System.out.println(person.name);
		System.out.println("name="+person.name+",age="+person.age+",sex="+person.sex);
		System.out.println("--------------------");
		Person2 p=new Person2("liao");
		System.out.println("name="+p.name+",age="+p.age+",sex="+p.sex);
		System.out.print("--------------------");
		//System.out.println("name="+this.name+",age="+this.age+",sex="+this.sex);
	}
}