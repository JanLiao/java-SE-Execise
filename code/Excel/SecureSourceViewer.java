import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

public class SecureSourceViewer{
	public static void main(String[] args){
		DialogAuthenticator da = new DialogAuthenticator("jan", new JFrame());
		Authenticator.setDefault(da);
		for(int i = 0; i < args.length; i++){
			try{
				URL u = new URL(args[i]);
				InputStream in = new BufferedInputStream(u.openStream());
				Reader r = new InputStreamReader(in, "utf-8");
				int c = 0;
				while((c = r.read()) != -1){
					System.out.print((char)c);
				}
			}catch(MalformedURLException e){
				System.err.println(args[0] + " is not a parseable URL");
			}catch(IOException e){
				System.err.println(e);
			}
		}
		System.exit(0);
	}
}