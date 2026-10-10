package tb;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0016\u0018\u0000 L2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0012J\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0010¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001cH\u0087\u0002¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\u001cH\u0010¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H\u0010¢\u0006\u0004\b%\u0010&J'\u0010+\u001a\u00020\t2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001cH\u0010¢\u0006\u0004\b+\u0010,J/\u00100\u001a\u00020/2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001cH\u0016¢\u0006\u0004\b0\u00101J/\u00102\u001a\u00020/2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001cH\u0016¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020/2\u0006\u00104\u001a\u00020\u0000¢\u0006\u0004\b5\u00106J\u001a\u00108\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u000107H\u0096\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u001cH\u0016¢\u0006\u0004\b:\u0010$J\u0018\u0010;\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0010H\u0016¢\u0006\u0004\b=\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010>\u001a\u0004\b?\u0010&R\"\u0010:\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010@\u001a\u0004\bA\u0010$\"\u0004\bB\u0010CR$\u0010I\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010HR\u0011\u0010K\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\bJ\u0010$¨\u0006M"}, d2 = {"Ltb/g;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "Ljava/io/ObjectInputStream;", "in", "Lr8/z;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/String;", "a", "v", "()Ltb/g;", "w", "algorithm", "i", "(Ljava/lang/String;)Ltb/g;", "o", "z", "", "pos", "", "q", "(I)B", "index", "j", "m", "()I", "p", "()[B", "Ltb/d;", "buffer", "offset", "byteCount", "B", "(Ltb/d;II)V", TransactionPartnerType.OTHER, "otherOffset", "", "r", "(ILtb/g;II)Z", "s", "(I[BII)Z", "prefix", "y", "(Ltb/g;)Z", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "f", "(Ltb/g;)I", "toString", "[B", "k", "I", "l", "t", "(I)V", "b", "Ljava/lang/String;", "n", "u", "(Ljava/lang/String;)V", "utf8", "x", "size", "c", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class g implements Serializable, Comparable<g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f19051d = new g(new byte[0]);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private transient int hashCode;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private transient String utf8;
    private final byte[] data;

    /* JADX INFO: renamed from: tb.g$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b*\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\b*\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\b*\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\b*\u00020\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0014\u001a\u00020\b*\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ltb/g$a;", "", "<init>", "()V", "", "", "offset", "byteCount", "Ltb/g;", "d", "([BII)Ltb/g;", "", "c", "(Ljava/lang/String;)Ltb/g;", "Ljava/nio/charset/Charset;", "charset", "b", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Ltb/g;", "a", "Ljava/io/InputStream;", "f", "(Ljava/io/InputStream;I)Ltb/g;", "EMPTY", "Ltb/g;", "", "serialVersionUID", "J", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ g e(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = b.c();
            }
            return companion.d(bArr, i10, i11);
        }

        public final g a(String str) {
            kotlin.jvm.internal.m.f(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) ((ub.b.e(str.charAt(i11)) << 4) + ub.b.e(str.charAt(i11 + 1)));
            }
            return new g(bArr);
        }

        public final g b(String str, Charset charset) {
            kotlin.jvm.internal.m.f(str, "<this>");
            kotlin.jvm.internal.m.f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.m.e(bytes, "this as java.lang.String).getBytes(charset)");
            return new g(bytes);
        }

        public final g c(String str) {
            kotlin.jvm.internal.m.f(str, "<this>");
            g gVar = new g(c0.a(str));
            gVar.u(str);
            return gVar;
        }

        public final g d(byte[] bArr, int i10, int i11) {
            kotlin.jvm.internal.m.f(bArr, "<this>");
            int iE = b.e(bArr, i11);
            b.b(bArr.length, i10, iE);
            return new g(kotlin.collections.j.o(bArr, i10, iE + i10));
        }

        public final g f(InputStream inputStream, int i10) throws IOException {
            kotlin.jvm.internal.m.f(inputStream, "<this>");
            if (i10 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
            }
            byte[] bArr = new byte[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = inputStream.read(bArr, i11, i10 - i11);
                if (i12 == -1) {
                    throw new EOFException();
                }
                i11 += i12;
            }
            return new g(bArr);
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof g) {
            g gVar = (g) other;
            if (gVar.x() == getData().length && gVar.s(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    public g z() {
        for (int i10 = 0; i10 < getData().length; i10++) {
            byte b10 = getData()[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] data = getData();
                byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
                kotlin.jvm.internal.m.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b11 = bArrCopyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new g(bArrCopyOf);
            }
        }
        return this;
    }

    public g(byte[] data) {
        kotlin.jvm.internal.m.f(data, "data");
        this.data = data;
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    public void B(d buffer, int offset, int byteCount) {
        kotlin.jvm.internal.m.f(buffer, "buffer");
        ub.b.d(this, buffer, offset, byteCount);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(g other) {
        kotlin.jvm.internal.m.f(other, "other");
        int iX = x();
        int iX2 = other.x();
        int iMin = Math.min(iX, iX2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iJ = j(i10) & 255;
            int iJ2 = other.j(i10) & 255;
            if (iJ != iJ2) {
                return iJ < iJ2 ? -1 : 1;
            }
        }
        if (iX == iX2) {
            return 0;
        }
        return iX < iX2 ? -1 : 1;
    }

    public g i(String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.m.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, x());
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.m.c(bArrDigest);
        return new g(bArrDigest);
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public boolean r(int offset, g other, int otherOffset, int byteCount) {
        kotlin.jvm.internal.m.f(other, "other");
        return other.s(otherOffset, getData(), offset, byteCount);
    }

    public boolean s(int offset, byte[] other, int otherOffset, int byteCount) {
        kotlin.jvm.internal.m.f(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && b.a(getData(), offset, other, otherOffset, byteCount);
    }

    public final void t(int i10) {
        this.hashCode = i10;
    }

    public final void u(String str) {
        this.utf8 = str;
    }

    public final g v() {
        return i("SHA-1");
    }

    public final g w() {
        return i("SHA-256");
    }

    public final boolean y(g prefix) {
        kotlin.jvm.internal.m.f(prefix, "prefix");
        return r(0, prefix, 0, prefix.x());
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException {
        g gVarF = INSTANCE.f(in, in.readInt());
        Field declaredField = g.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, gVarF.data);
    }

    public String A() {
        String utf8 = getUtf8();
        if (utf8 == null) {
            String strB = c0.b(p());
            u(strB);
            return strB;
        }
        return utf8;
    }

    public String a() {
        return a.b(getData(), null, 1, null);
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int iHashCode = Arrays.hashCode(getData());
        t(iHashCode);
        return iHashCode;
    }

    public final byte j(int index) {
        return q(index);
    }

    public int m() {
        return getData().length;
    }

    public String o() {
        char[] cArr = new char[getData().length * 2];
        int i10 = 0;
        for (byte b10 : getData()) {
            int i11 = i10 + 1;
            cArr[i10] = ub.b.f()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = ub.b.f()[b10 & 15];
        }
        return ua.n.r(cArr);
    }

    public byte[] p() {
        return getData();
    }

    public byte q(int pos) {
        return getData()[pos];
    }

    public String toString() {
        g gVar;
        if (getData().length != 0) {
            int iC = ub.b.c(getData(), 64);
            if (iC == -1) {
                if (getData().length <= 64) {
                    return "[hex=" + o() + ']';
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(getData().length);
                sb2.append(" hex=");
                int iD = b.d(this, 64);
                if (iD <= getData().length) {
                    if (iD >= 0) {
                        if (iD == getData().length) {
                            gVar = this;
                        } else {
                            gVar = new g(kotlin.collections.j.o(getData(), 0, iD));
                        }
                        sb2.append(gVar.o());
                        sb2.append("…]");
                        return sb2.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex");
                }
                throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
            }
            String strA = A();
            String strSubstring = strA.substring(0, iC);
            kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strE = ua.n.E(ua.n.E(ua.n.E(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iC < strA.length()) {
                return "[size=" + getData().length + " text=" + strE + "…]";
            }
            return "[text=" + strE + ']';
        }
        return "[size=0]";
    }

    public final int x() {
        return m();
    }
}
