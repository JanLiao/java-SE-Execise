import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;
import java.io.*;

public class Myclient{
	public static final String IP="192.168.2.11";
	public static final int port=8899;
	private Socket s;

	public Myclient() throws IOException{
		try{
			s=new Socket("127.0.0.1",8899);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void setConnection()throws IOException{
		InputStream is;
		try{
			System.out.println(s);
			is=s.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println(br.readLine());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		
		try{
			Myclient ms=new Myclient();
			ms.setConnection();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}