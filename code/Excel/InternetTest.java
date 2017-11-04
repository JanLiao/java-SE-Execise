import java.io.*;
import java.net.*;
import java.util.*;
public class InternetTest{
	public static void main(String[] args){
			try{
		String urls = "http://java.sun.com/index.html";
		Properties prop = System.getProperties();
		prop.put("http.proxyHost", "172.16.0.10");
		prop.put("http.proxyPort", "11080");
		URL url = new URL(urls);
		URLConnection conn = url.openConnection();
		conn.connect();
		System.out.println(conn.getContentLength());
		InputStream is = conn.getInputStream();
		System.out.println("ic:"+is.read());
		is.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}