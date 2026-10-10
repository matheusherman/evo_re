package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class z8 extends b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3316a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ v8 f3318c;

    z8(v8 v8Var) {
        this.f3318c = v8Var;
        this.f3317b = v8Var.r();
    }

    @Override // com.google.android.gms.internal.measurement.c9
    public final byte b() {
        int i10 = this.f3316a;
        if (i10 >= this.f3317b) {
            throw new NoSuchElementException();
        }
        this.f3316a = i10 + 1;
        return this.f3318c.q(i10);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3316a < this.f3317b;
    }
}
