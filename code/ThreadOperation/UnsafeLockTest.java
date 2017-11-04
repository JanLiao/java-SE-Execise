public class UnsafeLockTest{
	public static void main(String[] args){
		CardAccount myCard=new CardAccount("boc-010-080-1234",0);
		UnsafeOperation o1=new UnsafeOperation("atm001",myCard,-4000);
		UnsafeOperation o2=new UnsafeOperation("atm002",myCard,6000);
		UnsafeOperation o3=new UnsafeOperation("atm003",myCard,-8000);
		UnsafeOperation o4=new UnsafeOperation("atm004",myCard,800);
		Thread t1=new Thread(o1);
		Thread t2=new Thread(o2);
		Thread t3=new Thread(o3);
		Thread t4=new Thread(o4);
		t3.start();
		t1.start();
		t2.start();
		t4.start();
	}
}