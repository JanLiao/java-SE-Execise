public class SafeStack implements StackInterface{
	private int top=0;

	private int[] values=new int[10];

	private boolean dataAvailable=false;

	public void push(int n){
		synchronized(this){
			while(dataAvailable){
				try{
					wait();
				}catch(Exception e){
					e.printStackTrace();
				}
			}

			values[top]=n;
			System.out.println("压入数字"+n+"步骤1完成");
			top++;
			dataAvailable=true;
			notifyAll();
			System.out.println("压入数字完成");
		}
	}

	public int[] pop(){
		synchronized(this){
			while(!dataAvailable){
				try{
					wait();
				}catch(Exception e){
					e.printStackTrace();
				}
			}

			System.out.println("弹出");
			top--;
			int[] test={values[top],top};
			dataAvailable=false;
			notifyAll();
			return test;
		}
	}
}