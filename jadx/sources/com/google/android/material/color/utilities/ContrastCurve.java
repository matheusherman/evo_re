package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public double get(double d10) {
        if (d10 <= -1.0d) {
            return this.low;
        }
        if (d10 < 0.0d) {
            return MathUtils.lerp(this.low, this.normal, (d10 - (-1.0d)) / 1.0d);
        }
        if (d10 < 0.5d) {
            return MathUtils.lerp(this.normal, this.medium, (d10 - 0.0d) / 0.5d);
        }
        return d10 < 1.0d ? MathUtils.lerp(this.medium, this.high, (d10 - 0.5d) / 0.5d) : this.high;
    }

    public ContrastCurve(double d10, double d11, double d12, double d13) {
        this.low = d10;
        this.normal = d11;
        this.medium = d12;
        this.high = d13;
    }
}
