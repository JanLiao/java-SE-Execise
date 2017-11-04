import java.io.*;
import java.net.*;
public class DownLoad{
	private long start = 0;
	private long end = 0;
	public DownLoad(long start, long end){
		this.start = start;
		this.end = end;
	}
	public DownLoad(long start){
		this.start = start;
	}
	public void down(){
		try{
			URL url = new URL("http://www.oracle.com/technetwork/java/index.html");
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent", "NetFox");
			String sProperty = "bytes="+start+"-";
			if(end>0){
				sProperty = "bytes="+start+"-"+end;
			}
			conn.setRequestProperty("RANGE", sProperty);
			conn.connect();
			InputStream is = conn.getInputStream();
			String file = url.getFile();
			System.out.println("file="+file);
			String name = file.substring(file.lastIndexOf("/")+1);
			System.out.println("name="+name);
			File f = new File("D:\\aa\\"+name);
			if(!f.exists()){
				f.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream("D:\\aa\\"+name, true);
			byte[] buf = new byte[1024];
			int size = -1;
			while((size = is.read(buf))!=-1){
				fos.write(buf, 0, size);
			}
			fos.close();
			is.close();
			conn.connect();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		DownLoad d1 = new DownLoad(1000, 20000);
		d1.down();
		// DownLoad d2 = new DownLoad(2000);
		// d2.down();
	}
}