import java.io.*;
import java.net.*;
public class FileServer{
	protected int listenPort = 3000;
	public static void main(String[] args){
		FileServer fs = new FileServer();
		fs.acceptConnection();
	}

	//创建服务器Socket,接收客户端连接
	public void acceptConnection(){
		try{
			ServerSocket ss = new ServerSocket(listenPort);
			Socket incomingConnection = null;
			while(true){
				incomingConnection = ss.accept();
				handleConnection(incomingConnection);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//获取客户端传递过来的文件内容,并返回文件内容
	public void handleConnection(Socket incomingConnection){
		try{
			OutputStream outputToSocket = incomingConnection.getOutputStream();
			InputStream inputStreamSocket = incomingConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStreamSocket, "utf-8"));
			String filename = br.readLine();
			System.out.println(filename);
			FileInputStream f = new FileInputStream(filename);
			InputStreamReader fr = new InputStreamReader(f, "UTF-8");
			BufferedReader bbr = new BufferedReader(fr);
//			String lineStr = bbr.readLine();
			PrintWriter streamWriter = new PrintWriter(outputToSocket);
//			System.out.println(lineStr);
			String lineStr = null;
			while((lineStr = bbr.readLine())!=null){
				System.out.println("success!");
				System.out.println(lineStr);
				streamWriter.println(lineStr);
			}
//			streamWriter.println(br.readLine());
			System.out.println("cao");
			streamWriter.flush();
			br.close();
			System.out.println("cao1");
			bbr.close();
			System.out.println("cao2");
			streamWriter.close();
			System.out.println("cao3");
			fr.close();
			System.out.println("cao4");
			f.close();
			System.out.println("cao5");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}