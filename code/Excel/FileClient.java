import java.io.*;
import java.net.*;
public class FileClient{
	protected String hostIp;
	protected int hostPort;
	protected BufferedReader socketReader;
	protected PrintWriter socketWriter;
	public static void main(String[] args){
		FileClient fc = new FileClient("localhost", 3000);
		try{
			FileInputStream f = new FileInputStream("C:/Users/MrLiao/Desktop/林炯-统计/d.txt");
			InputStreamReader fr = new InputStreamReader(f, "UTF-8");
			BufferedReader bbr = new BufferedReader(fr);
			String lineStr = bbr.readLine();
			System.out.println(lineStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		fc.setUpConnection();
		String fileContents = fc.getFile("C:/Users/MrLiao/Desktop/林炯-统计/d.txt");
//		socketWriter.println(fileContents);
		// try{
		//     System.out.println(fc.socketReader.readLine());
		// }catch(Exception e){
		// 	e.printStackTrace();
		// }
		fc.tearDownConnection();
		System.out.println("nima!");
		System.out.println(fileContents);
	}

	public FileClient(String hostIp, int hostPort){
		this.hostIp = hostIp;
		this.hostPort = hostPort;
	}

	//连接服务器
	public void setUpConnection(){
		try{
		  Socket client = new Socket(hostIp, hostPort);
		  socketReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		  OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream(), "UTF-8");
		  socketWriter = new PrintWriter(osw, true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//读取文件信息以字符串的形式返回
	public String getFile(String filename){
		StringBuffer fileLines = new StringBuffer();
		try{
			socketWriter.println(filename);
			socketWriter.flush();
			String line = null;
			while((line = socketReader.readLine())!=null){
				fileLines.append(line+" ");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(fileLines.length());
		return fileLines.toString();
	}

	//关闭流和Socket连接
	public void tearDownConnection(){
		try{
			socketWriter.close();
			socketReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}