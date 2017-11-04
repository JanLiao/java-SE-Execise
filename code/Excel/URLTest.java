import java.io.*;
import java.net.*;
import java.net.URL;
public class URLTest{
	public static void main(String[] args){
		try{
			URL url = new URL("http://gpxz.com/live/UploadFile/2008-8/2008841357126734.mp3");
			URLConnection conn = url.openConnection();
			conn.connect();
			System.out.println(conn.getContentLength());
			System.out.println(conn.getContentType());
			System.out.println(conn.getContentEncoding());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}