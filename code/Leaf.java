public class Leaf{
	private int i = 0;
	public Leaf increment(){
		i++;
		return this;
	}

	public void print(){
		System.out.println("i = "+ i);
	}

	public String toString(){
		return "i="+i;
	}

	public static void main(String[] args){
		Leaf x = new Leaf();
		x.increment().increment().increment().print();
		Leaf x1 = new Leaf();
		System.out.println(x1.increment().increment().increment().increment());
	}
}