import java.util.Properties;
import java.io.*;
public class PropertyManager{
	Properties pro = null;
	public PropertyManager(){
		pro = new Properties();
		loadFile();
	}
	public void loadFile(){
		try{

		FileReader fileReader = new FileReader("C:/Users/MrLiao/Desktop/code/property.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		pro.load(bufferedReader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void printInfo(){
		System.out.println(pro.getProperty("title"));
		System.out.println(pro.getProperty("name"));
	}
	public static void main(String[] args){
		PropertyManager pm = new PropertyManager();
		pm.printInfo();
	}
}