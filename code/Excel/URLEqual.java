import java.io.*;
import java.net.*;
public class URLEqual{
	public static void main(String[] args){
		try{
			URL www = new URL("http://www.ibiblio.org/");
			URL bai = new URL("http://ibiblio.org/");
			URL u = new URL("http://www.cafeaulait.org/javatutorial.html");
			System.out.println(u);
			System.out.println(u.toString());
			System.out.println(u.toExternalForm());
			if(www.equals(bai)){
				System.out.println(www + " is the same as " + bai);
			}else{
				System.out.println(www + " is not same as " + bai);
			}
		}catch(MalformedURLException e){
			System.err.println(e);
		}
	}
}