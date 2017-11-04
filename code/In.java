public class In{
	public static void main(String[] args){
		try{
			int code = System.in.read();
			int code1 = System.in.read();
			//String s = System.in.read();
			System.out.println(code);
			System.out.println(code1);
			//System.out.println(s);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}