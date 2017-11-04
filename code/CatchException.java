import java.io.*;
public class CatchException{
	public static void main(String[] arrgs){
		try{
			FileInputStream fis=new FileInputStream("C:/Users/MrLiao/Desktop/code/a.txt");
			int b;
			b=fis.read();
			while(b!=-1){
				System.out.println((char)b);
				b=fis.read();
			}
			fis.close();
		}catch(FileNotFoundException e1){
			System.out.println("111"+e1.getMessage());
		}
		catch(IOException e){
			System.out.println("888"+e.getMessage());
		}

	}
}