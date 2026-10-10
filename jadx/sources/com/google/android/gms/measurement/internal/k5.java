package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class k5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<String[]> f3750b = new AtomicReference<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference<String[]> f3751c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicReference<String[]> f3752d = new AtomicReference<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b2.o f3753a;

    protected final String b(zzbj zzbjVar) {
        String string = null;
        if (zzbjVar == null) {
            return null;
        }
        if (!this.f3753a.b()) {
            return zzbjVar.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(zzbjVar.f4301c);
        sb2.append(",name=");
        sb2.append(c(zzbjVar.f4299a));
        sb2.append(",params=");
        zzbi zzbiVar = zzbjVar.f4300b;
        if (zzbiVar != null) {
            string = !this.f3753a.b() ? zzbiVar.toString() : a(zzbiVar.S());
        }
        sb2.append(string);
        return sb2.toString();
    }

    private final String e(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Object obj : objArr) {
            String strA = obj instanceof Bundle ? a((Bundle) obj) : String.valueOf(obj);
            if (strA != null) {
                if (sb2.length() != 1) {
                    sb2.append(", ");
                }
                sb2.append(strA);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    protected final String a(Bundle bundle) {
        String strE;
        if (bundle == null) {
            return null;
        }
        if (!this.f3753a.b()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb2.length() != 8) {
                sb2.append(", ");
            }
            sb2.append(f(str));
            sb2.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                strE = e(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                strE = e((Object[]) obj);
            } else {
                strE = obj instanceof ArrayList ? e(((ArrayList) obj).toArray()) : String.valueOf(obj);
            }
            sb2.append(strE);
        }
        sb2.append("}]");
        return sb2.toString();
    }

    protected final String c(String str) {
        if (str == null) {
            return null;
        }
        return !this.f3753a.b() ? str : d(str, b2.j0.f698c, b2.j0.f696a, f3750b);
    }

    protected final String f(String str) {
        if (str == null) {
            return null;
        }
        return !this.f3753a.b() ? str : d(str, b2.i0.f690b, b2.i0.f689a, f3751c);
    }

    protected final String g(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f3753a.b()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return d(str, b2.l0.f707b, b2.l0.f706a, f3752d);
        }
        return "experiment_id(" + str + ")";
    }

    public k5(b2.o oVar) {
        this.f3753a = oVar;
    }

    private static String d(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        boolean z10;
        String str2;
        m1.g.k(strArr);
        m1.g.k(strArr2);
        m1.g.k(atomicReference);
        if (strArr.length == strArr2.length) {
            z10 = true;
        } else {
            z10 = false;
        }
        m1.g.a(z10);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (Objects.equals(str, strArr[i10])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        if (strArr3[i10] == null) {
                            strArr3[i10] = strArr2[i10] + "(" + strArr[i10] + ")";
                        }
                        str2 = strArr3[i10];
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }
}
