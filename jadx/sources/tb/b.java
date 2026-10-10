package tb;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\u0014*\u00020\nH\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001b\u0010\u001b\u001a\u00020\n*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001b\u0010\u001e\u001a\u00020\n*\u00020\r2\u0006\u0010\u001d\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\" \u0010&\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010!\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#\"\u001a\u0010*\u001a\u00020\n8\u0000X\u0080D¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"", "size", "offset", "byteCount", "Lr8/z;", "b", "(JJJ)V", "", "g", "(S)S", "", "f", "(I)I", "", "a", "aOffset", "bOffset", "", "([BI[BII)Z", "", "", "h", "(B)Ljava/lang/String;", "i", "(I)Ljava/lang/String;", "Ltb/g;", "position", "d", "(Ltb/g;I)I", "sizeParam", "e", "([BI)I", "Ltb/d$a;", "Ltb/d$a;", "getDEFAULT__new_UnsafeCursor", "()Ltb/d$a;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "DEFAULT__new_UnsafeCursor", "I", "c", "()I", "DEFAULT__ByteString_size", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.a f19025a = new d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f19026b = -1234567890;

    public static final boolean a(byte[] a10, int i10, byte[] b10, int i11, int i12) {
        kotlin.jvm.internal.m.f(a10, "a");
        kotlin.jvm.internal.m.f(b10, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (a10[i13 + i10] != b10[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int c() {
        return f19026b;
    }

    public static final int d(g gVar, int i10) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        return i10 == f19026b ? gVar.x() : i10;
    }

    public static final int e(byte[] bArr, int i10) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        return i10 == f19026b ? bArr.length : i10;
    }

    public static final int f(int i10) {
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final String i(int i10) {
        if (i10 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {ub.b.f()[(i10 >> 28) & 15], ub.b.f()[(i10 >> 24) & 15], ub.b.f()[(i10 >> 20) & 15], ub.b.f()[(i10 >> 16) & 15], ub.b.f()[(i10 >> 12) & 15], ub.b.f()[(i10 >> 8) & 15], ub.b.f()[(i10 >> 4) & 15], ub.b.f()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return ua.n.s(cArr, i11, 8);
    }

    public static final short g(short s10) {
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >>> 8));
    }

    public static final String h(byte b10) {
        return ua.n.r(new char[]{ub.b.f()[(b10 >> 4) & 15], ub.b.f()[b10 & 15]});
    }
}
