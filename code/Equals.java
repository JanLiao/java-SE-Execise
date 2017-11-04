class Box{
	private int length;
	private int width;
	private int height;
	public Box(){
		this(10, 10, 10);
	}
	public Box(int length, int width, int height){
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Box)){
			return false;
		}
		Box box = (Box)obj;
		return length==box.length && width==box.width && height==box.height;
	}
	public String toString(){
		return "Box["+length+","+width+","+height+"]";
	}
}
public class Equals{
	public static void main(String[] args){
		Box box = new Box();
		System.out.println(box);
		Box box1 = new Box(20,50,10);
		Box box2 = new Box(20, 50, 10);
		System.out.println("box1-box2:"+box1.equals(box2));
	}
}