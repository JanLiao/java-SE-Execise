import java.io.*;
import java.net.*;
public class Client{
	public static void main(String[] args){
		try{
			Socket client = new Socket("localhost", 1234);
			System.out.println("connection success!");
			PrintStream ps = new PrintStream(client.getOutputStream());
			ps.println("你好吗");
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}