package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.CharsetUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class DnsCodecUtil {
    static void encodeDomainName(String str, ByteBuf byteBuf) {
        if (".".equals(str)) {
            byteBuf.writeByte(0);
            return;
        }
        for (String str2 : str.split("\\.")) {
            int length = str2.length();
            if (length == 0) {
                break;
            }
            byteBuf.writeByte(length);
            ByteBufUtil.writeAscii(byteBuf, str2);
        }
        byteBuf.writeByte(0);
    }

    static String decodeDomainName(ByteBuf byteBuf) {
        int iWriterIndex = byteBuf.writerIndex();
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            return ".";
        }
        StringBuilder sb2 = new StringBuilder(i10 << 1);
        int i11 = 0;
        int i12 = -1;
        while (byteBuf.isReadable()) {
            short unsignedByte = byteBuf.readUnsignedByte();
            if ((unsignedByte & 192) == 192) {
                if (i12 == -1) {
                    i12 = byteBuf.readerIndex() + 1;
                }
                if (byteBuf.isReadable()) {
                    int unsignedByte2 = ((unsignedByte & 63) << 8) | byteBuf.readUnsignedByte();
                    if (unsignedByte2 < iWriterIndex) {
                        byteBuf.readerIndex(unsignedByte2);
                        i11 += 2;
                        if (i11 >= iWriterIndex) {
                            throw new CorruptedFrameException("name contains a loop.");
                        }
                    } else {
                        throw new CorruptedFrameException("name has an out-of-range pointer");
                    }
                } else {
                    throw new CorruptedFrameException("truncated pointer in a name");
                }
            } else {
                if (unsignedByte == 0) {
                    break;
                }
                if (byteBuf.isReadable(unsignedByte)) {
                    sb2.append(byteBuf.toString(byteBuf.readerIndex(), unsignedByte, CharsetUtil.UTF_8));
                    sb2.append('.');
                    byteBuf.skipBytes(unsignedByte);
                } else {
                    throw new CorruptedFrameException("truncated label in a name");
                }
            }
        }
        if (i12 != -1) {
            byteBuf.readerIndex(i12);
        }
        if (sb2.length() == 0) {
            return ".";
        }
        if (sb2.charAt(sb2.length() - 1) != '.') {
            sb2.append('.');
        }
        return sb2.toString();
    }

    static ByteBuf decompressDomainName(ByteBuf byteBuf) {
        String strDecodeDomainName = decodeDomainName(byteBuf);
        ByteBuf byteBufBuffer = byteBuf.alloc().buffer(strDecodeDomainName.length() << 1);
        encodeDomainName(strDecodeDomainName, byteBufBuffer);
        return byteBufBuffer;
    }
}
