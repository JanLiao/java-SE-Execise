import java.util.*;
import java.io.*;
public class ReadPro{
	private String jdbc_name,jdbc_user,jdbc_pwd,jdbc_url,file_path,virtual_path;
	public ReadPro(){
		try{
			Properties props=new Properties();
			File f=new File("C:/Users/MrLiao/Desktop/code/jdbc.properties");
			FileInputStream in=new FileInputStream(f);
			props.load(in);
			in.close();
			System.out.println(props);
			jdbc_name=props.getProperty("jdbc_name");
			jdbc_user=props.getProperty("jdbc_user");
			jdbc_pwd=props.getProperty("jdbc_pwd");
			jdbc_url=props.getProperty("jdbc_url");
			file_path=props.getProperty("file_path");
			virtual_path=props.getProperty("virtual_path");
		}catch(IOException e){
			System.out.println(e);
		}
	}

	public String getJdbc_name(){
		return this.jdbc_name;
	}

	public String getJdbc_user(){
		return this.jdbc_user;
	}

	public String getJdbc_pwd(){
		return this.jdbc_pwd;
	}

	public String getJdbc_url(){
		return this.jdbc_url;
	}

	public String getFile_path(){
		return this.file_path;
	}

	public String getVirtual_path(){
		return this.virtual_path;
	}

	public static void main(String[] args){
		ReadPro rp=new ReadPro();
		System.out.println(rp.getJdbc_user());
		System.out.println(rp.getJdbc_name());
		System.out.println(rp.getJdbc_pwd());
		System.out.println(rp.getJdbc_url());
		System.out.println(rp.getFile_path());
		System.out.println(rp.getVirtual_path());
	
	}
}