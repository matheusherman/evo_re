package tb;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0010¢\u0006\u0004\b$\u0010%J/\u0010)\u001a\u00020(2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0016¢\u0006\u0004\b)\u0010*J/\u0010+\u001a\u00020(2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0003H\u0010¢\u0006\u0004\b-\u0010\u001eJ\u001a\u0010/\u001a\u00020(2\b\u0010&\u001a\u0004\u0018\u00010.H\u0096\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0016H\u0016¢\u0006\u0004\b1\u0010\u001cJ\u000f\u00102\u001a\u00020\u000eH\u0016¢\u0006\u0004\b2\u0010\u0010R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006;"}, d2 = {"Ltb/w;", "Ltb/g;", "", "", "segments", "", "directory", "<init>", "([[B[I)V", "J", "()Ltb/g;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "", "a", "()Ljava/lang/String;", "o", "z", "algorithm", "i", "(Ljava/lang/String;)Ltb/g;", "", "pos", "", "q", "(I)B", "m", "()I", "G", "()[B", "Ltb/d;", "buffer", "offset", "byteCount", "Lr8/z;", "B", "(Ltb/d;II)V", TransactionPartnerType.OTHER, "otherOffset", "", "r", "(ILtb/g;II)Z", "s", "(I[BII)Z", "p", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "e", "[[B", "F", "()[[B", "f", "[I", "C", "()[I", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class w extends g {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final transient byte[][] segments;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final transient int[] directory;

    @Override // tb.g
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof g) {
            g gVar = (g) other;
            if (gVar.x() == x() && r(0, gVar, 0, x())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(byte[][] segments, int[] directory) {
        super(g.f19051d.getData());
        kotlin.jvm.internal.m.f(segments, "segments");
        kotlin.jvm.internal.m.f(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final g J() {
        return new g(G());
    }

    @Override // tb.g
    public void B(d buffer, int offset, int byteCount) {
        kotlin.jvm.internal.m.f(buffer, "buffer");
        int i10 = offset + byteCount;
        int iB = ub.c.b(this, offset);
        while (offset < i10) {
            int i11 = iB == 0 ? 0 : getDirectory()[iB - 1];
            int i12 = getDirectory()[iB] - i11;
            int i13 = getDirectory()[getSegments().length + iB];
            int iMin = Math.min(i10, i12 + i11) - offset;
            int i14 = i13 + (offset - i11);
            u uVar = new u(getSegments()[iB], i14, i14 + iMin, true, false);
            u uVar2 = buffer.head;
            if (uVar2 == null) {
                uVar.prev = uVar;
                uVar.next = uVar;
                buffer.head = uVar;
            } else {
                kotlin.jvm.internal.m.c(uVar2);
                u uVar3 = uVar2.prev;
                kotlin.jvm.internal.m.c(uVar3);
                uVar3.c(uVar);
            }
            offset += iMin;
            iB++;
        }
        buffer.z(buffer.getSize() + ((long) byteCount));
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    /* JADX INFO: renamed from: F, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // tb.g
    public g i(String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.m.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory()[length + i10];
            int i13 = getDirectory()[i10];
            messageDigest.update(getSegments()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.m.c(bArrDigest);
        return new g(bArrDigest);
    }

    @Override // tb.g
    public boolean r(int offset, g other, int otherOffset, int byteCount) {
        kotlin.jvm.internal.m.f(other, "other");
        if (offset < 0 || offset > x() - byteCount) {
            return false;
        }
        int i10 = byteCount + offset;
        int iB = ub.c.b(this, offset);
        while (offset < i10) {
            int i11 = iB == 0 ? 0 : getDirectory()[iB - 1];
            int i12 = getDirectory()[iB] - i11;
            int i13 = getDirectory()[getSegments().length + iB];
            int iMin = Math.min(i10, i12 + i11) - offset;
            if (!other.s(otherOffset, getSegments()[iB], i13 + (offset - i11), iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iB++;
        }
        return true;
    }

    @Override // tb.g
    public boolean s(int offset, byte[] other, int otherOffset, int byteCount) {
        kotlin.jvm.internal.m.f(other, "other");
        if (offset < 0 || offset > x() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i10 = byteCount + offset;
        int iB = ub.c.b(this, offset);
        while (offset < i10) {
            int i11 = iB == 0 ? 0 : getDirectory()[iB - 1];
            int i12 = getDirectory()[iB] - i11;
            int i13 = getDirectory()[getSegments().length + iB];
            int iMin = Math.min(i10, i12 + i11) - offset;
            if (!b.a(getSegments()[iB], i13 + (offset - i11), other, otherOffset, iMin)) {
                return false;
            }
            otherOffset += iMin;
            offset += iMin;
            iB++;
        }
        return true;
    }

    private final Object writeReplace() {
        g gVarJ = J();
        kotlin.jvm.internal.m.d(gVarJ, "null cannot be cast to non-null type java.lang.Object");
        return gVarJ;
    }

    public byte[] G() {
        byte[] bArr = new byte[x()];
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory()[length + i10];
            int i14 = getDirectory()[i10];
            int i15 = i14 - i11;
            kotlin.collections.j.e(getSegments()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // tb.g
    public String a() {
        return J().a();
    }

    @Override // tb.g
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i10 < length) {
            int i13 = getDirectory()[length + i10];
            int i14 = getDirectory()[i10];
            byte[] bArr = getSegments()[i10];
            int i15 = (i14 - i11) + i13;
            while (i13 < i15) {
                i12 = (i12 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i11 = i14;
        }
        t(i12);
        return i12;
    }

    @Override // tb.g
    public int m() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // tb.g
    public String o() {
        return J().o();
    }

    @Override // tb.g
    public byte[] p() {
        return G();
    }

    @Override // tb.g
    public byte q(int pos) {
        int i10;
        b.b(getDirectory()[getSegments().length - 1], pos, 1L);
        int iB = ub.c.b(this, pos);
        if (iB == 0) {
            i10 = 0;
        } else {
            i10 = getDirectory()[iB - 1];
        }
        return getSegments()[iB][(pos - i10) + getDirectory()[getSegments().length + iB]];
    }

    @Override // tb.g
    public String toString() {
        return J().toString();
    }

    @Override // tb.g
    public g z() {
        return J().z();
    }
}
