package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bp extends m implements Cloneable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static ArrayList<bo> f8990b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<bo> f8991a = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a((Collection) this.f8991a, 0);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        if (f8990b == null) {
            f8990b = new ArrayList<>();
            f8990b.add(new bo());
        }
        this.f8991a = (ArrayList) kVar.a(f8990b, 0, true);
    }
}
