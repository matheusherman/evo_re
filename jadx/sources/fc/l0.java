package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class l0 extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10185b = new a(l0.class, 28);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f10186c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f10187a;

    @Override // fc.z
    final boolean o() {
        return false;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return l0.x(q1Var.A());
        }
    }

    static l0 x(byte[] bArr) {
        return new z1(bArr, false);
    }

    private static void y(StringBuffer stringBuffer, int i10) {
        char[] cArr = f10186c;
        stringBuffer.append(cArr[(i10 >>> 4) & 15]);
        stringBuffer.append(cArr[i10 & 15]);
    }

    private static void z(StringBuffer stringBuffer, int i10) {
        int i11;
        if (i10 < 128) {
            y(stringBuffer, i10);
            return;
        }
        byte[] bArr = new byte[5];
        int i12 = 5;
        while (true) {
            i11 = i12 - 1;
            bArr[i11] = (byte) i10;
            i10 >>>= 8;
            if (i10 == 0) {
                break;
            } else {
                i12 = i11;
            }
        }
        int i13 = i12 - 2;
        bArr[i13] = (byte) ((5 - i11) | 128);
        while (true) {
            int i14 = i13 + 1;
            y(stringBuffer, bArr[i13]);
            if (i14 >= 5) {
                return;
            } else {
                i13 = i14;
            }
        }
    }

    public final String A() {
        int length = this.f10187a.length;
        StringBuffer stringBuffer = new StringBuffer(((x.f(length) + length) * 2) + 3);
        stringBuffer.append("#1C");
        z(stringBuffer, length);
        for (int i10 = 0; i10 < length; i10++) {
            y(stringBuffer, this.f10187a[i10]);
        }
        return stringBuffer.toString();
    }

    @Override // fc.z, fc.s
    public final int hashCode() {
        return re.a.l(this.f10187a);
    }

    @Override // fc.z
    final boolean m(z zVar) {
        if (zVar instanceof l0) {
            return re.a.a(this.f10187a, ((l0) zVar).f10187a);
        }
        return false;
    }

    @Override // fc.z
    final void n(x xVar, boolean z10) {
        xVar.o(z10, 28, this.f10187a);
    }

    @Override // fc.z
    final int s(boolean z10) {
        return x.g(z10, this.f10187a.length);
    }

    l0(byte[] bArr, boolean z10) {
        this.f10187a = z10 ? re.a.d(bArr) : bArr;
    }

    public String toString() {
        return A();
    }
}
