import java.io.*;
import java.net.*;
public class TestInputStream{
	public static void main(String[] args){
		try{
			URL url = new URL("http://www.baidu.com");
			InputStream in = url.openStream();
			int c;
			while((c = in.read()) != -1) System.out.write(c);
			in.close();
		}catch(IOException e){
			System.err.println(e);
		}

		try{
			URL u = new URL("http://www.baidu.com");
			InputStream in2 = u.openStream();
			in2 = new BufferedInputStream(in2);
			InputStreamReader isr1 = new InputStreamReader(in2, "utf-8");
			int c1;
			while((c1 = isr1.read()) != -1) System.out.write((char) c1);
			in2.close();
		}catch(IOException e){
			System.err.println(e);
		}

		try{
			URL urla = new URL("http://www.baidu.com");
			InputStream in1 = urla.openStream();
			InputStreamReader isr = new InputStreamReader(in1, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String s = null;
			while((s = br.readLine()) != null)  System.out.println(s);
//			int c;
//			while((c = in.read()) != -1) System.out.write(c);
			in1.close();
			isr.close();
			br.close();
		}catch(IOException e){
			System.err.println(e);
		}
	}
}