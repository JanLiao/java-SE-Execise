public class ThreadPoolTask implements Runnable{
	private String taskName;

	public ThreadPoolTask(String taskName){
		this.taskName=taskName;
	}

	public void run(){
		System.out.println("执行任务::"+taskName);
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}