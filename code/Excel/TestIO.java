import java.io.*;

public class TestIO{
	public static void main(String[] args){
		try{
			FileInputStream fin = new FileInputStream("C:/Users/MrLiao/Desktop/code/Excel/a.txt");
			BufferedInputStream bis = new BufferedInputStream(fin);
			InputStream in = new BufferedInputStream(fin);
			Reader isr = new InputStreamReader(in, "utf-8");
			int c = 0;
			while((c = isr.read()) != -1){
				System.out.print(c);
			}
			isr.close();
			bis.close();
			fin.close();
		}catch(IOException e){
			e.printStackTrace();
		}

		System.out.println();

		System.out.println("-----------------");

		try{
			FileInputStream fin1 = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			InputStreamReader isr1 = new InputStreamReader(fin1, "utf-8");
			BufferedReader br1 = new BufferedReader(isr1);
			String s = null;
			while((s = br1.readLine()) != null) System.out.println(s);
			br1.close();
			isr1.close();
			fin1.close(); 
		}catch(IOException e){
			e.printStackTrace();
		}

		try{
			FileInputStream fin2 = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			InputStreamReader isr2 = new InputStreamReader(fin2, "utf-8");
			BufferedReader br2 = new BufferedReader(isr2);
			int cc = 0;
			while((cc = br2.read()) != -1) System.out.print(cc);
			// String s = null;
			// while((s = br1.readLine()) != null) System.out.println(s);
			br2.close();
			isr2.close();
			fin2.close(); 
		}catch(IOException e){
			e.printStackTrace();
		}

		try{
			FileInputStream fin3 = new FileInputStream("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\a.txt");
			InputStream inin = new BufferedInputStream(fin3);
			Reader rr = new InputStreamReader(inin, "utf-8");
			int ccc = 0;
			while((ccc = rr.read()) != -1) System.out.print(ccc);
			rr.close();
			inin.close();
			fin3.close(); 
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}