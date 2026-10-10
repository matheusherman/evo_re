package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class bm extends m implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList<String> f8957c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8958a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f8959b = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f8958a, 0);
        ArrayList<String> arrayList = this.f8959b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f8958a = kVar.b(0, true);
        if (f8957c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f8957c = arrayList;
            arrayList.add("");
        }
        this.f8959b = (ArrayList) kVar.a(f8957c, 1, false);
    }
}
