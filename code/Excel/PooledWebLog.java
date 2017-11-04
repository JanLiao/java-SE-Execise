import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class LookupTask implements Callable<String>{
	private String line;
	public LookupTask(String line){
		this.line = line;
	}
	public String call(){
		try{
			int index = line.indexOf(' ');
			String address = line.substring(0, index);
			String theRest = line.substring(index);
			String hostName = InetAddress.getByName(address).getHostName();
			return hostName + " " + theRest;
		}catch(Exception e){
			return line;
		}
	}
}

public class PooledWebLog{
	private static final int NUM_THREADS = 4;
	public static void main(String[] args) throws Exception{
		String hostN = InetAddress.getByName("14.215.177.39").getHostName();
		System.out.println(hostN);
		System.out.println(InetAddress.getByName("www.baidu.com"));
		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
		Queue<LogEntry> queue = new LinkedList<LogEntry>();
		try{
			FileInputStream fin = new FileInputStream(args[0]);
			InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			for(String entry = br.readLine(); entry != null; entry = br.readLine()){
				LookupTask task = new LookupTask(entry);
				Future<String> future = executor.submit(task);
				LogEntry logEntry = new LogEntry(entry, future);
				queue.offer(logEntry);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("-------------");
		for(LogEntry le:queue){
			try{
				System.out.println(le.future.get());
			}catch(InterruptedException | ExecutionException e){
				System.out.println(le.original);
			}
		}
		System.out.println("===============");
		executor.shutdown();
	}

	private static class LogEntry{
		String original;
		Future<String> future;
		LogEntry(String original, Future future){
			this.original = original;
			this.future = future;
		}
	}
}