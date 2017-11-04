import java.io.*;
public class AppendFile{
	public static void main(String[] args){
		try{
			int i=0;
			String record=new String();
			String toCn="aaa";
			RandomAccessFile rcf=new RandomAccessFile("C:\\Users\\MrLiao\\Desktop\\a.txt","rw");
			rcf.seek(rcf.length());
			rcf.writeBytes(toCn+"\n");
			rcf.writeBytes("bbbb");
			rcf.close();

			RandomAccessFile rcf1=new RandomAccessFile("C:\\Users\\MrLiao\\Desktop\\a.txt","r");
			String line;
			
			while((line=rcf1.readLine())!=null){
				System.out.println(i+"="+line);
				i++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}