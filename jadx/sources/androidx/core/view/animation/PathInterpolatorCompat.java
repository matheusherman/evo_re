package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class PathInterpolatorCompat {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(21)
    static class Api21Impl {
        @DoNotInline
        static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        private Api21Impl() {
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f10, float f11) {
        return Api21Impl.createPathInterpolator(f10, f11);
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(float f10, float f11, float f12, float f13) {
        return Api21Impl.createPathInterpolator(f10, f11, f12, f13);
    }
}
