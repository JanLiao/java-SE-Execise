import java.io.*;
import java.net.*;
import java.util.*;
public class TimeServer{
	public static final int PORT = 1314;
	public static void main(String[] args){
		long differenceBetweenEpochs = 2208988800L;
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try(Socket con = server.accept()){
					OutputStream out = con.getOutputStream();
					Date now = new Date();
					long msSince1970 = now.getTime();
					System.out.println("msSince1970=" + msSince1970);
					long secondsSince1970 = msSince1970/1000;
					long secondsSince1900 = secondsSince1970 + differenceBetweenEpochs;
					byte[] time = new byte[4];
					time[0] = (byte) ((secondsSince1900 & 0x00000000FF000000L) >> 24);
					time[1] = (byte) ((secondsSince1900 & 0x0000000000FF0000L) >> 16);
					time[2] = (byte) ((secondsSince1900 & 0x000000000000FF00L) >> 8);
					time[3] = (byte) ((secondsSince1900 & 0x00000000000000FFL));
					out.write(time);
					out.flush();
				}catch(IOException e){
					System.err.println(e);
				}
			}
		}catch(IOException e){
			System.err.println(e);
		}
	}
}