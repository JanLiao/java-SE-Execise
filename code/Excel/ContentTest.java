import java.io.*;
import java.net.*;
import java.util.*;
public class ContentTest{
	public List searchURL(String urlString){
		URL url2 = null;
		URLConnection conn = null;
		String nextLine = null;
		StringTokenizer tokenizer = null;
		List urlCollection = new ArrayList();
		try{
			url2 = new URL(urlString);
			conn = url2.openConnection();
			conn.connect();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			while((nextLine=br1.readLine())!=null){
//				System.out.println(nextLine);
//				System.out.println(22222);
				tokenizer = new StringTokenizer(nextLine);
				while(tokenizer.hasMoreTokens()){
					String urlToken = tokenizer.nextToken();
//					System.out.println(urlToken);
//					System.out.println("------------------");
					if(hasMatch(urlToken)) urlCollection.add(trimURL(urlToken));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return urlCollection;
	}
	private boolean hasMatch(String token){
		return token.indexOf("http:")!=-1;
	}
	private String trimURL(String url){
		String tempStr = null;
		int beginIndex = url.indexOf("http");
		int endIndex = url.length();
		tempStr = url.substring(beginIndex, endIndex);
		System.out.println(tempStr);
		endIndex = tempStr.indexOf("");
		if(endIndex==-1){
			endIndex = tempStr.length();
		}
		return tempStr.substring(0, endIndex);
	}

	public static void main(String[] args){
		ContentTest ct = new ContentTest();
		List urlCollection= ct.searchURL("http://www.baidu.com");
		Iterator iter = urlCollection.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}