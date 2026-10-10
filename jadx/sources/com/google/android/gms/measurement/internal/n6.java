package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.mg;
import com.google.android.gms.internal.measurement.pg;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class n6 implements pg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ j6 f3835a;

    n6(j6 j6Var) {
        this.f3835a = j6Var;
    }

    @Override // com.google.android.gms.internal.measurement.pg
    public final void a(mg mgVar, String str, List<String> list, boolean z10, boolean z11) {
        r5 r5VarG;
        int i10 = o6.f3856a[mgVar.ordinal()];
        if (i10 == 1) {
            r5VarG = this.f3835a.l().G();
        } else if (i10 != 2) {
            if (i10 != 3) {
                r5VarG = i10 != 4 ? this.f3835a.l().K() : this.f3835a.l().L();
            } else if (z10) {
                r5VarG = this.f3835a.l().O();
            } else {
                r5VarG = !z11 ? this.f3835a.l().N() : this.f3835a.l().M();
            }
        } else if (z10) {
            r5VarG = this.f3835a.l().J();
        } else {
            r5VarG = !z11 ? this.f3835a.l().I() : this.f3835a.l().H();
        }
        int size = list.size();
        if (size == 1) {
            r5VarG.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            r5VarG.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            r5VarG.a(str);
        } else {
            r5VarG.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
