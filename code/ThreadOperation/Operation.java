import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class Operation implements Runnable{
	private String atm;
	private CardAccount myCard;
	private int dwCash;
	private ReadWriteLock myLock;
	private int operationType;

	public Operation(String atm,CardAccount myCard,int dwCash,
		ReadWriteLock myLock){
		this.atm=atm;
		this.myCard=myCard;
		this.dwCash=dwCash;
		this.myLock=myLock;
	}

	public Operation(String atm,CardAccount myCard,int dwCash,
		ReadWriteLock myLock,int operationType){
		this.atm=atm;
		this.myCard=myCard;
		this.dwCash=dwCash;
		this.myLock=myLock;
		this.operationType=operationType;
	}

	public void setOperationType(int operationType){
		this.operationType=operationType;
	}

	public int getOperationType(){
		return this.operationType;
	}

	public void run(){
		if(operationType==1){
			myLock.writeLock().lock();
			try{
				System.out.println(atm+"正在往账户"+myCard+"存款,当前金额为："
					+myCard.getBalance()+",存款金额为"+dwCash);
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}

				myCard.setBalance(myCard.getBalance()+dwCash);

				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}

				System.out.println(atm+"往账户"+myCard+"存款成功,操作金额为"
					+dwCash+",当前余额为:"+myCard.getBalance());
			}finally{
				myLock.writeLock().unlock();
			}
		}else if(operationType==2){
			myLock.writeLock().lock();

			try{
				System.out.println(atm+"正在从账户"+myCard+"取款,当前余额为:"
					+myCard.getBalance()+",取款金额为:"+dwCash);

				try{
					Thread.sleep(100);
				}catch(Exception e){
					e.printStackTrace();
				}

				myCard.setBalance(myCard.getBalance()+dwCash);

				try{
					Thread.sleep(100);
				}catch(Exception e){
					e.printStackTrace();
				}

				System.out.println(atm+"从账户"+myCard
					+"取款成功,操作金额为:"+dwCash+",当前余额为:"+myCard.getBalance());
			}finally{
				myLock.writeLock().unlock();
			}
		}else{
			myLock.readLock().lock();

			try{
				System.out.println(atm+"正在查询账户"+myCard+",当前余额为:"
					+myCard.getBalance());

				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}finally{
				myLock.readLock().unlock();
			}
		}
	}
}