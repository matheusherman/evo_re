package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultDnsQuestion extends AbstractDnsRecord implements DnsQuestion {
    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType) {
        super(str, dnsRecordType, 0L);
    }

    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType, int i10) {
        super(str, dnsRecordType, i10, 0L);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append('(');
        sb2.append(name());
        sb2.append(' ');
        StringBuilder sbAppendRecordClass = DnsMessageUtil.appendRecordClass(sb2, dnsClass());
        sbAppendRecordClass.append(' ');
        sbAppendRecordClass.append(type().name());
        sbAppendRecordClass.append(')');
        return sb2.toString();
    }
}
