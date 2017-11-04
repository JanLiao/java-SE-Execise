import java.io.*;
import java.net.*;
public class URLConTest{
	public static void main(String[] args){
		StringBuffer str = new StringBuffer();
		StringBuffer str1 = new StringBuffer();
		try{
			URL url = new URL("http://127.0.0.1:8080/ITMS/login/reqLogin.do");
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			OutputStream raw = con.getOutputStream();
			OutputStream buffered = new BufferedOutputStream(raw);
			OutputStreamWriter out = new OutputStreamWriter(buffered, "utf-8");
			out.write("userAccount=admin&userPassword=1");
			out.flush();
			out.close();
			InputStream in = new BufferedInputStream(con.getInputStream());
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			int c;
			while((c = isr.read()) != -1){
				System.out.print((char)c);
				str.append((char)c);
				str1.append(c);
			}
			System.out.println();
			System.out.println(str.toString());
			System.out.println(str1.toString());
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		String[] arr = str.toString().split(",");
		System.out.println(arr.length);
		for(String s:arr){
			System.out.println(s);
		}
		System.out.println("---------------------------------");
		String[] arr1 = arr[0].split(":");
		if("true".equals(arr1[1])){
			try{
				System.out.println("YOU ARE SUCCESS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				URL u = new URL("http://localhost:8080/ITMS/front/index.do");
				URLConnection ucon = u.openConnection();
				InputStream ins = new BufferedInputStream(ucon.getInputStream());
				InputStreamReader isr1 = new InputStreamReader(ins, "utf-8");
				FileOutputStream fos = new FileOutputStream("C:\\Users\\MrLiao\\Desktop\\code\\Exercise\\index.html");
				BufferedOutputStream bw = new BufferedOutputStream(fos);
				int cc;
				while((cc = ins.read()) != -1){
					System.out.print((char)cc);
					bw.write((char)cc);
				}
				ins.close();
				bw.close();
				fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if("false".equals(arr1[1])){
			try{
				System.out.println("YOU ARE FAILURE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				URL uu = new URL("http://127.0.0.1:8080/ITMS/views/login.jsp");
				URLConnection uucon = uu.openConnection();
				InputStream insp = new BufferedInputStream(uucon.getInputStream());
				InputStreamReader isr2 = new InputStreamReader(insp, "utf-8");
				int ccc;
				while((ccc = isr2.read()) != -1){
					System.out.print((char)ccc);
				}
				insp.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}