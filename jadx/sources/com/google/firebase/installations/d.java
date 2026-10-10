package com.google.firebase.installations;

import e2.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final h<String> f4782a;

    @Override // com.google.firebase.installations.e
    public boolean b(Exception exc) {
        return false;
    }

    public d(h<String> hVar) {
        this.f4782a = hVar;
    }

    @Override // com.google.firebase.installations.e
    public boolean a(u2.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f4782a.e(dVar.d());
        return true;
    }
}
