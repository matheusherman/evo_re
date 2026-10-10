package io.netty.handler.codec;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class MessageToMessageCodec<INBOUND_IN, OUTBOUND_IN> extends ChannelDuplexHandler {
    private final MessageToMessageEncoder<Object> encoder = new MessageToMessageEncoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.1
        @Override // io.netty.handler.codec.MessageToMessageEncoder
        public boolean acceptOutboundMessage(Object obj) {
            return MessageToMessageCodec.this.acceptOutboundMessage(obj);
        }

        @Override // io.netty.handler.codec.MessageToMessageEncoder
        protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) {
            MessageToMessageCodec.this.encode(channelHandlerContext, obj, list);
        }
    };
    private final MessageToMessageDecoder<Object> decoder = new MessageToMessageDecoder<Object>() { // from class: io.netty.handler.codec.MessageToMessageCodec.2
        @Override // io.netty.handler.codec.MessageToMessageDecoder
        public boolean acceptInboundMessage(Object obj) {
            return MessageToMessageCodec.this.acceptInboundMessage(obj);
        }

        @Override // io.netty.handler.codec.MessageToMessageDecoder
        protected void decode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) {
            MessageToMessageCodec.this.decode(channelHandlerContext, obj, list);
        }
    };
    private final TypeParameterMatcher inboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "INBOUND_IN");
    private final TypeParameterMatcher outboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "OUTBOUND_IN");

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, INBOUND_IN inbound_in, List<Object> list);

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, OUTBOUND_IN outbound_in, List<Object> list);

    public boolean acceptInboundMessage(Object obj) {
        return this.inboundMsgMatcher.match(obj);
    }

    public boolean acceptOutboundMessage(Object obj) {
        return this.outboundMsgMatcher.match(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        this.decoder.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        this.encoder.write(channelHandlerContext, obj, channelPromise);
    }

    protected MessageToMessageCodec() {
    }
}
