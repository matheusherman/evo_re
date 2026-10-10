package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultDnsRecordDecoder implements DnsRecordDecoder {
    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final <T extends DnsRecord> T decodeRecord(ByteBuf byteBuf) {
        int i10 = byteBuf.readerIndex();
        String strDecodeName = decodeName(byteBuf);
        int iWriterIndex = byteBuf.writerIndex();
        if (iWriterIndex - byteBuf.readerIndex() < 10) {
            byteBuf.readerIndex(i10);
            return null;
        }
        DnsRecordType dnsRecordTypeValueOf = DnsRecordType.valueOf(byteBuf.readUnsignedShort());
        int unsignedShort = byteBuf.readUnsignedShort();
        long unsignedInt = byteBuf.readUnsignedInt();
        int unsignedShort2 = byteBuf.readUnsignedShort();
        int i11 = byteBuf.readerIndex();
        if (iWriterIndex - i11 < unsignedShort2) {
            byteBuf.readerIndex(i10);
            return null;
        }
        T t10 = (T) decodeRecord(strDecodeName, dnsRecordTypeValueOf, unsignedShort, unsignedInt, byteBuf, i11, unsignedShort2);
        byteBuf.readerIndex(i11 + unsignedShort2);
        return t10;
    }

    protected DefaultDnsRecordDecoder() {
    }

    public static String decodeName(ByteBuf byteBuf) {
        return DnsCodecUtil.decodeDomainName(byteBuf);
    }

    protected String decodeName0(ByteBuf byteBuf) {
        return decodeName(byteBuf);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final DnsQuestion decodeQuestion(ByteBuf byteBuf) {
        return new DefaultDnsQuestion(decodeName(byteBuf), DnsRecordType.valueOf(byteBuf.readUnsignedShort()), byteBuf.readUnsignedShort());
    }

    protected DnsRecord decodeRecord(String str, DnsRecordType dnsRecordType, int i10, long j10, ByteBuf byteBuf, int i11, int i12) {
        if (dnsRecordType == DnsRecordType.PTR) {
            return new DefaultDnsPtrRecord(str, i10, j10, decodeName0(byteBuf.duplicate().setIndex(i11, i12 + i11)));
        }
        if (dnsRecordType != DnsRecordType.CNAME && dnsRecordType != DnsRecordType.NS) {
            return new DefaultDnsRawRecord(str, dnsRecordType, i10, j10, byteBuf.retainedDuplicate().setIndex(i11, i12 + i11));
        }
        return new DefaultDnsRawRecord(str, dnsRecordType, i10, j10, DnsCodecUtil.decompressDomainName(byteBuf.duplicate().setIndex(i11, i12 + i11)));
    }
}
