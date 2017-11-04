import java.io.*;
import java.util.*;
import java.util.concurrent.*;
public class PoolTest{
	private static final int TASK_SLEEP_TIME=2;
	private static final int TASK_MAX_NUMBER=10;

	public static void main(String[] args){
		ThreadPoolExecutor threadpool=new ThreadPoolExecutor(2,4,2,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(3),
			new ThreadPoolExecutor.CallerRunsPolicy());

		for(int i=1;i<=TASK_MAX_NUMBER;i++){
			try{
				String task="任务#"+i;
				System.out.println("往线程池放入任务："+task);
				threadpool.execute(new ThreadPoolTask(task));

				Thread.sleep(TASK_SLEEP_TIME);
				System.out.println("线程池中的线程数:"+threadpool.getActiveCount());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		threadpool.shutdown();
	}
}