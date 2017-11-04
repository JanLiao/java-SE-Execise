public class Equals2{
	private int i =0;
	public Equals2(){

	}
	public void show(){
		System.out.println("111333");
	}

	public static void main(String[] args){
		Equals2 e1 = new Equals2();
		Equals2 e2 = new Equals2();
		Equals2 e3 = e1;
		if(e1.equals(e2)){
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}

		if(e1.equals(e3)){
			System.out.println("相等");
		}else {
			System.out.println("不相等");
		}
	}
}