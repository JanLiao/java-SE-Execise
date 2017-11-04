import java.io.*;
import java.net.*;
public class UDPClient{
	public static void main(String[] args){
		try{
			DatagramSocket ds = new DatagramSocket(10002);
			byte[] sb = new byte[1024];
			String send = "UDP方式发送数据";
			sb = send.getBytes();
			DatagramPacket pac = new DatagramPacket(sb, sb.length, InetAddress.getByName("localhost"), 10005);
			ds.send(pac);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}