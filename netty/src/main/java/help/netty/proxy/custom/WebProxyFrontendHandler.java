package help.netty.proxy.custom;

import java.util.LinkedList;
import java.util.Queue;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOption;
import io.netty.handler.codec.http.DefaultHttpRequest;

public class WebProxyFrontendHandler extends ChannelInboundHandlerAdapter
{



	// As we use inboundChannel.eventLoop() when building the Bootstrap this does
	// not need to be volatile as
	// the outboundChannel will use the same EventLoop (and therefore Thread) as the
	// inboundChannel.
	private Channel outboundChannel;

	public WebProxyFrontendHandler()
	{
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx)
	{
		final Channel inboundChannel = ctx.channel();
		inboundChannel.read();
	}
	
	void proxyConnect(ChannelHandlerContext ctx, Object msg, String remoteHost,int remotePort)
	{
		DefaultHttpRequest httpRequest = (DefaultHttpRequest) msg;
		System.out.println(httpRequest.uri());
		System.out.println(httpRequest.headers());
		final Channel inboundChannel = ctx.channel();
		// Start the connection attempt.
		Bootstrap b = new Bootstrap();
		b.group(inboundChannel.eventLoop()).channel(ctx.channel().getClass())
				.handler(new WebProxyBackendInitializer(inboundChannel)).option(ChannelOption.AUTO_READ, false);
		ChannelFuture f = b.connect(remoteHost, remotePort);
		outboundChannel = f.channel();
		f.addListener(new ChannelFutureListener()
		{
			@Override
			public void operationComplete(ChannelFuture future)
			{
				if (future.isSuccess())
				{
					//WebProxyFrontendHandler.this.writeMessage(ctx, msg);
					writeQueue(ctx);
				} else
				{
					inboundChannel.close();
				}
			}
		});
	}
	Queue queue = new LinkedList();
	void writeQueue(ChannelHandlerContext ctx)
	{
		Object msg = queue.poll();
		if(msg==null)
		{
			ctx.channel().read();
			return;
		}
		outboundChannel.writeAndFlush(msg).addListener(new ChannelFutureListener()
		{
			@Override
			public void operationComplete(ChannelFuture future)
			{
				if (future.isSuccess())
				{
					
					WebProxyFrontendHandler.this.writeQueue(ctx);
				} else
				{
					future.channel().close();
				}
			}
		});
	}
	@Override
	public void channelRead(final ChannelHandlerContext ctx, Object msg)
	{
		queue.add(msg);
		if(outboundChannel==null)
		{
			proxyConnect(ctx, msg, "localhost", 8888);
		}
		else if(outboundChannel.isActive())
		{
			//writeMessage(ctx, msg);
			writeQueue(ctx);
		}
	}

	private void writeMessage(ChannelHandlerContext ctx, Object msg)
	{
		if (outboundChannel.isActive())
		{
			outboundChannel.writeAndFlush(msg).addListener(new ChannelFutureListener()
			{
				@Override
				public void operationComplete(ChannelFuture future)
				{
					if (future.isSuccess())
					{
						ctx.channel().read();
					} else
					{
						future.channel().close();
					}
				}
			});
		}
		else
		{
			System.out.println("error");
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx)
	{
		if (outboundChannel != null)
		{
			closeOnFlush(outboundChannel);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	{
		cause.printStackTrace();
		closeOnFlush(ctx.channel());
	}

	/**
	 * Closes the specified channel after all queued write requests are flushed.
	 */
	static void closeOnFlush(Channel ch)
	{
		if (ch.isActive())
		{
			ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
		}
	}
}
