package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class DefaultDnsRecordEncoder implements DnsRecordEncoder {
    static int calculateEcsAddressLength(int i10, int i11) {
        return (i10 >>> 3) + (i11 != 0 ? 1 : 0);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordEncoder
    public void encodeRecord(DnsRecord dnsRecord, ByteBuf byteBuf) {
        if (dnsRecord instanceof DnsQuestion) {
            encodeQuestion((DnsQuestion) dnsRecord, byteBuf);
            return;
        }
        if (dnsRecord instanceof DnsPtrRecord) {
            encodePtrRecord((DnsPtrRecord) dnsRecord, byteBuf);
            return;
        }
        if (dnsRecord instanceof DnsOptEcsRecord) {
            encodeOptEcsRecord((DnsOptEcsRecord) dnsRecord, byteBuf);
        } else if (dnsRecord instanceof DnsOptPseudoRecord) {
            encodeOptPseudoRecord((DnsOptPseudoRecord) dnsRecord, byteBuf);
        } else {
            if (!(dnsRecord instanceof DnsRawRecord)) {
                throw new UnsupportedMessageTypeException(StringUtil.simpleClassName(dnsRecord));
            }
            encodeRawRecord((DnsRawRecord) dnsRecord, byteBuf);
        }
    }

    protected DefaultDnsRecordEncoder() {
    }

    private void encodeOptEcsRecord(DnsOptEcsRecord dnsOptEcsRecord, ByteBuf byteBuf) {
        InternetProtocolFamily internetProtocolFamily;
        encodeRecord0(dnsOptEcsRecord, byteBuf);
        int iSourcePrefixLength = dnsOptEcsRecord.sourcePrefixLength();
        int iScopePrefixLength = dnsOptEcsRecord.scopePrefixLength();
        int i10 = iSourcePrefixLength & 7;
        byte[] bArrAddress = dnsOptEcsRecord.address();
        int length = bArrAddress.length << 3;
        if (length >= iSourcePrefixLength && iSourcePrefixLength >= 0) {
            if (bArrAddress.length == 4) {
                internetProtocolFamily = InternetProtocolFamily.IPv4;
            } else {
                internetProtocolFamily = InternetProtocolFamily.IPv6;
            }
            short sAddressNumber = (short) internetProtocolFamily.addressNumber();
            int iCalculateEcsAddressLength = calculateEcsAddressLength(iSourcePrefixLength, i10);
            byteBuf.writeShort(iCalculateEcsAddressLength + 8);
            byteBuf.writeShort(8);
            byteBuf.writeShort(iCalculateEcsAddressLength + 4);
            byteBuf.writeShort(sAddressNumber);
            byteBuf.writeByte(iSourcePrefixLength);
            byteBuf.writeByte(iScopePrefixLength);
            if (i10 > 0) {
                int i11 = iCalculateEcsAddressLength - 1;
                byteBuf.writeBytes(bArrAddress, 0, i11);
                byteBuf.writeByte(padWithZeros(bArrAddress[i11], i10));
                return;
            }
            byteBuf.writeBytes(bArrAddress, 0, iCalculateEcsAddressLength);
            return;
        }
        throw new IllegalArgumentException(iSourcePrefixLength + ": " + iSourcePrefixLength + " (expected: 0 >= " + length + ')');
    }

    private void encodeOptPseudoRecord(DnsOptPseudoRecord dnsOptPseudoRecord, ByteBuf byteBuf) {
        encodeRecord0(dnsOptPseudoRecord, byteBuf);
        byteBuf.writeShort(0);
    }

    private void encodePtrRecord(DnsPtrRecord dnsPtrRecord, ByteBuf byteBuf) {
        encodeRecord0(dnsPtrRecord, byteBuf);
        encodeName(dnsPtrRecord.hostname(), byteBuf);
    }

    private void encodeRawRecord(DnsRawRecord dnsRawRecord, ByteBuf byteBuf) {
        encodeRecord0(dnsRawRecord, byteBuf);
        ByteBuf byteBufContent = dnsRawRecord.content();
        int i10 = byteBufContent.readableBytes();
        byteBuf.writeShort(i10);
        byteBuf.writeBytes(byteBufContent, byteBufContent.readerIndex(), i10);
    }

    private void encodeRecord0(DnsRecord dnsRecord, ByteBuf byteBuf) {
        encodeName(dnsRecord.name(), byteBuf);
        byteBuf.writeShort(dnsRecord.type().intValue());
        byteBuf.writeShort(dnsRecord.dnsClass());
        byteBuf.writeInt((int) dnsRecord.timeToLive());
    }

    private static byte padWithZeros(byte b10, int i10) {
        int i11;
        switch (i10) {
            case 0:
                return (byte) 0;
            case 1:
                i11 = b10 & 128;
                break;
            case 2:
                i11 = b10 & 192;
                break;
            case 3:
                i11 = b10 & 224;
                break;
            case 4:
                i11 = b10 & 240;
                break;
            case 5:
                i11 = b10 & 248;
                break;
            case 6:
                i11 = b10 & 252;
                break;
            case 7:
                i11 = b10 & 254;
                break;
            case 8:
                return b10;
            default:
                throw new IllegalArgumentException("lowOrderBitsToPreserve: " + i10);
        }
        return (byte) i11;
    }

    protected void encodeName(String str, ByteBuf byteBuf) {
        DnsCodecUtil.encodeDomainName(str, byteBuf);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordEncoder
    public final void encodeQuestion(DnsQuestion dnsQuestion, ByteBuf byteBuf) {
        encodeName(dnsQuestion.name(), byteBuf);
        byteBuf.writeShort(dnsQuestion.type().intValue());
        byteBuf.writeShort(dnsQuestion.dnsClass());
    }
}
