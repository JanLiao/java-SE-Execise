import java.io.*;
import java.net.*;
class DownThread implements Runnable{
	String url = "";
	File file;
	long startPosition;
	long endPosition;
	public DownThread(String url, File file, long startPosition, long endPosition){
		this.url = url;
		this.file = file;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}
	public void run(){
		try{
			URL downUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)downUrl.openConnection();
			conn.setRequestProperty("User-Agent", "NetFox");
			String sProperty = "bytes="+startPosition+"-";
			if(endPosition>0){
				sProperty+=endPosition;
			}
			conn.setRequestProperty("RANGE", sProperty);
			System.out.println(sProperty);
			RandomAccessFile dst = new RandomAccessFile(file, "rw");
			dst.seek(startPosition);
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buf = new byte[1024];
			long size = -1;
			while((size=bis.read(buf))>0){
				dst.write(buf, 0, (int)size);
			}
			dst.close();
			bis.close();
			conn.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("一个线程结束");
	}
}

public class MultiDownload{
	public static void main(String[] args){
		MultiDownload md = new MultiDownload();
		try{
			md.downProcess("http://www.baidu.com/img/teacher_pc_8fa12bc0f7f102be0395c901ca11298f.gif", "D:\\internet\\logo1.gif", 3);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void downProcess(String url, String dest, int threadNum) throws Exception{
		long fileSize = getFileLength(url);
		long byteCount = fileSize/threadNum +1;
		File f = new File(dest);
		if(!f.exists()){
			f.createNewFile();
		}
		int i = 0;
		while(i<threadNum){
			final long startPosition = byteCount*i;
			final long endPosition = byteCount*(i+1);
			if(i==threadNum-1){
				DownThread fileDown = new DownThread(url, f, startPosition, 0);
				new Thread(fileDown).start();
			}else{
				DownThread fileDown = new DownThread(url, f, startPosition, endPosition);
				new Thread(fileDown).start();
			}
			i++;
		}
	}
	public long getFileLength(String url) throws Exception{
		URL dURL = new URL(url);
		HttpURLConnection con = (HttpURLConnection)dURL.openConnection();
		long size = -1;
		int stateCode = con.getResponseCode();
		if(stateCode==200){
			size = con.getContentLength();
			con.disconnect();
		}
		return size;
	}
}