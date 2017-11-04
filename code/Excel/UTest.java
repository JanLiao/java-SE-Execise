import java.io.*;
import java.net.*;

public class UTest{
	public static void main(String[] args){
		try{
			URL u = new URL("http://www.baidu.com/");
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

		System.out.println("----------------");

		try{
			URL u1 = new URL("http://www.baidu.com/");
			InputStream in1 = u1.openStream();
//			BufferedInputStream bis = new BufferedInputStream(in1);
			InputStreamReader isr1 = new InputStreamReader(in1, "utf-8");
			int c;
			while((c = isr1.read()) != -1) System.out.print((char)c);
//			bis.close();
			isr1.close();
			in1.close();
		}catch(MalformedURLException e){
			System.err.println(e);
		}catch(IOException e){
			System.err.println(e);
		}

		try{
			URL u2 = new URL("http://www.baidu.com/");
			InputStream in2 = u2.openStream();
			BufferedInputStream bis1 = new BufferedInputStream(in2);
			InputStreamReader isr2 = new InputStreamReader(bis1, "utf-8");
			int c1;
			while((c1 = isr2.read()) != -1) System.out.print((char)c1);
			bis1.close();
			isr2.close();
			in2.close();
		}catch(MalformedURLException e){
			System.err.println(e);
		}catch(IOException e){
			System.err.println(e);
		}

		System.out.println("===============");

		try{
			FileInputStream fis = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			InputStreamReader isr3 = new InputStreamReader(fis, "utf-8");
			int k;
			while((k = isr3.read()) != -1) System.out.print((char)k);
			isr3.close();
			fis.close();
		}catch(IOException e){
			System.err.println(e);
		}
		System.out.println("===============");

		try{
			FileInputStream fis1 = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			BufferedInputStream bis2 = new BufferedInputStream(fis1);
			InputStreamReader isr4 = new InputStreamReader(bis2, "utf-8");
			int kk;
			while((kk = isr4.read()) != -1) System.out.print((char)kk);
			bis2.close();
			isr4.close();
			fis1.close();
		}catch(IOException e){
			System.err.println(e);
		}

		System.out.println("-------------------------");

		try{
			String str = "hello";
			System.out.println(Integer.parseInt(str));
		}catch(Exception e){
			System.err.println(e);
			System.out.println("==================");
			e.printStackTrace();
		}
	}
}