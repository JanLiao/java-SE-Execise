import java.io.*;
import java.net.*;

public class FormPost{
	private URL url;
	private QueryString query = new QueryString();
	public FormPost(URL url){
		if(!url.getProtocol().toLowerCase().startsWith("http")){
			throw new IllegalArgumentException(
				"Posting only works for http URLs");
		}
		this.url = url;
	}

	public void add(String name, String value){
		query.add(name, value);
	}

	public URL getURL(){
		return this.url;
	}

	public InputStream post() throws IOException{
		URLConnection uc = url.openConnection();
		uc.setDoOutput(true);
		try(OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream(), "utf-8")){
			System.out.println(query.toString());
			System.out.println("wd=" + URLEncoder.encode("丁丁","UTF-8"));
			out.write("wd=" + URLEncoder.encode("丁丁","UTF-8"));
			out.write("\r");
			out.write("\n");
		}

		return uc.getInputStream();
	}

	public static void main(String[] args){
		URL url;
		try{
			url = new URL("http://www.baidu.com/s");
		}catch(MalformedURLException e){
			System.err.println(e);
			return ;
		}

		FormPost poster = new FormPost(url);
		poster.add("wd", "卡卡");

		try(InputStream in = poster.post()){
			Reader r = new InputStreamReader(in, "utf-8");
			FileOutputStream fos = new FileOutputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\d.txt");
			BufferedOutputStream bw = new BufferedOutputStream(fos);
			int c;
			int d;
			while((d = in.read()) !=-1){
				bw.write((char)d);
			}
			// while((c = r.read()) != -1){
			// 	System.out.print((char)c);
			// }
			System.out.println();
			bw.close();
			fos.close();
		}catch(IOException e){
			System.err.println(e);
		}
	}
}