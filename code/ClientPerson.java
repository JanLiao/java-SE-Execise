import java.io.*;
import java.net.*;
import java.util.*;
public class ClientPerson{
	public static void main(String[] args){
		Socket s;
		try{
			s=new Socket(InetAddress.getLocalHost(),8020);
			OutputStream o=s.getOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(o);
			Persons p=new Persons("Jan",25,"man","han");
            oos.writeObject(p);
            //oos.flush();
            oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}