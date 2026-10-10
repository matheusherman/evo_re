package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class DnsQueryEncoder {
    private final DnsRecordEncoder recordEncoder;

    private void encodeQuestions(DnsQuery dnsQuery, ByteBuf byteBuf) {
        int iCount = dnsQuery.count(DnsSection.QUESTION);
        for (int i10 = 0; i10 < iCount; i10++) {
            this.recordEncoder.encodeQuestion((DnsQuestion) dnsQuery.recordAt(DnsSection.QUESTION, i10), byteBuf);
        }
    }

    DnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.recordEncoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "recordEncoder");
    }

    private static void encodeHeader(DnsQuery dnsQuery, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsQuery.id());
        int iByteValue = (dnsQuery.opCode().byteValue() & 255) << 14;
        if (dnsQuery.isRecursionDesired()) {
            iByteValue |= 256;
        }
        byteBuf.writeShort(iByteValue);
        byteBuf.writeShort(dnsQuery.count(DnsSection.QUESTION));
        byteBuf.writeShort(0);
        byteBuf.writeShort(0);
        byteBuf.writeShort(dnsQuery.count(DnsSection.ADDITIONAL));
    }

    private void encodeRecords(DnsQuery dnsQuery, DnsSection dnsSection, ByteBuf byteBuf) {
        int iCount = dnsQuery.count(dnsSection);
        for (int i10 = 0; i10 < iCount; i10++) {
            this.recordEncoder.encodeRecord(dnsQuery.recordAt(dnsSection, i10), byteBuf);
        }
    }

    void encode(DnsQuery dnsQuery, ByteBuf byteBuf) {
        encodeHeader(dnsQuery, byteBuf);
        encodeQuestions(dnsQuery, byteBuf);
        encodeRecords(dnsQuery, DnsSection.ADDITIONAL, byteBuf);
    }
}
