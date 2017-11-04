import java.io.*;
import io.netty.buffer.*;
import io.netty.channel.*;

public class HelloHandler extends ChannelHandlerAdapter{
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		ByteBuf buf = (ByteBuf)msg;
		String recieved = getMessage(buf);
		System.out.println("服务器接受到消息: " + recieved);
		try{
			ctx.writeAndFlush(getSendByteBuf("APPLE========="));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private String getMessage(ByteBuf buf){
		byte[] con = new byte[buf.readableBytes()];
		buf.readBytes(con);
		try{
			return new String(con);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	private ByteBuf getSendByteBuf(String message) throws Exception{
		byte[] req = message.getBytes("utf-8");
		ByteBuf pingMessage = Unpooled.buffer();
		pingMessage.writeBytes(req);
		return pingMessage;
	}
}