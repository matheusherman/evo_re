package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class dc implements mb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ob f2612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f2614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2615d;

    final String a() {
        return this.f2613b;
    }

    @Override // com.google.android.gms.internal.measurement.mb
    public final ob b() {
        return this.f2612a;
    }

    @Override // com.google.android.gms.internal.measurement.mb
    public final zb c() {
        int i10 = this.f2615d;
        if ((i10 & 1) != 0) {
            return zb.PROTO2;
        }
        return (i10 & 4) == 4 ? zb.EDITIONS : zb.PROTO3;
    }

    @Override // com.google.android.gms.internal.measurement.mb
    public final boolean d() {
        return (this.f2615d & 2) == 2;
    }

    final Object[] e() {
        return this.f2614c;
    }

    dc(ob obVar, String str, Object[] objArr) {
        this.f2612a = obVar;
        this.f2613b = str;
        this.f2614c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2615d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 >= 55296) {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            } else {
                this.f2615d = i10 | (cCharAt2 << i11);
                return;
            }
        }
    }
}
