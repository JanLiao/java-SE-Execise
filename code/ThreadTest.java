public class ThreadTest{
	class Bank{

	private Integer account = 0;

	public Integer getAccount(){
		return this.account;
	}

	public synchronized void save(Integer num){
		account+=num;
		System.out.println("current thread operate"+Thread.currentThread().getName()+" "+account);
	}

	public void save1(){
		account++;
		System.out.println("current thread operate"+" "+account);
	}
	}

	class NewThread implements Runnable {
		private Bank bank;

		public NewThread (Bank bank){
			this.bank=bank;
		}

		public void run(){
			for(int i=0;i<10;i++){

			bank.save(10);
			}
			System.out.println("当前账户:"+Thread.currentThread().getName()+":"+bank.getAccount());
		}
	}

	public void useThread(){
		Bank bank=new Bank();
		NewThread tr=new NewThread(bank);
		Thread t1=new Thread(tr);
		t1.setName("线程1");
		Thread t2=new Thread(tr);
		t2.setName("线程2");
		Thread t3=new Thread(tr);
		t3.setName("线程3");
		t1.start();
		t2.start();
		t3.start();
	}

	public static void main(String[] args){
		ThreadTest tt=new ThreadTest();
		tt.useThread();
	}
}