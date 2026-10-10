package com.google.android.gms.internal.measurement;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class o1 implements m1 {
    @Override // com.google.android.gms.internal.measurement.m1
    public final /* synthetic */ String a(String str, r1 r1Var) {
        return d(str, r1Var, p1.RAW_FILE_IO_TYPE);
    }

    @Override // com.google.android.gms.internal.measurement.m1
    public final /* synthetic */ String b(File file, String str, r1 r1Var) {
        return a(new File(file, str).getPath(), r1Var);
    }

    @Override // com.google.android.gms.internal.measurement.m1
    public final /* synthetic */ String c(File file, String str) {
        return b(file, str, r1.f2976a);
    }

    @Override // com.google.android.gms.internal.measurement.m1
    public final /* synthetic */ String i(String str) {
        return a(str, r1.f2976a);
    }

    o1() {
    }

    @Override // com.google.android.gms.internal.measurement.m1
    public final /* synthetic */ String d(String str, r1 r1Var, p1 p1Var) {
        return l1.a(this, str, r1Var, p1Var);
    }

    @Override // com.google.android.gms.internal.measurement.m1
    public final String e(String str, r1 r1Var, p1 p1Var) {
        return str;
    }
}
