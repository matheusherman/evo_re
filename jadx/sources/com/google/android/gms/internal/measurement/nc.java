package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class nc implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Iterator f2897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ gc f2898d;

    /* synthetic */ nc(gc gcVar, pc pcVar) {
        this(gcVar);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f2896b = true;
        int i10 = this.f2895a + 1;
        this.f2895a = i10;
        return i10 < this.f2898d.f2720b ? (kc) this.f2898d.f2719a[this.f2895a] : (Map.Entry) c().next();
    }

    private nc(gc gcVar) {
        this.f2898d = gcVar;
        this.f2895a = -1;
    }

    private final Iterator c() {
        if (this.f2897c == null) {
            this.f2897c = this.f2898d.f2721c.entrySet().iterator();
        }
        return this.f2897c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2895a + 1 < this.f2898d.f2720b || (!this.f2898d.f2721c.isEmpty() && c().hasNext());
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f2896b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f2896b = false;
        this.f2898d.r();
        if (this.f2895a >= this.f2898d.f2720b) {
            c().remove();
            return;
        }
        gc gcVar = this.f2898d;
        int i10 = this.f2895a;
        this.f2895a = i10 - 1;
        gcVar.i(i10);
    }
}
