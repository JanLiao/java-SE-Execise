import java.io.*;
import java.net.*;
public class Server{
	public static void main(String[] args){
		try{
			ServerSocket server = new ServerSocket(1234);
			Socket sk = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			System.out.println(br.readLine());
			br.close();
			server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}