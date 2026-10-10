package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o implements Iterator<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Iterator f2901a;

    o(Iterator it) {
        this.f2901a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2901a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ s next() {
        return new u((String) this.f2901a.next());
    }
}
