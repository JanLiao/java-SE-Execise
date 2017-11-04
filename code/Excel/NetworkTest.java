import java.net.*;
import java.util.*;
public class NetworkTest{
	public static void main(String[] args){
		try{
			NetworkInterface ni = NetworkInterface.getByName("eth0");
			if(ni == null){
				System.out.println("could not find NetworkInterface!");
			}else{
				System.out.println("NetworkInterface!");
			}
			Enumeration addresses = ni.getInetAddresses();
			while(addresses.hasMoreElements()){
				System.out.println("2222");
				System.out.println(addresses.nextElement());
			}
		}catch(SocketException e){
			System.out.println("ou  no no!");
		}
		try{
			NetworkInterface ni = NetworkInterface.getByName("CE31");
			if(ni == null){
				System.out.println("could not find NetworkInterface!");
			}else{
				System.out.println("NetworkInterface!");
			}
		}catch(SocketException e){
			System.out.println("ou  no no!");
		}
	}
}