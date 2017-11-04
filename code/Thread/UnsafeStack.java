public class UnsafeStack implements StackInterface{
	private int top=0;

	private int[] values=new int[10];

	public void push(int n){
		synchronized(this){

		values[top] =n;
		System.out.println("压入数字"+n+"步骤成功");
		top++;
		System.out.println("压入数字成功");
		}
	}

	public int[] pop(){
		synchronized(this){
			
		System.out.println("弹出");
		top--;
		int[] test={values[top],top};
		return test;
		}
	}
}