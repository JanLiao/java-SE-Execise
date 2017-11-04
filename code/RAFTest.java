import java.io.*;
public class RAFTest{
	public void read() throws Exception{
		RandomAccessFile acf = new RandomAccessFile("C:/Users/MrLiao/Desktop/林炯-统计/a.txt","rw");
		acf.seek(1);
		System.out.println((char)acf.read());
		System.out.println((char)acf.read());
		System.out.println((char)acf.read());
		System.out.println((char)acf.read());
		System.out.println((char)acf.read());
		System.out.println((char)acf.read());
		System.out.println((char)acf.read());
		System.out.println((char)acf.read());
		acf.close();		
	}
	public static void main(String[] args){
        RAFTest aa = new RAFTest();
        try{
           aa.read();
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}