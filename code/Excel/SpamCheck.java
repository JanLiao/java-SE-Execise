import java.io.*;
import java.net.*;
public class SpamCheck{
	private static final String BLACKHOLE = "sbl.spamhaus.org";
	public static void main(String[] args) throws UnknownHostException{
		for(String s:args){
			if(isSpam(s)){
				System.out.println(s + " is a Spam!!");
			}else{
				System.out.println(s + " is not Spam!!");
			}
		}
	}
	public static boolean isSpam(String str){
		try{
			InetAddress address = InetAddress.getByName(str);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for(byte b:quad){
				int unsignedByte = b < 0 ? b+256 : b;
				query = unsignedByte + "." + query;
			}
			System.out.println(query);
			InetAddress add = InetAddress.getByName(query);
			System.out.println(add);
			return true;
		}catch(UnknownHostException e){
			System.out.println("sorry");
			return false;
		}
	}
}