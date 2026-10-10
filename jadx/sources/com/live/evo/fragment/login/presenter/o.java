package com.live.evo.fragment.login.presenter;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f6339a;

    @Override // k5.a
    public void u() {
        this.f6339a = null;
    }

    @Override // com.live.evo.fragment.login.presenter.m
    public void n(Context context, String str, String str2) {
        n nVar = this.f6339a;
        if (nVar == null) {
            return;
        }
        nVar.b();
    }

    @Override // k5.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void r(n nVar) {
        this.f6339a = nVar;
    }
}
