package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class ic implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Iterator f2777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ gc f2778c;

    /* synthetic */ ic(gc gcVar, pc pcVar) {
        this(gcVar);
    }

    private ic(gc gcVar) {
        this.f2778c = gcVar;
        this.f2776a = gcVar.f2720b;
    }

    private final Iterator c() {
        if (this.f2777b == null) {
            this.f2777b = this.f2778c.f2724f.entrySet().iterator();
        }
        return this.f2777b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.f2776a;
        return (i10 > 0 && i10 <= this.f2778c.f2720b) || c().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (!c().hasNext()) {
            Object[] objArr = this.f2778c.f2719a;
            int i10 = this.f2776a - 1;
            this.f2776a = i10;
            return (kc) objArr[i10];
        }
        return (Map.Entry) c().next();
    }
}
