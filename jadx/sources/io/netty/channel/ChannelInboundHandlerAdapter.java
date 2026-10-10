package io.netty.channel;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {
    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelInactive();
    }

    @ChannelHandlerMask.a
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelRegistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelUnregistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.a
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
