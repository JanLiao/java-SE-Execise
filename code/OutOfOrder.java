class PreParent{
	public PreParent(){
		System.out.println("99999");
	}
}
class Parent extends PreParent{
	public Parent(){
		System.out.println("rrrr");
	}
}
class Garbage extends Parent{
	private int num;
	private double[] d;
	// public Garbage(int num){
	// 	this.num=num;
	// 	d=new double[5000];
	// }
	public Garbage(int a){
		System.out.println("sss");
	}

	public Garbage(){
		System.out.println("55555");
	}

	protected void finalize(){
		System.out.println("Garbage="+num);
	}
}

public class OutOfOrder{
	public static void main(String[] args){
		// for(int i=0;i<20;i++){
		// 	new Garbage(i);
		// }
		// new Garbage(7);
		// new Garbage(9);
		// new Garbage(0);
		// new Garbage(8);
		// new Garbage(5);
		new Garbage();

		System.gc();
	}
}