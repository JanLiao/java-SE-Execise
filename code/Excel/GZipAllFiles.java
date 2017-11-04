import java.io.*;
import java.util.zip.*;
import java.util.concurrent.*;
class GZipRunnable implements Runnable{
	private final File input;
	public GZipRunnable(File input){
		this.input = input;
	}

	public void run(){
		if(!input.getName().endsWith(".gz")){
			File output = new File(input.getParent(), input.getName()+".gz");
			if(!output.exists()){
				try(
					InputStream in = new BufferedInputStream(new FileInputStream(input));
				OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)))
				){
					int b;
					while((b = in.read())!= -1)  out.write(b);
					out.flush();
				}catch(IOException e){
					System.err.println(e);
				}
			}
		}
	}
}

public class GZipAllFiles{
	public final static int THREAD_COUNT = 4;
	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		for(String filename:args){
			File f = new File(filename);
			if(f.exists()){
				if(f.isDirectory()){
					File[] files = f.listFiles();
					for(int i = 0; i < files.length; i++){
						if(!files[i].isDirectory()){
							Runnable task = new GZipRunnable(files[i]);
							pool.submit(task);
						}
					}
				}else{
					Runnable task = new GZipRunnable(f);
					pool.submit(task);
				}
			}
		}
		pool.shutdown();
	}
}