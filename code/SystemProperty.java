import java.util.Properties;
public class SystemProperty{
	public static void main(String[] args){
		Properties pro = System.getProperties();
		Properties pro1 = new Properties();
		System.out.println(pro1.getProperty("user.name"));
		System.out.println(pro.getProperty("java.version"));
		System.out.println(pro.getProperty("user.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(pro.getProperty("user.home"));
		System.out.println(pro.getProperty("user.dir"));
		System.out.println(pro.getProperty("os.name"));
		System.out.println(pro.getProperty("os.version"));
		System.out.println(pro.getProperty("java.vendor"));
		System.out.println(pro.getProperty("java.vendor.url"));
		System.out.println(pro.getProperty("file.separator"));
	}
}