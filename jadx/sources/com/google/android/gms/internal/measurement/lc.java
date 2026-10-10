package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class lc extends mc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ gc f2835b;

    /* synthetic */ lc(gc gcVar, pc pcVar) {
        this(gcVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private lc(gc gcVar) {
        super(gcVar, null);
        this.f2835b = gcVar;
    }

    @Override // com.google.android.gms.internal.measurement.mc, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new ic(this.f2835b, null);
    }
}
