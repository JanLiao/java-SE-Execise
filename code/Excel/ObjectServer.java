import java.io.*;
import java.util.*;
import java.net.*;
class Message implements Serializable{
	private String name;
	private String ip;
	private String msg;
	private Date date;
	public void setDate(Date date){
		this.date = date;
	}
	public Date getDate(){
		return this.date;
	}
	public String getIp(){
		return this.ip;
	}
	public void setIp(String ip){
		this.ip = ip;
	}
	public String getMsg(){
		return this.msg;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String toString(){
		return "name="+this.name+" ip="+this.ip+" msg="+this.msg;
	}
}

public class ObjectServer{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("服务器已经启动,等待客户端连接");
			Socket s = ss.accept();
			System.out.println("客户端连接成功!");
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message m = (Message)ois.readObject();
			System.out.println(m.getName()+" "+m.getIp());
			System.out.println(m.getMsg());
			System.out.println(m.getDate());
			ois.close();
			ss.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}