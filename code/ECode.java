import java.util.*;
class Box{
	private int length;
	private int width;
	private int height;
	public Box(){
		this(10, 20, 30);
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
	public int hashCode(){
		return length ^ width ^ height;
	}
}
public class ECode{
	public static void main(String[] args){
		Box box1 = new Box(15, 25, 35);
		Box box2 = new Box(10, 20, 30);
		Box box3 = new Box(15, 25, 35);
		HashMap<Box,String> map = new HashMap<Box,String>();
		map.put(box1, "box1");
		String s = map.get(box3);
		System.out.println(s);
	}
}