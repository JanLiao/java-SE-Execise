
import java.io.*;
import java.net.*;
public class PostTest{
	public static void main(String[] args){
		try{

		URL u = new URL("http://localhost:8080/ITMS/login/reqLogin.do");
//		URL u = new URL("http://localhost:8080/ITMS/front/index.do");
		URLConnection conn = u.openConnection();
		conn.setDoOutput(true);
		OutputStream raw = conn.getOutputStream();
		OutputStream buffered = new BufferedOutputStream(raw);
		OutputStreamWriter out = new OutputStreamWriter(buffered, "utf-8");
		out.write("userAccount=admin&userPassword=1");
		// out.write("\r\n");
		out.flush();
		out.close();
		InputStream in = conn.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(in);
		InputStreamReader isr = new InputStreamReader(bis, "utf-8");
		int c;
		while((c = isr.read()) != -1) System.out.print((char) c);
		isr.close();
		bis.close();
		}catch(Exception e){
			System.err.println(e);
		}
	}
}