import java.text.*;
import java.util.*;
import java.util.concurrent.*;
// import com.netty.common.*;
// import com.netty.util.*;
// import com.netty.buffer.*;
import java.net.*;
import io.netty.handler.codec.*;
import io.netty.handler.timeout.*;
import io.netty.buffer.*;
import io.netty.channel.*;

public class HelloClientHandler extends ChannelHandlerAdapter{
	private ByteBuf firstMessage;
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		byte[] data = "服务器,给我一个APPLE!!!!".getBytes();
		firstMessage = Unpooled.buffer();
		firstMessage.writeBytes(data);
		ctx.writeAndFlush(firstMessage);
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		ByteBuf buf = (ByteBuf)msg;
		String rev = getMessage(buf);
		System.out.println("客户端收到服务器数据: " + rev);
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
}