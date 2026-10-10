package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f10, float f11, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f10, float f11, float f12) {
        getCornerPath(f10, f11, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f10, float f11, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f10, f11, cornerSize.getCornerSize(rectF));
    }
}
