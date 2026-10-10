package io.netty.buffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class HeapByteBufUtil {
    static void setByte(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) i11;
    }

    static byte getByte(byte[] bArr, int i10) {
        return bArr[i10];
    }

    static int getInt(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    static int getIntLE(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    static long getLong(byte[] bArr, int i10) {
        return (((long) bArr[i10 + 7]) & 255) | ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8);
    }

    static short getShort(byte[] bArr, int i10) {
        return (short) ((bArr[i10 + 1] & 255) | (bArr[i10] << 8));
    }

    static short getShortLE(byte[] bArr, int i10) {
        return (short) ((bArr[i10 + 1] << 8) | (bArr[i10] & 255));
    }

    static void setInt(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >>> 24);
        bArr[i10 + 1] = (byte) (i11 >>> 16);
        bArr[i10 + 2] = (byte) (i11 >>> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    static void setMedium(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >>> 16);
        bArr[i10 + 1] = (byte) (i11 >>> 8);
        bArr[i10 + 2] = (byte) i11;
    }

    static void setShort(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >>> 8);
        bArr[i10 + 1] = (byte) i11;
    }
}
