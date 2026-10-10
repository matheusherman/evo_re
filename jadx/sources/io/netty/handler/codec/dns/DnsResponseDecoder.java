package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class DnsResponseDecoder<A extends SocketAddress> {
    private final DnsRecordDecoder recordDecoder;

    protected abstract DnsResponse newResponse(A a10, A a11, int i10, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode);

    private void decodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf, int i10) {
        while (i10 > 0) {
            dnsResponse.addRecord(DnsSection.QUESTION, this.recordDecoder.decodeQuestion(byteBuf));
            i10--;
        }
    }

    private boolean decodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf, int i10) {
        while (i10 > 0) {
            DnsRecord dnsRecordDecodeRecord = this.recordDecoder.decodeRecord(byteBuf);
            if (dnsRecordDecodeRecord == null) {
                return false;
            }
            dnsResponse.addRecord(dnsSection, dnsRecordDecodeRecord);
            i10--;
        }
        return true;
    }

    DnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    final DnsResponse decode(A a10, A a11, ByteBuf byteBuf) {
        boolean z10;
        boolean z11;
        boolean z12;
        int unsignedShort = byteBuf.readUnsignedShort();
        int unsignedShort2 = byteBuf.readUnsignedShort();
        if ((unsignedShort2 >> 15) != 0) {
            DnsResponse dnsResponseNewResponse = newResponse(a10, a11, unsignedShort, DnsOpCode.valueOf((byte) ((unsignedShort2 >> 11) & 15)), DnsResponseCode.valueOf((byte) (unsignedShort2 & 15)));
            boolean z13 = true;
            if (((unsignedShort2 >> 8) & 1) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            dnsResponseNewResponse.setRecursionDesired(z10);
            if (((unsignedShort2 >> 10) & 1) == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            dnsResponseNewResponse.setAuthoritativeAnswer(z11);
            if (((unsignedShort2 >> 9) & 1) == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            dnsResponseNewResponse.setTruncated(z12);
            if (((unsignedShort2 >> 7) & 1) != 1) {
                z13 = false;
            }
            dnsResponseNewResponse.setRecursionAvailable(z13);
            dnsResponseNewResponse.setZ((unsignedShort2 >> 4) & 7);
            try {
                int unsignedShort3 = byteBuf.readUnsignedShort();
                int unsignedShort4 = byteBuf.readUnsignedShort();
                int unsignedShort5 = byteBuf.readUnsignedShort();
                int unsignedShort6 = byteBuf.readUnsignedShort();
                decodeQuestions(dnsResponseNewResponse, byteBuf, unsignedShort3);
                if (!decodeRecords(dnsResponseNewResponse, DnsSection.ANSWER, byteBuf, unsignedShort4) || !decodeRecords(dnsResponseNewResponse, DnsSection.AUTHORITY, byteBuf, unsignedShort5)) {
                    return dnsResponseNewResponse;
                }
                decodeRecords(dnsResponseNewResponse, DnsSection.ADDITIONAL, byteBuf, unsignedShort6);
                return dnsResponseNewResponse;
            } catch (Throwable th) {
                dnsResponseNewResponse.release();
                throw th;
            }
        }
        throw new CorruptedFrameException("not a response");
    }
}
