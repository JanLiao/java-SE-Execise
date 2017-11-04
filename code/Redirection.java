import java.io.*;
public class Redirection{
	public static void main(String[] args){
		FileOutputStream fos=null;
		PrintStream ps=null;
		try{
			fos=new FileOutputStream("C:\\Users\\MrLiao\\Desktop\\a.txt",true);
			ps=new PrintStream(fos);
			System.setOut(ps);
			System.out.println("\n"+"this string will be written into   " +"the a.txt");

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fos.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}