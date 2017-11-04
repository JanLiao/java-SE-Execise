public class TestPro extends Thread{
	public TestPro(){

	}

	public TestPro(String name){
		super(name);
	}

	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(this.getName()+"----"+i);
		}
	}

	public static void main(String[] args){
		TestPro tp = new TestPro("Thread one");
		TestPro tp1 = new TestPro("Thread two");
		tp.setPriority(1);
		tp1.setPriority(8);
		tp.start();
		tp1.start();
	}
}