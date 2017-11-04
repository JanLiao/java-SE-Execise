import java.io.*;
import java.net.*;
public class Server{
	public static void main(String[] args){
		ServerSocket server;
		InetAddress ip;
		try{
			server=new ServerSocket(1234);
			Socket sk=server.accept();
			ip=sk.getInetAddress();
            String ipName=ip.getHostName();

			

			BufferedReader br=new BufferedReader(new InputStreamReader(sk.getInputStream()));
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(ip);
			System.out.println(ipName);
			br.close();
			server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}