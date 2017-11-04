public class RetNum{
	public int sum(int a, int b){
		System.out.println("无返回");
		return a + b;
	}
	public static void main(String[] args){
		RetNum r = new RetNum();
		r.sum(2, 3);
	}
}