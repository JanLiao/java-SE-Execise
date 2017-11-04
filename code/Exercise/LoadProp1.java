import java.io.IOException;
import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;
public class LoadProp1{
	public static void main(String[] args){
		LoadProp1 loadProp = new LoadProp1();
        Properties prop = new Properties();
        try {  
            prop.load(new FileInputStream("terminal.properties"));  
              
            System.out.println(prop.getProperty("connectPassword"));  
            System.out.println(prop.getProperty("SerialNumber"));  
            System.out.println(prop.getProperty("dbpassword"));  
        } catch(IOException e) {  
            e.printStackTrace();  
        }

        int a = 11;
        int b = 11;
        int c = a^b;
        System.out.println(c);

	}
}