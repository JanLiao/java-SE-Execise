import io.netty.channel.*;
import io.netty.channel.nio.*;
import io.netty.channel.socket.*;
import io.netty.handler.codec.*;
import io.netty.handler.timeout.*;
import io.netty.buffer.*;
import io.netty.bootstrap.*;
import java.io.*;
import java.net.*;
public class NettyTest{
	public static void main(String[] args){
		ServerBootstrap bootstrap = new ServerBootstrap(
			new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool()
				));
		bootstrap.setPipelineFactory(new ChannelPipelineFactory(){
			public ChannelPipeline getPipeline() throws Exception{
				return Channels.pipeline(new NettyHandler());
			}
		});
		bootstrap.bind(new InetSocketAddress(8000));
	}

	private static class NettyHandler extends ChannelHandlerAdapter{
		public void channelRead(ChannelHandlerContext ctx,
			Object msg){
			ByteBuf buf = (ByteBuf)msg;
			String received = getMessage(buf);
			System.out.println("Hello , I'am Server !!!");
		}
	}
}