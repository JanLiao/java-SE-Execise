import java.io.*;
import java.net.*;
public class TClient{
	public static void main(String[] args){
		try{
			Socket sk = new Socket("localhost", 1234);
			OutputStreamWriter osw = new OutputStreamWriter(sk.getOutputStream(), "UTF-8");
			PrintWriter pw = new PrintWriter(osw, true);
			pw.println("hello, 廖晶安");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}