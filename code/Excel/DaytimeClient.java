import java.io.*;
import java.net.*;
public class DaytimeClient{
	public static void main(String[] args){
		Socket socket = null;
		try{
			socket = new Socket("time.nist.gov", 13);
			socket.setSoTimeout(15000);
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			for(int c = isr.read(); c != -1; c = isr.read()){
				time.append((char)c);
			}
			System.out.println(time);
		}catch(IOException e){
			System.err.println(e);
		}finally{
			if(socket != null){
				try{
					socket.close();
				}catch(IOException e){
					System.err.println(e);
				}
			}
		}
	}
}