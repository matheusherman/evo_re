package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class db implements lb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private lb[] f2611a;

    @Override // com.google.android.gms.internal.measurement.lb
    public final mb a(Class<?> cls) {
        for (lb lbVar : this.f2611a) {
            if (lbVar.b(cls)) {
                return lbVar.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    @Override // com.google.android.gms.internal.measurement.lb
    public final boolean b(Class<?> cls) {
        for (lb lbVar : this.f2611a) {
            if (lbVar.b(cls)) {
                return true;
            }
        }
        return false;
    }

    db(lb... lbVarArr) {
        this.f2611a = lbVarArr;
    }
}
