import java.io.*;
public class TestInput{
	public static void main(String[] args){
		try{
//			File f = new File("C:/Users/MrLiao/Desktop/林炯-统计/a.txt");
//			FileReader fr = new FileReader(f);
			FileInputStream f = new FileInputStream("C:/Users/MrLiao/Desktop/林炯-统计/b.txt");
			InputStreamReader fr = new InputStreamReader(f, "GBK");
			BufferedReader br = new BufferedReader(fr);
			String len = br.readLine();
			while((len)!=null){
				System.out.println(len);
				len = br.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}