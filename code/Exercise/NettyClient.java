import io.netty.channel.*;
import io.netty.channel.nio.*;
import io.netty.channel.socket.*;
import io.netty.handler.codec.*;
import io.netty.handler.timeout.*;
import io.netty.buffer.*;
import java.net.*;
import java.io.*;
public class NettyClient{
	public static void main(String[] args){
		ClientBootstrap bootstrap = new ClientBootstrap(
			new NioClientSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool()
				));
		bootstrap.setPipelineFactory(new ChannelPipelineFactory(){
			public ChannelPipeline getPipeline() throws Exception{
				return Channels.pipeline(new HelloClientHandler());
			}
		});
		bootstrap.connect(new InetSocketAddress("127.0.0.1", "8000"));
	}

	private class HelloClientHandler extends SimpleChannelHandler{
		public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e){
			System.out.println("Hello, I'am Client!!!");
		}
	}
}