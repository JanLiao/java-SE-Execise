import java.io.*;
import javax.xml.bind.*;
import java.security.*;

class CallbackDigest implements Runnable{
	private String filename;
	public CallbackDigest(String filename){
		this.filename = filename;
	}

	public void run(){
		try{
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read()!=-1) ;
			din.close();
			byte[] digest = sha.digest();
			CallbackDigestUserInterface.receiveDigest(digest, filename);
		}catch(IOException ex){
			System.out.println(ex);
		}catch(NoSuchAlgorithmException ex){
			System.out.println(ex);
		}
	}
}

public class CallbackDigestUserInterface{
	public static void receiveDigest(byte[] digest, String name){
		StringBuilder result = new StringBuilder(name);
		result.append(": ");
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(result);
	}
	public static void main(String[] args){
		for(String filename : args){
			CallbackDigest cd = new CallbackDigest(filename);
			Thread t = new Thread(cd);
			t.start();
		}
	}
}