package com.google.common.collect;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class m extends t<Object, Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final m f4645d = new m();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f4645d;
    }

    private m() {
        super(q.i(), 0, null);
    }

    @Override // com.google.common.collect.r, com.google.common.collect.d, com.google.common.collect.a0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public q<Object, Collection<Object>> a() {
        return super.a();
    }
}
