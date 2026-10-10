package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class i implements Iterator<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2757a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ g f2758b;

    i(g gVar) {
        this.f2758b = gVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2757a < this.f2758b.t();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ s next() {
        if (this.f2757a < this.f2758b.t()) {
            g gVar = this.f2758b;
            int i10 = this.f2757a;
            this.f2757a = i10 + 1;
            return gVar.q(i10);
        }
        throw new NoSuchElementException("Out of bounds index: " + this.f2757a);
    }
}
