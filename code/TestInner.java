class Enclosing{
	private int x = 9;
	public int getX(){
		return this.x;
	}
	class InnerClass{
		public int getEX(){
			return Enclosing.this.x;
		}
	}
}

class SubInnerClass extends Enclosing.InnerClass{
	public SubInnerClass(Enclosing e){
		e.super();
	}
}

public class TestInner{
	public static void main(String[] args){
		Enclosing ec = new Enclosing();
		SubInnerClass sic = new SubInnerClass(ec);
		System.out.println(sic.getEX());
	}
}