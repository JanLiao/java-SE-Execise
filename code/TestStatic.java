public class TestStatic{
	private  int count=0;
	public TestStatic(){
		count++;
	}
	public  void getCount(){
		System.out.println(count);
	}
	public static void main(String args[]){
		TestStatic test1=new TestStatic();
		test1.getCount();
		TestStatic test2=new TestStatic();
		test2.getCount();
	}
}