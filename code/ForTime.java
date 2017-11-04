public class ForTime{
	public static void main(String[] args){
		long sum = 0;
		long startTime,endTime;
		long startTime1,endTime1;
		startTime = System.currentTimeMillis();
		startTime1 = System.nanoTime();
		for(int i = 0;i <1000000000;i++){
			sum+=i;
		}
		System.out.println(sum);
		endTime = System.currentTimeMillis();
		endTime1 = System.nanoTime();
		System.out.println((endTime-startTime));
		System.out.println((endTime1-startTime1));
	}
}