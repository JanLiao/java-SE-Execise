import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class LockTest{
	public static void main(String[] args){
		CardAccount myCard=new CardAccount("boc-010-080-1234",0);

		ReadWriteLock lock=new ReentrantReadWriteLock();

		ExecutorService pool=Executors.newCachedThreadPool();

		Operation o1=new Operation("atm001",myCard,-4000,lock,2);
		Operation o2=new Operation("atm002",myCard,6000,lock,1);
		Operation o3=new Operation("atm003",myCard,-8000,lock,2);
		Operation o4=new Operation("atm004",myCard,800,lock,1);

		pool.execute(o1);
		pool.execute(o2);
		pool.execute(o3);
		pool.execute(o4);

		pool.shutdown();
	}
}