import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class PooledDaytimeServer{
	public final static int PORT = 1314;
	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(50);
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true){
				try{
					Socket con = server.accept();
					Callable<void> task = new DaytimeTask(con);
					pool.submit(task);
				}catch(IOException e){}
			}
		}catch(IOException e){
			System.err.println(e);
		}
	}

	private static class DaytimeTask implements Callable<void>{
		private Socket con;
		DaytimeTask(Socket con){
			this.con = con;
		}

		public void call(){
			try{
				Writer out = new OutputStreamWriter(con.getOutputStream());
				Date date = new Date();
				out.write(date.toString() + "\r\n");
				out.flush();
			}catch(IOException e){
				System.err.println(e);
			}finally{
				try{
					con.close();
				}catch(IOException e){
					System.err.println(e);
				}
			}
			return null;
		}
	}
}