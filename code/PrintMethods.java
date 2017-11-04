import java.lang.reflect.*;
import java.io.*;
public class PrintMethods{
	public static void main(String[] args){
		if(args.length!=1){
			System.out.println("请输入一个完整类名");
			System.exit(0);
		}else{
			try{
				Class c=Class.forName(args[0]);
				Method[] m=c.getMethods();
				//Method[] m=c.getDeclaredMethods();
				for(int i=0;i<m.length;i++){
					System.out.println(m[i].toString());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}