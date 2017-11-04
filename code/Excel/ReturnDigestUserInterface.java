import java.io.*;
import java.security.*;
import javax.xml.bind.*;

class ReturnDigest extends Thread{
	private String filename;
	private byte[] digest;
	public ReturnDigest(String filename){
		this.filename = filename;
	}

	public void run(){
		try{
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read()!=-1) ;
			din.close();
			digest = sha.digest();
		}catch(IOException ex){
			System.err.println(ex);
		}catch(NoSuchAlgorithmException ex){
			System.err.println(ex);
		}
	}

	public byte[] getDigest(){
		return digest;
	}
}

public class ReturnDigestUserInterface{
	public static void main(String[] args){

		//有bug  出错
		// for(String filename:args){
		// 	ReturnDigest dr = new ReturnDigest(filename);
		// 	dr.start();
		// 	StringBuilder result = new StringBuilder(filename);
		// 	result.append(": ");
		// 	byte[] digest = dr.getDigest();
		// 	result.append(DatatypeConverter.printHexBinary(digest));
		// 	System.out.println(result);
		// }

		//轮询  主程序一直检查线程执行情况
		ReturnDigest[] digests = new ReturnDigest[args.length];
		for(int i=0;i<args.length;i++){
			digests[i] = new ReturnDigest(args[i]);
			digests[i].start();
		}
		for(int i = 0;i < args.length; i++){
			while(true){
				byte[] digest = digests[i].getDigest();
				if(digest != null){
					StringBuilder result = new StringBuilder(args[i]);
					result.append(": ");
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}

		//回调  让线程告诉主程序何时结束
	}
}