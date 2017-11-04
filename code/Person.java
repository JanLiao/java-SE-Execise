public class Person{
	private String name;
	private int age;
	private String sex;
	public Person(){
        System.out.println("构造器Person()");
        sex="male";
        System.out.println("name="+name+",age="+age+",sex="+sex);
	}
	public Person(String name){
         this();
         System.out.println("构造器Person(String name)");
         name=name;
         System.out.println("name="+name+",age="+age+",sex="+sex);
	}
	public Person(String name,int age){
		this(name);
		System.out.println("构造器Person(String name,int age)");
         age=age;
         System.out.println("name="+name+",age="+age+",sex="+sex);
	}
	public static void main(String[] args){
		Person person=new Person("Jan",25);
		System.out.println(person.name);
		System.out.println("name="+person.name+",age="+person.age+",sex="+person.sex);
		System.out.println("--------------------");
		Person p=new Person("liao");
		System.out.println("name="+p.name+",age="+p.age+",sex="+p.sex);
		System.out.print("--------------------");
		//System.out.println("name="+this.name+",age="+this.age+",sex="+this.sex);
	}
}