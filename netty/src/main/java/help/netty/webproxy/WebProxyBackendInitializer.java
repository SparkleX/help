package help.netty.webproxy;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;

public class WebProxyBackendInitializer extends ChannelInitializer<SocketChannel> {


    private Channel inboundChannel;

	public WebProxyBackendInitializer(Channel inboundChannel)
    {
        this.inboundChannel = inboundChannel;
    }

    @Override
    public void initChannel(SocketChannel ch) 
    {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new HttpRequestEncoder());
        p.addLast(new WebProxyBackendHandler(inboundChannel));
        
    }
}
