public class SharpTriangle extends Sharp{
	protected double a,b,c;

	public SharpTriangle(){
		setSides(0,0,0);
	}

	public SharpTriangle(double i,double j,double k){
		setSides(i,j,k);
	}

	public void setSides(double a,double b,double c){
		this.a=a;
		this.b=b;
		this.c=c;
	}

	public double perimeter(){
		return a+b+c;
	}

	public String getType(){
		return "三角形";
	}

	public static void main(String[] args){
		SharpTriangle st=new SharpTriangle(2.3,5.5,9);
		st.setColor("red");
		System.out.println(st.perimeter());
		System.out.println(st.getType());
		System.out.println(st.getColor());
	}
}