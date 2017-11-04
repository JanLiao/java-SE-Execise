import java.io.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
public class ProtocolTest{
	public static void main(String[] args){
		//超文本传输协议
		testProtocol("http://www.baidu.com");

		//安全https
		testProtocol("https://www.amazon.com/exec/obidos/order2/");

		//文件传输协议
		testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");

		//简单邮件传输协议
		testProtocol("mailto:zhutouchouren@163.com");

		//telnet
		testProtocol("telnet://dibner.poly.edu/");

		//本地文件访问
		testProtocol("file:///C:/Users/MrLiao/Desktop/code/Excel/a.txt");

		//gopher
		testProtocol("gopher://gopher.anc.org.za/");

		//轻量级目录访问协议
		testProtocol("ldap://ladp.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");

		//JAR
		testProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!/com.macfaq/io/StreamCopier.class");

		//NFS,网络文件系统
		testProtocol("nfs://utopia.poly.edu/usr/tmp/");

		//JDBC的定制协议
		testProtocol("jdbc:mysql://127.0.0.1:3306/ss1");

		//rmi,远程方法调用的定制协议
		testProtocol("rmi://ibiblio.org/RenderEngine");

		//HotJava的定制协议
		testProtocol("doc:/UsersGuide/release.html");
		testProtocol("netdoc:UsersGuide/release.html");
		testProtocol("systemresource://www.adc.org/+/index.html");
		testProtocol("verbatim:http://www.adc.org/");
	}

	public static void testProtocol(String url){
		try{
			URL u = new URL(url);
			System.out.println(u.getProtocol() + " :is supported");
		}catch(MalformedURLException ex){
			String protocol = url.substring(0, url.indexOf(':'));
			System.out.println(protocol + " :is not supported");
		}
	}
}