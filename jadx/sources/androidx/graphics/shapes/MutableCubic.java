package androidx.graphics.shapes;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/graphics/shapes/MutableCubic;", "Landroidx/graphics/shapes/Cubic;", "<init>", "()V", "Landroidx/graphics/shapes/PointTransformer;", "f", "", "ix", "Lr8/z;", "transformOnePoint", "(Landroidx/graphics/shapes/PointTransformer;I)V", "transform", "(Landroidx/graphics/shapes/PointTransformer;)V", "c1", "c2", "", "progress", "interpolate", "(Landroidx/graphics/shapes/Cubic;Landroidx/graphics/shapes/Cubic;F)V", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    public final void interpolate(Cubic c10, Cubic c11, float progress) {
        m.f(c10, "c1");
        m.f(c11, "c2");
        for (int i10 = 0; i10 < 8; i10++) {
            getPoints()[i10] = Utils.interpolate(c10.getPoints()[i10], c11.getPoints()[i10], progress);
        }
    }

    public final void transform(PointTransformer f10) {
        m.f(f10, "f");
        transformOnePoint(f10, 0);
        transformOnePoint(f10, 2);
        transformOnePoint(f10, 4);
        transformOnePoint(f10, 6);
    }

    private final void transformOnePoint(PointTransformer f10, int ix) {
        int i10 = ix + 1;
        long jMo60transformXgqJiTY = f10.mo60transformXgqJiTY(getPoints()[ix], getPoints()[i10]);
        getPoints()[ix] = Float.intBitsToFloat((int) (jMo60transformXgqJiTY >> 32));
        getPoints()[i10] = Float.intBitsToFloat((int) (jMo60transformXgqJiTY & 4294967295L));
    }
}
