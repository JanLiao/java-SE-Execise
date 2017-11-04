import java.io.*;
import java.net.*;
public class SocketInfo{
	public static void main(String[] args){
		try{
			Socket s = new Socket("www.orielly.com", 80);
			System.out.println("connected to " + s.getInetAddress() + " on port " + s.getPort() + " from port " + 
				s.getLocalPort() + " of " + s.getLocalAddress());
			s.close();
		}catch(UnknownHostException e){
			System.err.println(e);
		}catch(IOException e){
			System.err.println(e);
		}
	}
}