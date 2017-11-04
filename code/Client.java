import java.io.*;
import java.net.*;
public class Client{
	public static void main(String[] args){
		Socket client;
		PrintStream ps;
		InetAddress ip;
		try{
			client=new Socket("localhost",1234);
			ip=InetAddress.getByName("localhost");
			System.out.println("连接成功");
			System.out.println(ip);
			ps=new PrintStream(client.getOutputStream());
			ps.println("Hello \n calnima \n ai");
			ps.println("caonima");
			ps.close();
			client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}