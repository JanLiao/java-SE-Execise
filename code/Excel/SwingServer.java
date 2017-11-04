import java.io.*;
import java.net.*;
import java.util.*;
public class SwingServer{
	private Vector<Socket> vec = new Vector<Socket>();
	public static void main(String[] args){
		SwingServer swings = new SwingServer();
		try{
			swings.startServer(8888);
		}catch(Exception e){
			System.out.println("服务器启动失败");
			e.printStackTrace();
		}
	}

	//启动服务器,循环监听客户端的连接
	public void startServer(int port) throws Exception{
		ServerSocket ss = new ServerSocket(port);
		System.out.println("服务器已经启动成功");
		while(true){
			Socket s = ss.accept();
			vec.add(s);
			System.out.println("客户端连接成功"+s);
			new MySocketOpt(s).start();
		}
	}

	//定义一个线程,提供接受和转发服务器
	class MySocketOpt extends Thread{
		private Socket s;
		public MySocketOpt(Socket s){
			this.s = s;
		}

		public void run(){
			try{
				InputStreamReader isr = new InputStreamReader(s.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				while(true){
					String msg = br.readLine();
					System.out.println("服务器接收到"+msg);
					for(Socket tmp:vec){
						if(tmp!=s){
							OutputStreamWriter osw = new OutputStreamWriter(tmp.getOutputStream(), "UTF-8");
							PrintWriter pw = new PrintWriter(osw, true);
							pw.println(msg);
							pw.flush();
						}
					}
					if("88".equals(msg)){
						break;
					}
				}
			}catch(Exception e){
				System.out.println("已退出聊天室");
				e.printStackTrace();
			}
		}
	}
}