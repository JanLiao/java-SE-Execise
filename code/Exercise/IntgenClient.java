import java.nio.*;
import java.net.*;
import java.io.*;
import java.nio.channels.*;

public class IntgenClient{
	public static int DEAULT_PORT = 1919;
	public static void main(String[] args){
		int port = DEAULT_PORT;
		try{
			SocketAddress address = new InetSocketAddress("127.0.0.1", 1919);
			SocketChannel client = SocketChannel.open(address);
			ByteBuffer buffer = ByteBuffer.allocate(74);
			IntBuffer view = buffer.asIntBuffer();
			for(int expected = 0; ; expected++){
//				System.out.println(expected);
				client.read(buffer);
				int actual = view.get();
				buffer.clear();
				view.rewind();

				if(actual != expected){
					System.out.println(actual);
					System.out.println("Expected " + expected + " ; was " + actual);
					break;
				}
				System.out.println("--------");
				System.out.println(actual);
				System.out.println("--------");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}