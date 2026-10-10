package o8;

import io.reactivex.rxjava3.internal.util.e;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d<T> implements c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f16501i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f16502j = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f16504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f16505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f16506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AtomicReferenceArray<Object> f16507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f16508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    AtomicReferenceArray<Object> f16509g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicLong f16503a = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicLong f16510h = new AtomicLong();

    private static int c(long j10, int i10) {
        return b(((int) j10) & i10);
    }

    private void a(int i10) {
        this.f16504b = Math.min(i10 / 4, f16501i);
    }

    private long d() {
        return this.f16510h.get();
    }

    private long e() {
        return this.f16503a.get();
    }

    private long f() {
        return this.f16510h.get();
    }

    private long i() {
        return this.f16503a.get();
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f16509g = atomicReferenceArray;
        int iC = c(j10, i10);
        T t10 = (T) g(atomicReferenceArray, iC);
        if (t10 != null) {
            n(atomicReferenceArray, iC, null);
            m(j10 + 1);
        }
        return t10;
    }

    private void m(long j10) {
        this.f16510h.lazySet(j10);
    }

    private void p(long j10) {
        this.f16503a.lazySet(j10);
    }

    @Override // o8.c
    public boolean offer(T t10) {
        if (t10 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f16507e;
        long jE = e();
        int i10 = this.f16506d;
        int iC = c(jE, i10);
        if (jE < this.f16505c) {
            return q(atomicReferenceArray, t10, jE, iC);
        }
        long j10 = ((long) this.f16504b) + jE;
        if (g(atomicReferenceArray, c(j10, i10)) == null) {
            this.f16505c = j10 - 1;
            return q(atomicReferenceArray, t10, jE, iC);
        }
        if (g(atomicReferenceArray, c(jE + 1, i10)) == null) {
            return q(atomicReferenceArray, t10, jE, iC);
        }
        l(atomicReferenceArray, jE, iC, t10, i10);
        return true;
    }

    @Override // o8.c
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f16509g;
        long jD = d();
        int i10 = this.f16508f;
        int iC = c(jD, i10);
        T t10 = (T) g(atomicReferenceArray, iC);
        boolean z10 = t10 == f16502j;
        if (t10 == null || z10) {
            if (z10) {
                return k(h(atomicReferenceArray, i10 + 1), jD, i10);
            }
            return null;
        }
        n(atomicReferenceArray, iC, null);
        m(jD + 1);
        return t10;
    }

    public d(int i10) {
        int iA = e.a(Math.max(8, i10));
        int i11 = iA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iA + 1);
        this.f16507e = atomicReferenceArray;
        this.f16506d = i11;
        a(iA);
        this.f16509g = atomicReferenceArray;
        this.f16508f = i11;
        this.f16505c = iA - 2;
        p(0L);
    }

    private static Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        int iB = b(i10);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, iB);
        n(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    private void l(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10, T t10, long j11) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f16507e = atomicReferenceArray2;
        this.f16505c = (j11 + j10) - 1;
        n(atomicReferenceArray2, i10, t10);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i10, f16502j);
        p(j10 + 1);
    }

    private static void n(AtomicReferenceArray<Object> atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private boolean q(AtomicReferenceArray<Object> atomicReferenceArray, T t10, long j10, int i10) {
        n(atomicReferenceArray, i10, t10);
        p(j10 + 1);
        return true;
    }

    @Override // o8.c
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // o8.c
    public boolean isEmpty() {
        if (i() == f()) {
            return true;
        }
        return false;
    }

    private static int b(int i10) {
        return i10;
    }
}
