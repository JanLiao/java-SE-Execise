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

public class ObjectClient{
	public static void main(String[] args){
		try{
			Socket s = new Socket("localhost", 1234);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			Message m = new Message();
			m.setName(InetAddress.getLocalHost().getHostName());
			m.setIp(InetAddress.getLocalHost().getHostAddress());
			m.setMsg("hello, 廖晶安!");
			m.setDate(new Date());
			oos.writeObject(m);
			oos.flush();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}