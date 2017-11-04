import java.net.*;
import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
public class Myserver{
	private ServerSocket ss;
	public static final int port=8899;
	public Myserver(){
		try{
			ss=new ServerSocket(port);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
		public void setConnection()throws IOException{
			Socket s;
			OutputStream os;
			try{
				s=ss.accept();
				os=s.getOutputStream();
				os.write("Hello".getBytes());
				os.close();
				s.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	public  static void main(String args[]){
		Myserver ms=new Myserver();
		try{
		ms.setConnection();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
}