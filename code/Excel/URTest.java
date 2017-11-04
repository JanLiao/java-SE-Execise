import java.io.*;
import java.net.*;
public class URTest{
	public static void main(String[] args){
		try{
			URL u = new URL("http://www.baidu.com/s?wd=%E6%88%91%E8%AF%95%E8%AF%95&rsv_spt=1&rsv_iqid=0x8c0d73870004305d&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=4&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=3430&rsv_sug4=72026");
			InputStream in = new BufferedInputStream(u.openStream());
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			FileOutputStream fos = new FileOutputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\c.txt");
			BufferedOutputStream bw = new BufferedOutputStream(fos);
			int c;
			while((c = in.read()) != -1){
				fos.write((char)c);
			}
			bw.close();
			fos.close();
			isr.close();
			in.close();
		}catch(MalformedURLException e){
			System.err.println(e);
		}catch(IOException e){
			System.err.println(e);
		}
	}
}