public class Acount{
	private int count=100;
	public  Acount  createAcount(){
		count+=1;
		return this;
	}
	public int  getAcount(){
		return count;
	}
	public static void main(String args[]){
		Acount a=new Acount();
		System.out.println(a.createAcount().createAcount().getAcount());
	}
}