import java.io.IOException;  
  
　　import java.io.InputStream;  
  
　　import java.util.Properties;  
  
　　public class LoadProp {  
  
　　public static void main(String[] args) {  
  
　　LoadProp loadProp = new LoadProp();  
  
　　InputStream in = loadProp.getClass().getClassLoader().getResourceAsStream("C:\\Users\\MrLiao\\Desktop\\structs导入jar包\\获取视频时长\\src\main\resources\\terminal.properties"); 
  
　　Properties prop = new Properties();  
  
　　try {  
  
　　prop.load(in);
  
　　} catch (IOException e) {  
  
　　e.printStackTrace(); 
  
　　}  
  
　　System.out.println(prop.getProperty("connectPassword", "none"));
  
　　System.out.println(prop.getProperty("SerialNumber", "none"));
  
　　}  
  
　　}  