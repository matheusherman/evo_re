package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface CanvasOperation {
        void run(@NonNull Canvas canvas);
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, @Nullable RectF rectF, int i10) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(rectF, i10) : canvas.saveLayerAlpha(rectF, i10, 31);
    }

    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f10, f11, f12, f13, i10);
        }
        return canvas.saveLayerAlpha(f10, f11, f12, f13, i10, 31);
    }
}
