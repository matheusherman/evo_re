package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class yc extends vc<uc, uc> {
    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ uc i(Object obj) {
        uc ucVar = ((ea) obj).zzb;
        if (ucVar != uc.k()) {
            return ucVar;
        }
        uc ucVarL = uc.l();
        m(obj, ucVarL);
        return ucVarL;
    }

    private static void m(Object obj, uc ucVar) {
        ((ea) obj).zzb = ucVar;
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ int a(uc ucVar) {
        return ucVar.a();
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ uc b(uc ucVar, uc ucVar2) {
        uc ucVar3 = ucVar;
        uc ucVar4 = ucVar2;
        if (uc.k().equals(ucVar4)) {
            return ucVar3;
        }
        return uc.k().equals(ucVar3) ? uc.c(ucVar3, ucVar4) : ucVar3.b(ucVar4);
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ void c(uc ucVar, int i10, v8 v8Var) {
        ucVar.e((i10 << 3) | 2, v8Var);
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ void d(uc ucVar, nd ndVar) {
        ucVar.g(ndVar);
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ int e(uc ucVar) {
        return ucVar.i();
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ void f(uc ucVar, int i10, long j10) {
        ucVar.e(i10 << 3, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ void g(uc ucVar, nd ndVar) {
        ucVar.j(ndVar);
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ void h(Object obj, uc ucVar) {
        m(obj, ucVar);
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ void j(Object obj, uc ucVar) {
        m(obj, ucVar);
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final /* synthetic */ uc k(Object obj) {
        return ((ea) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.vc
    final void l(Object obj) {
        ((ea) obj).zzb.m();
    }

    yc() {
    }
}
