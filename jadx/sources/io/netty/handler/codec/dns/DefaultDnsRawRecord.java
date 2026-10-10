package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultDnsRawRecord extends AbstractDnsRecord implements DnsRawRecord {
    private final ByteBuf content;

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord retain() {
        content().retain();
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append('(');
        DnsRecordType dnsRecordTypeType = type();
        if (dnsRecordTypeType != DnsRecordType.OPT) {
            sb2.append(name().isEmpty() ? "<root>" : name());
            sb2.append(' ');
            sb2.append(timeToLive());
            sb2.append(' ');
            StringBuilder sbAppendRecordClass = DnsMessageUtil.appendRecordClass(sb2, dnsClass());
            sbAppendRecordClass.append(' ');
            sbAppendRecordClass.append(dnsRecordTypeType.name());
        } else {
            sb2.append("OPT flags:");
            sb2.append(timeToLive());
            sb2.append(" udp:");
            sb2.append(dnsClass());
        }
        sb2.append(' ');
        sb2.append(content().readableBytes());
        sb2.append("B)");
        return sb2.toString();
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord touch(Object obj) {
        content().touch(obj);
        return this;
    }

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, int i10, long j10, ByteBuf byteBuf) {
        super(str, dnsRecordType, i10, j10);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return content().release();
    }
}
