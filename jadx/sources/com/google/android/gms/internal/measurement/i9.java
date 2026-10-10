package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class i9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f2773b = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2774a;

    /* synthetic */ i9(k9 k9Var) {
        this();
    }

    public static long b(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public abstract int d(int i10);

    public abstract int e();

    private i9() {
        this.f2774a = f2773b;
    }

    public static int a(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    static i9 c(byte[] bArr, int i10, int i11, boolean z10) {
        l9 l9Var = new l9(bArr, 0, i11, false, null);
        try {
            l9Var.d(i11);
            return l9Var;
        } catch (ma e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
