package androidx.leanback.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class LogDecelerateInterpolator implements TimeInterpolator {
    int mBase;
    int mDrift;
    final float mLogScale;

    static float computeLog(float f10, int i10, int i11) {
        return ((float) (-Math.pow(i10, -f10))) + 1.0f + (i11 * f10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return computeLog(f10, this.mBase, this.mDrift) * this.mLogScale;
    }

    public LogDecelerateInterpolator(int i10, int i11) {
        this.mBase = i10;
        this.mDrift = i11;
        this.mLogScale = 1.0f / computeLog(1.0f, i10, i11);
    }
}
