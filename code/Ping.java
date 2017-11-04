import java.net.*;
import java.io.*;
public class Ping{
	public static void main(String[] args){
		InetAddress ia;
		String localname;
		String localip;
		try{

		if(args.length<1){
			ia=InetAddress.getLocalHost();
			localname=ia.getHostName();
			localip=ia.getHostAddress();
		}else {
			ia=InetAddress.getByName(args[0]);
			localname=ia.getHostName();
			localip=ia.getHostAddress();
		}
			System.out.println("ip="+ia);
			System.out.println("ipname="+localname);
			System.out.println("ipaddress="+localip);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}