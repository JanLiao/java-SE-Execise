import java.io.*;
import java.util.regex.*;
public class HyperLinkFinder{
	public static void main(String[] args){
		//String regstring="<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s*(target=\\s*(\"(\"[^\"]*\"|[^\\s]*))?>";
	    String regstring="href\\s*=\\s*\""; 
	    //StringBuffer sb=new StringBuffer("");
	            String str="";
	    try{
	    	File f=new File("C:\\Users\\MrLiao\\Desktop\\a.txt");
	    	FileReader fr=new FileReader(f);
	    	BufferedReader br=new BufferedReader(fr);
	    	String line=br.readLine();

	    	while(line!=null){
	    		str+=line;
	    		line=br.readLine();
	    	}
	    	br.close();
	    	fr.close();

	    	Pattern ptn=Pattern.compile(regstring,Pattern.CASE_INSENSITIVE);
	    	Matcher matcher=ptn.matcher(str);
	    	while(matcher.find()){
	    		//System.out.println("hurl");
	    		int start=matcher.start();
	    		int end=matcher.start();
	    		String hurl=str.substring(start,end);
	    		System.out.println(hurl);
	    	}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
}