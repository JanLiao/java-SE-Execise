import java.io.*;
import javax.xml.bind.*;
import java.security.*;
class InstanceCallbackDigest implements Runnable{
	private String filename;
	private InstanceCallbackDigestUserInterface callback;
	public InstanceCallbackDigest(String filename, InstanceCallbackDigestUserInterface callback){
		this.filename = filename;
		this.callback = callback;
	}
	public void run(){
		try{
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read()!=-1) ;
			din.close();
			byte[] digest = sha.digest();
			callback.receiveDigest(digest);
		}catch(IOException e){
			System.err.println(e);
		}catch(NoSuchAlgorithmException e){
			System.err.println(e);
		}
	}
}

public class InstanceCallbackDigestUserInterface{
	private String filename;
	private byte[] digest;
	public InstanceCallbackDigestUserInterface(String filename){
		this.filename = filename;
	}
	public void calculateDigest(){
		InstanceCallbackDigest cd = new InstanceCallbackDigest(filename, this);
		Thread t = new Thread(cd);
		t.start();
	}
	public void receiveDigest(byte[] digest){
		this.digest = digest;
		System.out.println(this);
	}

	public String toString(){
		String result = filename+": ";
		if(digest != null){
			result += DatatypeConverter.printHexBinary(digest);
		}else{
			result += "digest not available";
		}
		return result;
	}
	public static void main(String[] args){
		for(String filename:args){
			InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
			d.calculateDigest();
		}
	}
}