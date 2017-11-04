import java.io.*;
public class ReadFile{
	public static void main(String[] args){
		byte[] buff=new byte[1024];
		int n;
		FileInputStream fis=null;
		try{
			fis=new FileInputStream(args[0]);
			// n=fis.read(buff);
			
			// while(n!=-1){
			// 	System.out.write(buff,0,n);
			// 	n=fis.read(buff);
			// }
			while((n=fis.read(buff))!=-1){
				System.out.println("11");
				System.out.println(n);
			}
			//System.out.println(buff[0]);
		// for(int i=0;i<10;i++){
		// 	  System.out.println(buff[i]);
		// }
		}catch(Exception e){
			System.out.println("未找到");
			e.printStackTrace();
		}
		finally{
			try{

				fis.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}