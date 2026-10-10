package fb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h {
    public static long b(int i10) {
        return ((long) i10) & 4294967295L;
    }

    public static byte d(short s10) {
        return (byte) s10;
    }

    public static int e(long j10) {
        return (int) j10;
    }

    public static short f(int i10) {
        return (short) i10;
    }

    public static int a(long j10) {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new ArithmeticException("unsigned integer overflow");
        }
        return (int) j10;
    }

    public static short c(byte b10) {
        return (short) (b10 & 255);
    }
}
