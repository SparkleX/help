package help.netty.proxy.custom;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;

public class WebProxyFrontendInitializer extends ChannelInitializer<SocketChannel> 
{
    @Override
    public void initChannel(SocketChannel ch) 
    {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new HttpRequestDecoder());
        p.addLast(new WebProxyFrontendHandler());
    }
}
