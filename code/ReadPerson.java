import java.io.*;
public class ReadPerson{
	public static void main(String[] args){
		Persons p=null;
		try{
			File f=new File("C:\\Users\\MrLiao\\Desktop\\a.tmp");
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			p=(Persons)ois.readObject();
			System.out.println(p);
			System.out.println(p.getNation());
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}