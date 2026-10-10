package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class tb<T> implements fc<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ob f3082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final vc<?, ?> f3083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f3084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s9<?> f3085d;

    /* JADX WARN: Code duplicated, block: B:33:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1 A[EDGE_INSN: B:58:0x00a1->B:35:0x00a1 BREAK  A[LOOP:1: B:18:0x0059->B:63:0x0059], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.fc
    public final void h(T t10, byte[] bArr, int i10, int i11, u8 u8Var) throws ma {
        int iS;
        ea eaVar = (ea) t10;
        uc ucVarL = eaVar.zzb;
        if (ucVarL == uc.k()) {
            ucVarL = uc.l();
            eaVar.zzb = ucVarL;
        }
        uc ucVar = ucVarL;
        ((ea.d) t10).K();
        ea.f fVar = null;
        while (i10 < i11) {
            int iS2 = r8.s(bArr, i10, u8Var);
            int i12 = u8Var.f3101a;
            if (i12 == 11) {
                byte[] bArr2 = bArr;
                int i13 = i11;
                u8 u8Var2 = u8Var;
                int i14 = 0;
                v8 v8Var = null;
                while (true) {
                    if (iS2 >= i13) {
                        iS = iS2;
                        break;
                    }
                    iS = r8.s(bArr2, iS2, u8Var2);
                    int i15 = u8Var2.f3101a;
                    int i16 = i15 >>> 3;
                    int i17 = i15 & 7;
                    if (i16 == 2) {
                        if (i17 != 0) {
                            if (i15 != 12) {
                                break;
                                break;
                            }
                            iS2 = r8.b(i15, bArr2, iS, i13, u8Var2);
                        } else {
                            iS2 = r8.s(bArr2, iS, u8Var2);
                            i14 = u8Var2.f3101a;
                            fVar = (ea.f) this.f3085d.c(u8Var2.f3104d, this.f3082a, i14);
                        }
                    } else {
                        if (i16 == 3) {
                            if (fVar != null) {
                                cc.a();
                                throw new NoSuchMethodError();
                            }
                            if (i17 == 2) {
                                iS2 = r8.l(bArr2, iS, u8Var2);
                                v8Var = (v8) u8Var2.f3103c;
                            }
                        }
                        if (i15 != 12) {
                            break;
                        } else {
                            iS2 = r8.b(i15, bArr2, iS, i13, u8Var2);
                        }
                    }
                }
                if (v8Var != null) {
                    ucVar.e((i14 << 3) | 2, v8Var);
                }
                i10 = iS;
                bArr = bArr2;
                i11 = i13;
                u8Var = u8Var2;
            } else if ((i12 & 7) == 2) {
                fVar = (ea.f) this.f3085d.c(u8Var.f3104d, this.f3082a, i12 >>> 3);
                if (fVar != null) {
                    cc.a();
                    throw new NoSuchMethodError();
                }
                i10 = r8.d(i12, bArr, iS2, i11, ucVar, u8Var);
            } else {
                i10 = r8.b(i12, bArr, iS2, i11, u8Var);
            }
        }
        if (i10 != i11) {
            throw ma.e();
        }
    }

    static <T> tb<T> j(vc<?, ?> vcVar, s9<?> s9Var, ob obVar) {
        return new tb<>(vcVar, s9Var, obVar);
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final int a(T t10) {
        vc<?, ?> vcVar = this.f3083b;
        int iE = vcVar.e(vcVar.k(t10));
        return this.f3084c ? iE + this.f3085d.b(t10).a() : iE;
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final T b() {
        ob obVar = this.f3082a;
        return obVar instanceof ea ? (T) ((ea) obVar).D() : (T) obVar.g().B();
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final boolean c(T t10) {
        return this.f3085d.b(t10).s();
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final void d(T t10) {
        this.f3083b.l(t10);
        this.f3085d.g(t10);
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final int e(T t10) {
        int iHashCode = this.f3083b.k(t10).hashCode();
        return this.f3084c ? (iHashCode * 53) + this.f3085d.b(t10).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final void f(T t10, T t11) {
        hc.n(this.f3083b, t10, t11);
        if (this.f3084c) {
            hc.l(this.f3085d, t10, t11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final void g(T t10, nd ndVar) {
        Iterator itP = this.f3085d.b(t10).p();
        while (itP.hasNext()) {
            Map.Entry entry = (Map.Entry) itP.next();
            z9 z9Var = (z9) entry.getKey();
            if (z9Var.d() != ld.MESSAGE || z9Var.g() || z9Var.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof qa) {
                ndVar.m(z9Var.b(), ((qa) entry).a().c());
            } else {
                ndVar.m(z9Var.b(), entry.getValue());
            }
        }
        vc<?, ?> vcVar = this.f3083b;
        vcVar.d(vcVar.k(t10), ndVar);
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final boolean i(T t10, T t11) {
        if (!this.f3083b.k(t10).equals(this.f3083b.k(t11))) {
            return false;
        }
        if (this.f3084c) {
            return this.f3085d.b(t10).equals(this.f3085d.b(t11));
        }
        return true;
    }

    private tb(vc<?, ?> vcVar, s9<?> s9Var, ob obVar) {
        this.f3083b = vcVar;
        this.f3084c = s9Var.e(obVar);
        this.f3085d = s9Var;
        this.f3082a = obVar;
    }
}
