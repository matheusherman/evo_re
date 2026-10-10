package fc;

import org.apache.log4j.helpers.DateLayout;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class q extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final m0 f10210a = new a(q.class, 5);

    static q x(byte[] bArr) {
        if (bArr.length == 0) {
            return o1.f10200b;
        }
        throw new IllegalStateException("malformed NULL encoding encountered");
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        return -1;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z d(q1 q1Var) {
            return q.x(q1Var.A());
        }
    }

    @Override // fc.z
    boolean m(z zVar) {
        return zVar instanceof q;
    }

    public String toString() {
        return DateLayout.NULL_DATE_FORMAT;
    }

    q() {
    }
}
