package x1.f1.lb.util;

import java.security.MessageDigest;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0014\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018¨\u0006\u001b"}, d2 = {"Lx1/f1/lb/util/o;", "", "<init>", "()V", "", "bytes", "", "a", "([B)Ljava/lang/String;", "data", "", "toDigits", "d", "([B[C)[C", "b", "([B)[C", "", "toLowerCase", "c", "([BZ)[C", "", "keys", "e", "([Ljava/lang/Object;)Ljava/lang/String;", "[C", "DIGITS_LOWER", "DIGITS_UPPER", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f21430a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private final char[] d(byte[] data, char[] toDigits) {
        char[] cArr = new char[data.length << 1];
        int i10 = 0;
        for (byte b10 : data) {
            int i11 = i10 + 1;
            cArr[i10] = toDigits[(b10 & 240) >>> 4];
            i10 += 2;
            cArr[i11] = toDigits[b10 & 15];
        }
        return cArr;
    }

    private final String a(byte[] bytes) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bytes) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    public final char[] b(byte[] data) {
        kotlin.jvm.internal.m.f(data, "data");
        return c(data, true);
    }

    public final char[] c(byte[] data, boolean toLowerCase) {
        kotlin.jvm.internal.m.f(data, "data");
        return d(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public final String e(Object... keys) {
        kotlin.jvm.internal.m.f(keys, "keys");
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : keys) {
            if (obj == null) {
                sb2.append("null.");
            } else {
                sb2.append(obj);
                sb2.append(".");
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = string.getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            kotlin.jvm.internal.m.e(bArrDigest, "digest(...)");
            return a(bArrDigest);
        } catch (Throwable unused) {
            return String.valueOf(string.hashCode());
        }
    }

    private o() {
    }
}
