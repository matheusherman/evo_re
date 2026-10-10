package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        if (!this.inside) {
            float f13 = this.size;
            shapePath.lineTo(f11 - (f13 * f12), 0.0f, f11, (-f13) * f12);
            shapePath.lineTo(f11 + (this.size * f12), 0.0f, f10, 0.0f);
        } else {
            shapePath.lineTo(f11 - (this.size * f12), 0.0f);
            float f14 = this.size;
            shapePath.lineTo(f11, f14 * f12, (f14 * f12) + f11, 0.0f);
            shapePath.lineTo(f10, 0.0f);
        }
    }

    public TriangleEdgeTreatment(float f10, boolean z10) {
        this.size = f10;
        this.inside = z10;
    }
}
