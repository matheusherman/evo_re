package androidx.graphics.shapes;

import androidx.collection.FloatList;
import h9.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "progress", "progressFrom", "progressTo", "", "progressInRange", "(FFF)Z", "Landroidx/collection/FloatList;", "xValues", "yValues", "x", "linearMap", "(Landroidx/collection/FloatList;Landroidx/collection/FloatList;F)F", "p", "Lr8/z;", "validateProgress", "(Landroidx/collection/FloatList;)V", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatMappingKt {
    public static final boolean progressInRange(float f10, float f11, float f12) {
        if (f12 >= f11) {
            return f11 <= f10 && f10 <= f12;
        }
        return f10 >= f11 || f10 <= f12;
    }

    public static final float linearMap(FloatList xValues, FloatList yValues, float f10) {
        m.f(xValues, "xValues");
        m.f(yValues, "yValues");
        if (0.0f > f10 || f10 > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f10).toString());
        }
        Iterator<Integer> it = f.m(0, xValues._size).iterator();
        while (it.hasNext()) {
            int iNextInt = ((k0) it).nextInt();
            int i10 = iNextInt + 1;
            if (progressInRange(f10, xValues.get(iNextInt), xValues.get(i10 % xValues.getSize()))) {
                int size = i10 % xValues.getSize();
                float fPositiveModulo = Utils.positiveModulo(xValues.get(size) - xValues.get(iNextInt), 1.0f);
                return Utils.positiveModulo(yValues.get(iNextInt) + (Utils.positiveModulo(yValues.get(size) - yValues.get(iNextInt), 1.0f) * (fPositiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f10 - xValues.get(iNextInt), 1.0f) / fPositiveModulo)), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final void validateProgress(FloatList p10) {
        int i10;
        m.f(p10, "p");
        Boolean boolValueOf = Boolean.TRUE;
        float[] fArr = p10.content;
        int i11 = p10._size;
        int i12 = 0;
        while (true) {
            boolean z10 = true;
            if (i12 >= i11) {
                break;
            }
            float f10 = fArr[i12];
            if (!boolValueOf.booleanValue() || 0.0f > f10 || f10 > 1.0f) {
                z10 = false;
            }
            boolValueOf = Boolean.valueOf(z10);
            i12++;
        }
        if (!boolValueOf.booleanValue()) {
            throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p10, null, null, null, 0, null, 31, null)).toString());
        }
        Iterable iterableM = f.m(1, p10.getSize());
        if ((iterableM instanceof Collection) && ((Collection) iterableM).isEmpty()) {
            i10 = 0;
        } else {
            Iterator it = iterableM.iterator();
            i10 = 0;
            while (it.hasNext()) {
                int iNextInt = ((k0) it).nextInt();
                if (p10.get(iNextInt) < p10.get(iNextInt - 1) && (i10 = i10 + 1) < 0) {
                    r.u();
                }
            }
        }
        if (i10 <= 1) {
            return;
        }
        throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p10, null, null, null, 0, null, 31, null)).toString());
    }
}
