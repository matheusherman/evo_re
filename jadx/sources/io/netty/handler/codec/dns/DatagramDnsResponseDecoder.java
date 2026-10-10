package io.netty.handler.codec.dns;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.net.InetSocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@ChannelHandler.a
public class DatagramDnsResponseDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsResponseDecoder<InetSocketAddress> responseDecoder;

    public DatagramDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) {
        decode2(channelHandlerContext, datagramPacket, (List<Object>) list);
    }

    public DatagramDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.responseDecoder = new DnsResponseDecoder<InetSocketAddress>(dnsRecordDecoder) { // from class: io.netty.handler.codec.dns.DatagramDnsResponseDecoder.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.handler.codec.dns.DnsResponseDecoder
            public DnsResponse newResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i10, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
                return new DatagramDnsResponse(inetSocketAddress, inetSocketAddress2, i10, dnsOpCode, dnsResponseCode);
            }
        };
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) {
        try {
            list.add(decodeResponse(channelHandlerContext, datagramPacket));
        } catch (IndexOutOfBoundsException e10) {
            throw new CorruptedFrameException("Unable to decode response", e10);
        }
    }

    protected DnsResponse decodeResponse(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {
        return this.responseDecoder.decode(datagramPacket.sender(), datagramPacket.recipient(), datagramPacket.content());
    }
}
