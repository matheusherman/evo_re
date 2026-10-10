package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l f4639a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l f4640b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l f4641c = new b(1);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends l {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.l
        public int f() {
            return 0;
        }

        l h(int i10) {
            if (i10 < 0) {
                return l.f4640b;
            }
            return i10 > 0 ? l.f4641c : l.f4639a;
        }

        @Override // com.google.common.collect.l
        public l d(int i10, int i11) {
            return h(g2.c.a(i10, i11));
        }

        @Override // com.google.common.collect.l
        public l e(long j10, long j11) {
            return h(g2.e.a(j10, j11));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b extends l {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f4642d;

        b(int i10) {
            super(null);
            this.f4642d = i10;
        }

        @Override // com.google.common.collect.l
        public int f() {
            return this.f4642d;
        }

        @Override // com.google.common.collect.l
        public l d(int i10, int i11) {
            return this;
        }

        @Override // com.google.common.collect.l
        public l e(long j10, long j11) {
            return this;
        }
    }

    /* synthetic */ l(a aVar) {
        this();
    }

    public abstract l d(int i10, int i11);

    public abstract l e(long j10, long j11);

    public abstract int f();

    private l() {
    }

    public static l g() {
        return f4639a;
    }
}
