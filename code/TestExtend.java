class Person{
	private String name;
	private String wage;
	public Person(String name){
		System.out.println("666");
       this.name=name;
	}
	// public Person(){
        
	// }
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}

public class TestExtend extends Person{
	private String address;
	public TestExtend(String name){
		super("jing");
		System.out.println("999");
		//super.setName(name);

          
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public static void main(String[] args){
          TestExtend te=new TestExtend("liao");
          System.out.println(te.getName());
          te.setName("Jan");
          System.out.println(te.getName());
	}
}