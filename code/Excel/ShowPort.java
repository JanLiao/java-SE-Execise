import java.io.*;
import java.net.*;
public class ShowPort {
	public static void main(String[] args){
		for(int i = 0; i < 1024; i++){
			try{
				Socket s = new Socket("localhost", i);
				System.out.println("There is a server on port " + i + "of" + " localhost");
				s.close();
			}catch(UnknownHostException e){
//				System.err.println(e);
				break;
			}catch(IOException e){
//				System.err.println(e);
			}
		}
	}
}