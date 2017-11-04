import java.io.*;
import java.net.*;
public class EncodingTest{
	public static void main(String[] args){
		try{
			String encoding = "utf-8";
		    URL url = new URL("http://www.baidu.com/");
		    URLConnection connection = url.openConnection();
		    String type = connection.getHeaderField("content-type");
		    System.out.println(type);
		    for(int i = 1; i <= 6; i++){
		    	String s = connection.getHeaderField(1);
		        System.out.println(s);
		    }
		    System.out.println("-------------------------");
		    String contentType = connection.getContentType();
		    System.out.println("contentType=" + contentType);
		    int contentLength = connection.getContentLength();
		    System.out.print("length=");
		    System.out.println(contentLength);
		    String contentEncoding = connection.getContentEncoding();
		    System.out.println("contentEncoding=" + contentEncoding);
		    int encodingStart = contentType.indexOf("charset=");
		    if(encodingStart != -1){
		    	encoding = contentType.substring(encodingStart + 8);
		    }
		    System.out.println("编码=" + encoding);
		    InputStream in = new BufferedInputStream(connection.getInputStream());
		    InputStreamReader isr = new InputStreamReader(in, encoding);
		    int c;
		    while((c = isr.read()) != -1) System.out.print((char) c);
		    isr.close();
		}catch(MalformedURLException e){
			System.err.println(e);
		}catch(IOException e){
			System.err.println(e);
		}
	}
}