package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j0 extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10174b = new a(j0.class, 23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f10175a;

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
            return j0.x(q1Var.A());
        }
    }

    static j0 x(byte[] bArr) {
        return new j0(bArr);
    }

    private boolean y(int i10) {
        byte b10;
        byte[] bArr = this.f10175a;
        return bArr.length > i10 && (b10 = bArr[i10]) >= 48 && b10 <= 57;
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return re.a.l(this.f10175a);
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (zVar instanceof j0) {
            return re.a.a(this.f10175a, ((j0) zVar).f10175a);
        }
        return false;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 23, this.f10175a);
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, this.f10175a.length);
    }

    public String toString() {
        return re.h.b(this.f10175a);
    }

    j0(byte[] bArr) {
        if (bArr.length >= 2) {
            this.f10175a = bArr;
            if (y(0) && y(1)) {
                return;
            } else {
                throw new IllegalArgumentException("illegal characters in UTCTime string");
            }
        }
        throw new IllegalArgumentException("UTCTime string too short");
    }
}
