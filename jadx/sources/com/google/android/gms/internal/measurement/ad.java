package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ad {
    static /* synthetic */ void d(byte b10, char[] cArr, int i10) {
        cArr[i10] = (char) b10;
    }

    static /* synthetic */ void c(byte b10, byte b11, char[] cArr, int i10) throws ma {
        if (b10 < -62 || e(b11)) {
            throw ma.c();
        }
        cArr[i10] = (char) (((b10 & 31) << 6) | (b11 & 63));
    }

    private static boolean e(byte b10) {
        return b10 > -65;
    }

    static /* synthetic */ void a(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws ma {
        if (!e(b11) && (((b10 << 28) + (b11 + 112)) >> 30) == 0 && !e(b12) && !e(b13)) {
            int i11 = ((b10 & 7) << 18) | ((b11 & 63) << 12) | ((b12 & 63) << 6) | (b13 & 63);
            cArr[i10] = (char) ((i11 >>> 10) + 55232);
            cArr[i10 + 1] = (char) ((i11 & 1023) + 56320);
            return;
        }
        throw ma.c();
    }

    static /* synthetic */ void b(byte b10, byte b11, byte b12, char[] cArr, int i10) throws ma {
        if (!e(b11) && ((b10 != -32 || b11 >= -96) && ((b10 != -19 || b11 < -96) && !e(b12)))) {
            cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & 63) << 6) | (b12 & 63));
            return;
        }
        throw ma.c();
    }
}
