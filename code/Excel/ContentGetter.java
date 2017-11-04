import java.io.*;
import java.net.*;
public class ContentGetter{
	public static void main(String[] args){

		Class<?>[] types = new Class[3];
		for(Class c:types){
			System.out.println(c);
		}
		types[0] = String.class;
		types[1] = Reader.class;
		types[2] = InputStream.class;
		for(Class c:types){
			System.out.println(c);
		}


		try{
			URL url = new URL(args[0]);
			System.out.println("port is =" + url.getPort());
			System.out.println("port is =" + url.getDefaultPort());
			System.out.println("port is =" + url.getFile());
			System.out.println("port is =" + url.getPath());
			Object o = url.getContent();
			System.out.println("I got a "+o.getClass().getName());
		}catch(MalformedURLException e){
			System.err.println(args[0] + "is not a parseable URL");
		}catch(IOException e){
			System.err.println(e);
		}
	}
}