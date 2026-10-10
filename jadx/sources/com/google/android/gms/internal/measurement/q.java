package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class q implements s {
    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return null;
    }

    public final int hashCode() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        return s.f3011b0;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        return Boolean.FALSE;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof q;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        return Configurator.NULL;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        return Double.valueOf(0.0d);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        throw new IllegalStateException(String.format("null has no function %s", str));
    }
}
