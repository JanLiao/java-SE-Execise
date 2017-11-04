import java.io.*;
import java.net.*;
import java.util.*;
public class DaytimeServer{
	public static final int PORT = 13;
	public static void main(String[] args){
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try(Socket con = server.accept()){
					Writer out = new OutputStreamWriter(con.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
					con.close();
				}catch(IOException e){
					System.err.println(e);
				}
			}
		}catch(IOException e){
			System.err.println(e);
		}
	}
}