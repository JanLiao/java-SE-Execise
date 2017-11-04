import java.io.*;

public class TestExe{
	public static void main(String[] args){
		Runtime rn = Runtime.getRuntime();
		try{
			System.out.println("Begin------");
			rn.exec("notepad.exe");
			System.out.println("End");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			System.out.println("Begin------");
//			Process pr = rn.exec("ping www.163.com");
			Process pr = rn.exec("cd  C:\\Users\\MrLiao\\Desktop");
			BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			while(true){
				String s = br.readLine();
				if(s==null){
					break;
				}
				System.out.println("内容="+s);
			}
			System.out.println("End");
			br.close();
			pr.waitFor();
			if(pr.exitValue()==0){
				System.out.println("运行成功!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}