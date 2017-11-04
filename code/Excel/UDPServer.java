import java.io.*;
import java.net.*;
public class UDPServer{
	public static void main(String[] args){
		try{
			DatagramSocket ds = new DatagramSocket(10005);
			byte[] rb = new byte[1024];
			DatagramPacket dp = new DatagramPacket(rb, rb.length);
			String rev = "";
			int i=0;
			while(i==0){
				ds.receive(dp);
				i = dp.getLength();
				if(i>0){
					rev = new String(rb, 0, dp.getLength());
					System.out.println(rev);
					i = 0;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}