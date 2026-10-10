package o6;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.NetUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends SimpleChannelInboundHandler<DatagramDnsResponse> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static q6.b f16480b = q6.c.d(d.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f16481a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.SimpleChannelInboundHandler
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramDnsResponse datagramDnsResponse) {
        try {
            c cVar = new c();
            cVar.g(datagramDnsResponse.code().intValue());
            DnsSection dnsSection = DnsSection.QUESTION;
            if (datagramDnsResponse.count(dnsSection) > 0) {
                String strName = ((DnsQuestion) datagramDnsResponse.recordAt(dnsSection, 0)).name();
                int iLastIndexOf = strName.lastIndexOf(".");
                if (iLastIndexOf != -1) {
                    strName = strName.substring(0, iLastIndexOf);
                }
                cVar.e(strName);
            }
            int iCount = datagramDnsResponse.count(DnsSection.ANSWER);
            for (int i10 = 0; i10 < iCount; i10++) {
                DnsRecord dnsRecordRecordAt = datagramDnsResponse.recordAt(DnsSection.ANSWER, i10);
                cVar.f(dnsRecordRecordAt.type());
                if (dnsRecordRecordAt.type() == DnsRecordType.A) {
                    cVar.a().add(NetUtil.bytesToIpAddress(ByteBufUtil.getBytes(((DnsRawRecord) dnsRecordRecordAt).content())));
                }
            }
            this.f16481a.a(datagramDnsResponse.id(), cVar);
        } catch (Exception e10) {
            f16480b.error("[DNS] Handler dns response error.", e10);
        }
    }

    public d(e eVar) {
        this.f16481a = eVar;
    }
}
