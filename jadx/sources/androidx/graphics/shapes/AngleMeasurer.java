package androidx.graphics.shapes;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000e"}, d2 = {"Landroidx/graphics/shapes/AngleMeasurer;", "Landroidx/graphics/shapes/Measurer;", "centerX", "", "centerY", "(FF)V", "getCenterX", "()F", "getCenterY", "findCubicCutPoint", "c", "Landroidx/graphics/shapes/Cubic;", "m", "measureCubic", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AngleMeasurer implements Measurer {
    private final float centerX;
    private final float centerY;

    /* JADX INFO: Access modifiers changed from: private */
    public static final float findCubicCutPoint$lambda$1(Cubic c10, AngleMeasurer this$0, float f10, float f11, float f12) {
        m.f(c10, "$c");
        m.f(this$0, "this$0");
        long jM39pointOnCurveOOQOV4g$graphics_shapes_release = c10.m39pointOnCurveOOQOV4g$graphics_shapes_release(f12);
        return Math.abs(Utils.positiveModulo(Utils.angle(PointKt.m51getXDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release) - this$0.centerX, PointKt.m52getYDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release) - this$0.centerY) - f10, Utils.getTwoPi()) - f11);
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(final Cubic c10, final float m10) {
        m.f(c10, "c");
        final float fAngle = Utils.angle(c10.getAnchor0X() - this.centerX, c10.getAnchor0Y() - this.centerY);
        return Utils.findMinimum(0.0f, 1.0f, 1.0E-5f, new FindMinimumFunction() { // from class: androidx.graphics.shapes.a
            @Override // androidx.graphics.shapes.FindMinimumFunction
            public final float invoke(float f10) {
                return AngleMeasurer.findCubicCutPoint$lambda$1(c10, this, fAngle, m10, f10);
            }
        });
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(Cubic c10) {
        m.f(c10, "c");
        float fPositiveModulo = Utils.positiveModulo(Utils.angle(c10.getAnchor1X() - this.centerX, c10.getAnchor1Y() - this.centerY) - Utils.angle(c10.getAnchor0X() - this.centerX, c10.getAnchor0Y() - this.centerY), Utils.getTwoPi());
        if (fPositiveModulo > Utils.getTwoPi() - 1.0E-4f) {
            return 0.0f;
        }
        return fPositiveModulo;
    }

    public AngleMeasurer(float f10, float f11) {
        this.centerX = f10;
        this.centerY = f11;
    }
}
