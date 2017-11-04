import java.util.concurrent.*;
class FindMaxTask implements Callable<Integer>{
	private int[] data;
	private int start;
	private int end;

	FindMaxTask(int[] data, int start, int end){
		this.data = data;
		this.start = start;
		this.end = end;
	}

	public Integer call(){
		int max = Integer.MIN_VALUE;
		for(int i=start; i<end; i++){
			if(data[i]>max)  max = data[i];
		}
		return max;
	}
}

public class MultithreadedMaxFinder{
	public static int max(int[] data) throws Exception{
		if(data.length == 1){
			return data[0];
		}else if(data.length == 0){
			throw new IllegalArgumentException();
		}

		FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
		FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
		System.out.println(future1.get());
		System.out.println(future2.get());

		return Math.max(future1.get(), future2.get());
	}

	public static void main(String[] args){
		int[] data = new int[]{2,33,4,55,6,77,8,9,2,12,11,22,78,99,24,56};
		try{
			int max = MultithreadedMaxFinder.max(data);
			System.out.println(max);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}