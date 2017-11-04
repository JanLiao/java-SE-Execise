class Line{
	protected int length;
	public Line(){
		this(10);
	}
	public Line(int length){

		this.length = length;
	}
	public int getLength(){
		return this.length;
	}
	public String toString(){
		return "Line["+length+"]";
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Line)){
			return false;
		}
		Line line = (Line)obj;
		return length==line.length;
	}
}
class Curve extends Line{
	// private int length;
	public Curve(int length){
		super(length);
		//this.length = length;
	}
	public String toString(){
		return "Curve["+this.length+"]";
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Line)){
			return false;
		}
		Line line = (Line)obj;
		return  length==line.length;
	}
}
public class Equals1{
	public static void main(String[] args){
		Line line = new Line(20);
		Curve curve = new Curve(20);
		Line line1 = new Line(10);
		Curve curve1 = new Curve(10);
		Line line2 = new Line(20);
		Curve curve2 = new Curve(20);
		System.out.println("line-line1:"+line.equals(line1));
		System.out.println("line-line2:"+line.equals(line2));
		System.out.println("curve-curve1:"+curve.equals(curve1));
		System.out.println("curve-curve2:"+curve.equals(curve2));
		System.out.println("line-curve:"+line.equals(curve));
		System.out.println("curve-line:"+curve.equals(line));
	}
}