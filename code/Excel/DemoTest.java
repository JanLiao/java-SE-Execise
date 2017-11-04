import java.io.*;
import java.net.*;

public class DemoTest{
	public static void main(String[] args){
		String target = "";
		for(int i = 0; i < args.length; i++){
			target = target + args[i] + " ";
		}
		target = target.trim();
		QueryString query = new QueryString();
		query.add("q", target);
		System.out.println(query);
		try{
			URL u = new URL("http://www.dmoz.org/search/q?" + query);
			InputStream in = u.openStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String s = null;
			while((s = br.readLine()) != null) System.out.println(s);
			br.close();
			isr.close();
		}catch(MalformedURLException e){
			System.err.println(e);
		}catch(IOException e){
			System.err.println(e);
		}
	}
}