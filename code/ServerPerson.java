import java.io.*;
import java.net.*;
import java.util.*;
public class ServerPerson{
	public static void main(String[] args){
		ServerSocket server;
		Socket sk;
		Persons p;
		try{
			server=new ServerSocket(8020);

			sk=server.accept();

			InputStream o=sk.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(o);
			p=(Persons)ois.readObject();
			ois.close();
			System.out.println(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}