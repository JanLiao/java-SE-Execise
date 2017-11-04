import io.netty.channel.*;
import io.netty.channel.nio.*;
import io.netty.channel.socket.*;
import io.netty.channel.socket.nio.*;
import io.netty.handler.codec.*;
import io.netty.handler.timeout.*;
import io.netty.buffer.*;
import io.netty.bootstrap.*;
import java.io.*;
import java.net.*;
import org.apache.log4j.Logger;

public class HelloServer{

	private static Logger logger = Logger.getLogger(HelloServer.class);
	private int port;
	public HelloServer(int port){
		this.port = port;
		bind();
	}

	public void bind(){
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();

		try{
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(boss, worker);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.option(ChannelOption.SO_BACKLOG, 1024);//选择数
			bootstrap.option(ChannelOption.TCP_NODELAY, true);//不延迟，消息立即发送
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);//长连接
			bootstrap.childHandler(new ChannelInitializer<SocketChannel>(){
				protected void initChannel(SocketChannel socketChannel) throws Exception{
					ChannelPipeline p = socketChannel.pipeline();
					p.addLast(new HelloHandler());
				}
			});

			ChannelFuture f = bootstrap.bind(port).sync();
			if(f.isSuccess()){
				logger.debug("启动Netty服务成功， 端口号: " + this.port);
				System.out.println("启动Netty服务成功， 端口号: " + this.port);
			}
			f.channel().closeFuture().sync();
		}catch(Exception e){
			logger.error("启动Netty服务异常，异常信息: " + e.getMessage());
			System.out.println("启动Netty服务异常，异常信息: " + e.getMessage());
			e.printStackTrace();
		}finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}

	public static void main(String[] args){
		HelloServer helloServer = new HelloServer(9999);
	}
}