import java.io.*;
public class Persons implements Serializable{
	public String name;
	public int age;
	public String sex;
	public String nation;

	public Persons(String name,int age,String sex,String nation){
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.nation=nation;
	}

	public String getNation(){
		return this.nation;
	}

	public String toString(){
		return name+"="+age+"="+sex+"="+nation;
	}
}