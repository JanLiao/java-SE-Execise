import java.io.*;
public class KeyboardInput{
	public static void main(String[] args){
		String s;

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			while((s=br.readLine())!=null){
				System.out.println("Read:"+s);
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}