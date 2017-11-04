import java.io.*;
import java.util.*;
public class TestWrite{
	public static void main(String[] args){
		TestWrite tw = new TestWrite();
		try{
			tw.write();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			tw.read();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void write() throws Exception{
		FileOutputStream fos = new FileOutputStream("C:\\Users\\MrLiao\\Desktop\\林炯-统计\\c.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject("撒奥数");
		oos.writeObject(new Date());
		oos.flush();
	}
	public void read() throws Exception{
		FileInputStream fis = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\林炯-统计\\c.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		String tt = (String)ois.readObject();
		Date dd = (Date)ois.readObject();
		System.out.println("---"+tt);
		System.out.println("---"+dd);
	}
}