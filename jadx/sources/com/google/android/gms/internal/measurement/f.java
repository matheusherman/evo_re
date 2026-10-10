package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class f implements Iterator<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Iterator f2668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Iterator f2669b;

    f(g gVar, Iterator it, Iterator it2) {
        this.f2668a = it;
        this.f2669b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2668a.hasNext()) {
            return true;
        }
        return this.f2669b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ s next() {
        if (this.f2668a.hasNext()) {
            return new u(((Integer) this.f2668a.next()).toString());
        }
        if (this.f2669b.hasNext()) {
            return new u((String) this.f2669b.next());
        }
        throw new NoSuchElementException();
    }
}
