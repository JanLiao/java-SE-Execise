import java.io.*;
public class WritePerson{
	public static void main(String[] args){
		try{
			File f=new File("C:\\Users\\MrLiao\\Desktop\\a.tmp");
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
            Persons p=new Persons("Jan",25,"man","han");
            System.out.println("将Persons对象写入文件a.txt中......");
            oos.writeObject(p);
            oos.close();
            System.out.println("完成");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}