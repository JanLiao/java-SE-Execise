class Circle{
	private int radius;
	public int getRadius(){
		return this.radius;
	}
	public class Center{
		private int radius;
		public int x;
		public int y;
		public Center(int x, int y){
			this.x = x;
			this.y = y;
			radius = 5;
			Circle.this.radius = 8;
		}
		public int getRadius(){
		return this.radius;
	}
	}
}

public class InnerClass{
	public static void main(String[] args){
		Circle circle = new Circle();
		Circle.Center center = circle.new Center(15, 20);
		System.out.println(center.x);
		System.out.println(center.x);
		System.out.println(center.getRadius());
		System.out.println(circle.getRadius());
	}
}