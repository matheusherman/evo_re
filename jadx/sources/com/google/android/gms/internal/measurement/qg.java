package com.google.android.gms.internal.measurement;

import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class qg extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f2974c;

    public qg(b bVar) {
        super("internal.registerCallback");
        this.f2974c = bVar;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        c5.g(this.f2886a, 3, list);
        String strF = v6Var.b(list.get(0)).f();
        s sVarB = v6Var.b(list.get(1));
        if (!(sVarB instanceof t)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        s sVarB2 = v6Var.b(list.get(2));
        if (!(sVarB2 instanceof r)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        r rVar = (r) sVarB2;
        if (!rVar.n(IjkMediaMeta.IJKM_KEY_TYPE)) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        this.f2974c.c(strF, rVar.n("priority") ? c5.i(rVar.i("priority").g().doubleValue()) : 1000, (t) sVarB, rVar.i(IjkMediaMeta.IJKM_KEY_TYPE).f());
        return s.f3010a0;
    }
}
