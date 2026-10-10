package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class k0 implements Comparator<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ n f2795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ v6 f2796b;

    k0(n nVar, v6 v6Var) {
        this.f2795a = nVar;
        this.f2796b = v6Var;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(s sVar, s sVar2) {
        s sVar3 = sVar;
        s sVar4 = sVar2;
        n nVar = this.f2795a;
        v6 v6Var = this.f2796b;
        if (sVar3 instanceof z) {
            return !(sVar4 instanceof z) ? 1 : 0;
        }
        if (sVar4 instanceof z) {
            return -1;
        }
        return nVar == null ? sVar3.f().compareTo(sVar4.f()) : (int) c5.a(nVar.a(v6Var, Arrays.asList(sVar3, sVar4)).g().doubleValue());
    }
}
