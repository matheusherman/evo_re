package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final m0 f10136b = new a(e.class, 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f10137c = new e((byte) 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f10138d = new e((byte) -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f10139a;

    static e x(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b10 = bArr[0];
        if (b10 != -1) {
            return b10 != 0 ? new e(b10) : f10137c;
        }
        return f10138d;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        xVar.m(z10, 1, this.f10139a);
    }

    @Override // fc.z
    boolean o() {
        return false;
    }

    @Override // fc.z
    int s(boolean z10) {
        return x.g(z10, 1);
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return e.x(q1Var.A());
        }
    }

    @Override // fc.z
    boolean m(z zVar) {
        return (zVar instanceof e) && y() == ((e) zVar).y();
    }

    public boolean y() {
        return this.f10139a != 0;
    }

    private e(byte b10) {
        this.f10139a = b10;
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return y() ? 1 : 0;
    }

    public String toString() {
        if (y()) {
            return "TRUE";
        }
        return "FALSE";
    }

    @Override // fc.z
    z v() {
        if (y()) {
            return f10138d;
        }
        return f10137c;
    }
}
