import java.util.concurrent.TimeUnit;
import io.netty.bootstrap.*;
import io.netty.channel.*;
import io.netty.channel.nio.*;
import io.netty.channel.socket.*;
import io.netty.channel.socket.nio.*;
import io.netty.handler.codec.*;
import io.netty.handler.timeout.*;

public class HelloClient{
	private int port;
	private String host;

	public HelloClient(int port, String host) throws Exception{
		this.port = port;
		this.host = host;
		start();
	}

	private void start() throws Exception{
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		try{
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.group(eventLoopGroup);
			bootstrap.remoteAddress(host, port);
			bootstrap.handler(new ChannelInitializer<SocketChannel>(){
				protected void initChannel(SocketChannel socketChannel) throws Exception{
					ChannelPipeline p = socketChannel.pipeline();
					p.addLast(new HelloClientHandler());
				}
			});

			ChannelFuture future = bootstrap.connect(host, port).sync();
			if(future.isSuccess()){
				SocketChannel socketChannel = (SocketChannel) future.channel();
				System.out.println("connect server success!!!");
			}
			future.channel().closeFuture().sync();
		}finally{
			eventLoopGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception{
		HelloClient helloClient = new HelloClient(9999, "localhost");
	}
}