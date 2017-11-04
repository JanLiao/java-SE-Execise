import java.io.*;
import java.net.*;
public class TServer{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1234);
			Socket s = ss.accept();
			System.out.println("connection success");
			InputStreamReader isr = new InputStreamReader(s.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String msg = br.readLine();
			System.out.println("------- "+msg);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}