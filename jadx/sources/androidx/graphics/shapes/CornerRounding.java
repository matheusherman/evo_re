package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;
import kotlin.Metadata;
import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/graphics/shapes/CornerRounding;", "", "radius", "", "smoothing", "(FF)V", "getRadius", "()F", "getSmoothing", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CornerRounding {
    public static final CornerRounding Unrounded;
    private final float radius;
    private final float smoothing;

    /* JADX WARN: Illegal instructions before constructor call */
    public CornerRounding() {
        float f10 = 0.0f;
        this(f10, f10, 3, null);
    }

    static {
        g gVar = null;
        INSTANCE = new Companion(gVar);
        float f10 = 0.0f;
        Unrounded = new CornerRounding(f10, f10, 3, gVar);
    }

    public CornerRounding(@FloatRange(from = 0.0d) float f10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f11) {
        this.radius = f10;
        this.smoothing = f11;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public /* synthetic */ CornerRounding(float f10, float f11, int i10, g gVar) {
        this((i10 & 1) != 0 ? 0.0f : f10, (i10 & 2) != 0 ? 0.0f : f11);
    }
}
