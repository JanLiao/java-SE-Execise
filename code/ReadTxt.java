import java.io.*;
import java.lang.*;
public class ReadTxt{
	public static void main(String[] args){
		try{
		File f=new File("C:/Users/MrLiao/Desktop/商务智能实践/ctrip14/product_quantity1.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String line;
		for(int i=0;i<10;i++){
			line=br.readLine();
			System.out.println(line);
			String str[]=line.split(",");
			// for(String s:str){
			// System.out.print(s+"/");
		 //  }
			int k=10*(Integer.parseInt(str[1].substring(0,4))-2014)+Integer.parseInt(str[1].substring(5,7));
			System.out.print(Integer.parseInt(str[0]));
			System.out.print("="+Integer.parseInt(str[1].substring(0,4)));
			System.out.print("="+k);
			System.out.print("="+Integer.parseInt(str[6]));
		  System.out.println();
		}
		br.close();
		fr.close();
	  }catch(Exception e){
	  	e.printStackTrace();
	  }
	}
}