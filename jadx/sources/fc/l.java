package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10183b = new a(l.class, 24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f10184a;

    @Override // fc.z
    final boolean o() {
        return false;
    }

    protected boolean y() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f10184a;
            if (i10 == bArr.length) {
                return false;
            }
            if (bArr[i10] == 46 && i10 == 14) {
                return true;
            }
            i10++;
        }
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return l.x(q1Var.A());
        }
    }

    private boolean B(int i10) {
        byte b10;
        byte[] bArr = this.f10184a;
        return bArr.length > i10 && (b10 = bArr[i10]) >= 48 && b10 <= 57;
    }

    static l x(byte[] bArr) {
        return new l(bArr);
    }

    protected boolean A() {
        return B(12) && B(13);
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return re.a.l(this.f10184a);
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (zVar instanceof l) {
            return re.a.a(this.f10184a, ((l) zVar).f10184a);
        }
        return false;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 24, this.f10184a);
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, this.f10184a.length);
    }

    @Override // fc.z
    z v() {
        return new l1(this.f10184a);
    }

    protected boolean z() {
        return B(10) && B(11);
    }

    l(byte[] bArr) {
        if (bArr.length >= 4) {
            this.f10184a = bArr;
            if (B(0) && B(1) && B(2) && B(3)) {
                return;
            } else {
                throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
            }
        }
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }
}
