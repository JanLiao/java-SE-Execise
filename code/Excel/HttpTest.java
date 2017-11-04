import java.io.*;
public class HttpTest{
	public static void main(String[] args){
		String str = "href=http://news.baidu.com/http:";
		int kk = str.indexOf("http:");
		int kkk = str.lastIndexOf("http:");
		System.out.println(kk);
		System.out.println(kkk);
		String ss = "   dsfd  dsf dfsw we we w   ";
		ss = ss.trim();
		ss = ss.replaceAll(" ","");
		System.out.println(ss);
	}
}