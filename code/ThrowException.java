import java.io.*;
public class ThrowException{
	public void dothing() throws IOException{
		String filename;
		String fName="c:/a.txt";
		File f=new File("c:/a.txt");
		if(!f.exists()){
			filename=f.getName();
			String fileName = fName.substring(fName.lastIndexOf("/")+1); 
			IOException ie=new IOException("file"+fileName+":"+filename+"not found");
			throw ie;
		}
		FileInputStream fis=new FileInputStream(f);
		int b;
		b=fis.read();
		while(b!=-1){
			System.out.println((char)b);
			b=fis.read();
		}
		fis.close();
	}
	public static void main(String[] args){
		ThrowException te=new ThrowException();
		try{
			te.dothing();
		}catch(IOException e){
			System.out.println("111"+e.getMessage());
		}
	}
}