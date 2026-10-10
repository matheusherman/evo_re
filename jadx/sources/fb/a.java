package fb;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {
    public static byte[] c(ByteBuffer byteBuffer, int i10) {
        byte[] bArr = new byte[i10];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static String d(ByteBuffer byteBuffer, int i10) {
        StringBuilder sb2 = new StringBuilder(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(byteBuffer.getChar());
        }
        return sb2.toString();
    }

    public static String h(ByteBuffer byteBuffer, int i10) {
        StringBuilder sb2 = new StringBuilder(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            char c10 = byteBuffer.getChar();
            if (c10 == 0) {
                i(byteBuffer, ((i10 - i11) - 1) * 2);
                break;
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    public static void a(ByteBuffer byteBuffer, int i10) {
        byteBuffer.position(i10);
    }

    public static void b(ByteBuffer byteBuffer, long j10) {
        a(byteBuffer, h.a(j10));
    }

    public static short e(ByteBuffer byteBuffer) {
        return (short) (byteBuffer.get() & 255);
    }

    public static long f(ByteBuffer byteBuffer) {
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public static int g(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    public static void i(ByteBuffer byteBuffer, int i10) {
        a(byteBuffer, byteBuffer.position() + i10);
    }
}
