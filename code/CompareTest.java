import java.util.*;
class Worker implements Comparable<Worker>{
	private String name;
	private int age;
	private double salary;
	public Worker(String name, int age, double salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public int compareTo(Worker worker){
		if(age < worker.age){
			return -1;
		}else if(age == worker.age){
			return 0;
		}else{
			return 1;
		}
	}
	public String toString(){
		return "Worker["+name+","+age+","+salary+"]";
	}
}

public class CompareTest{
	public static void main(String[] args){
		Worker[] worker = new Worker[4];
	    worker[0] = new Worker("jan", 30, 5000);
		worker[1]  = new Worker("fang", 35, 6000);
		worker[2]  = new Worker("liao", 25, 10000);
		worker[3] = new Worker("liu", 29, 120000);
		for(Worker w:worker){
			System.out.println(w);
		}
		Arrays.sort(worker);
		System.out.println();
		System.out.println();
		System.out.println();
		for(Worker w:worker){
			System.out.println(w);
		}
	}
}