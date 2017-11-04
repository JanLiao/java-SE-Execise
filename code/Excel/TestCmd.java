import java.io.*;

public class TestCmd{
	public static void main(String[] args){
		try{
			Runtime.getRuntime().exec("cmd.exe /c start D:\\filesystem\\C命令.doc");
//			Runtime.getRuntime().exec("你的命令",null,new File("d:/test"));
			Runtime.getRuntime().exec("你的命令",null,new File("d:/test"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}