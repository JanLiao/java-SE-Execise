import java.io.*;
public class UnsafeOperation implements Runnable{
	private String atm;
	private CardAccount myCard;
	private int ioCash;

	public UnsafeOperation(String atm,CardAccount myCard,int ioCash){
		this.atm=atm;
		this.myCard=myCard;
		this.ioCash=ioCash;
	}

	public void run(){
		System.out.println(atm+"正在操作账户:"+myCard+",金额为"+ioCash
			+",当前金额为"+myCard.getBalance());

		try{
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}

		myCard.setBalance(myCard.getBalance()+ioCash);

		try{
			Thread.sleep(500);
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println(atm+"操作账户:"+myCard+"成功，操作金额为"+ioCash
			+",当前金额为"+myCard.getBalance());
	}
}