import java.io.*;
import java.lang.reflect.*;
public class PrintFields{
	public static void main(String[] args){
		if(args.length!=1){
			System.out.println("请重新输入一个完整类名");
			System.exit(0);
		}else {
			try{
				Class c=Class.forName(args[0]);
				Field f[]=c.getDeclaredFields();
				//Field f[]=c.getFields();
				for(int i=0;i<args.length;i++){
					System.out.println(f[i].toString());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}