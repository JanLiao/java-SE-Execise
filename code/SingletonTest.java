public class SingletonTest{

	

	public void getInstanceOf(){
		Singleton instance = Singleton.instanceOf();
		Singleton instance1 = Singleton.instanceOf();
		Singleton instance2 = Singleton.instanceOf();
		System.out.println(instance);
		if(instance1 == instance2){
			System.out.println("==");
		}else{
			System.out.println("!=");
		}
		System.out.println();
	}
	public static void main(String[] args){
		SingletonTest st=new SingletonTest();
		st.getInstanceOf();
	}
}
class Singleton{
		private Singleton(){
			System.out.println("ss");
		}

		private static  Singleton s=new Singleton();

		public static Singleton instanceOf(){
			return s;
		}
	}