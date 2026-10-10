package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class xa implements ya {
    xa() {
    }

    private static <E> na<E> c(Object obj, long j10) {
        return (na) xc.B(obj, j10);
    }

    @Override // com.google.android.gms.internal.measurement.ya
    public final void a(Object obj, long j10) {
        c(obj, j10).c();
    }

    @Override // com.google.android.gms.internal.measurement.ya
    public final <E> void b(Object obj, Object obj2, long j10) {
        na naVarC = c(obj, j10);
        na naVarC2 = c(obj2, j10);
        int size = naVarC.size();
        int size2 = naVarC2.size();
        if (size > 0 && size2 > 0) {
            if (!naVarC.d()) {
                naVarC = naVarC.a(size2 + size);
            }
            naVarC.addAll(naVarC2);
        }
        if (size > 0) {
            naVarC2 = naVarC;
        }
        xc.j(obj, j10, naVarC2);
    }
}
