package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class k implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Double f2794a;

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        return new k(this.f2794a);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        return Boolean.valueOf((Double.isNaN(this.f2794a.doubleValue()) || this.f2794a.doubleValue() == 0.0d) ? false : true);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            return this.f2794a.equals(((k) obj).f2794a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        if (Double.isNaN(this.f2794a.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.f2794a.doubleValue())) {
            return this.f2794a.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(this.f2794a.doubleValue());
        BigDecimal bigDecimal = bigDecimalValueOf.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : j.a(bigDecimalValueOf);
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimal.scale() > 0 ? bigDecimal.precision() : bigDecimal.scale()) - 1);
        String str = decimalFormat.format(bigDecimal);
        int iIndexOf = str.indexOf(ExifInterface.LONGITUDE_EAST);
        if (iIndexOf <= 0) {
            return str;
        }
        int i10 = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i10 >= 0 || i10 <= -7) && (i10 < 0 || i10 >= 21)) ? str.replace("E-", "e-").replace(ExifInterface.LONGITUDE_EAST, "e+") : bigDecimal.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        return this.f2794a;
    }

    public final int hashCode() {
        return this.f2794a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        if ("toString".equals(str)) {
            return new u(f());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", f(), str));
    }

    public k(Double d10) {
        if (d10 == null) {
            this.f2794a = Double.valueOf(Double.NaN);
        } else {
            this.f2794a = d10;
        }
    }

    public final String toString() {
        return f();
    }
}
