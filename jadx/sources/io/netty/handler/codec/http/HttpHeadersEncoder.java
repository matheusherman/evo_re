package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class HttpHeadersEncoder {
    private static void writeAscii(ByteBuf byteBuf, int i10, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i10, charSequence.length());
        } else {
            byteBuf.setCharSequence(i10, charSequence, CharsetUtil.US_ASCII);
        }
    }

    static void encoderHeader(CharSequence charSequence, CharSequence charSequence2, ByteBuf byteBuf) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        byteBuf.ensureWritable(length + length2 + 4);
        int iWriterIndex = byteBuf.writerIndex();
        writeAscii(byteBuf, iWriterIndex, charSequence);
        int i10 = iWriterIndex + length;
        ByteBufUtil.setShortBE(byteBuf, i10, 14880);
        int i11 = i10 + 2;
        writeAscii(byteBuf, i11, charSequence2);
        int i12 = i11 + length2;
        ByteBufUtil.setShortBE(byteBuf, i12, 3338);
        byteBuf.writerIndex(i12 + 2);
    }
}
