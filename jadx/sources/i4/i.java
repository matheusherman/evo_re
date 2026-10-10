package i4;

import h3.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11051a;

    public void a(s[] sVarArr) {
        if (!this.f11051a || sVarArr == null || sVarArr.length < 3) {
            return;
        }
        s sVar = sVarArr[0];
        sVarArr[0] = sVarArr[2];
        sVarArr[2] = sVar;
    }

    i(boolean z10) {
        this.f11051a = z10;
    }
}
