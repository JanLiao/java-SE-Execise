import java.io.*;
import java.net.*;
public class OReillyByName{
	public static void main(String[] args){
		try{
			InetAddress address = InetAddress.getByName("www.oreilly.com");
			System.out.println(address);
			String s1 = address.getHostName();
			System.out.println(s1);
			String s2 = address.getCanonicalHostName();
			System.out.println(s2);
			byte[] s3 = address.getAddress();
			System.out.println(s3);
			System.out.println(s3.length);
			for(byte b:s3){
				System.out.println(b);
			}
			String s4 = address.getHostAddress();
			System.out.println(s4);
		}catch(UnknownHostException e){
			System.out.println("could not find www.oreilly.com");
		}

		try{
			InetAddress[] add = InetAddress.getAllByName("www.oreilly.com");
			for(InetAddress s: add){
				System.out.println(s);
			}
			System.out.println(add.length);
		}catch(UnknownHostException e){
			System.out.println("could not find!");
		}

		try{
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println(addr);
		}catch(UnknownHostException e){
			System.out.println("could not find localhost");
		}

		try{
			InetAddress aa = InetAddress.getByName("23.222.210.11");
			System.out.println(aa.getHostName());
			System.out.println(aa.getCanonicalHostName());
		}catch(UnknownHostException e){
			System.out.println("could not find 208");
		}

	}
}