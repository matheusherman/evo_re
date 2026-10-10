package h9;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0012\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\r\u001a\u0019\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0010\u001a!\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u0019\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001a\u001a1\u0010\u001f\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u001c*\b\u0012\u0004\u0012\u00028\u00000\u001b*\u00028\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010\"\u001a\u00020\u0000*\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000!¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"", TypedValues.TransitionType.S_TO, "Lh9/c;", "k", "(II)Lh9/c;", "step", "l", "(Lh9/c;I)Lh9/c;", "Lh9/e;", "m", "(II)Lh9/e;", "minimumValue", "c", "(II)I", "", "d", "(JJ)J", "", "b", "(FF)F", "maximumValue", "e", "f", "h", "(III)I", "g", "(FFF)F", "", ExifInterface.GPS_DIRECTION_TRUE, "Lh9/a;", "range", "j", "(Ljava/lang/Comparable;Lh9/a;)Ljava/lang/Comparable;", "Lh9/b;", "i", "(ILh9/b;)I", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
public class h extends g {
    public static float b(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    public static int c(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long d(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static int e(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long f(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static float g(float f10, float f11, float f12) {
        if (f11 <= f12) {
            if (f10 < f11) {
                return f11;
            }
            return f10 > f12 ? f12 : f10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f12 + " is less than minimum " + f11 + '.');
    }

    public static int h(int i10, int i11, int i12) {
        if (i11 <= i12) {
            if (i10 < i11) {
                return i11;
            }
            return i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static int i(int i10, b<Integer> range) {
        m.f(range, "range");
        if (range instanceof a) {
            return ((Number) j(Integer.valueOf(i10), (a) range)).intValue();
        }
        if (!range.isEmpty()) {
            if (i10 < ((Number) range.getStart()).intValue()) {
                return ((Number) range.getStart()).intValue();
            }
            return i10 > ((Number) range.getEndInclusive()).intValue() ? ((Number) range.getEndInclusive()).intValue() : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static final <T extends Comparable<? super T>> T j(T t10, a<T> range) {
        m.f(t10, "<this>");
        m.f(range, "range");
        if (!range.isEmpty()) {
            if (!range.e(t10, range.getStart()) || range.e(range.getStart(), t10)) {
                return (!range.e(range.getEndInclusive(), t10) || range.e(t10, range.getEndInclusive())) ? t10 : range.getEndInclusive();
            }
            return range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static c k(int i10, int i11) {
        return c.INSTANCE.a(i10, i11, -1);
    }

    public static c l(c cVar, int i10) {
        m.f(cVar, "<this>");
        g.a(i10 > 0, Integer.valueOf(i10));
        c.Companion companion = c.INSTANCE;
        int first = cVar.getFirst();
        int last = cVar.getLast();
        if (cVar.getStep() <= 0) {
            i10 = -i10;
        }
        return companion.a(first, last, i10);
    }

    public static e m(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? e.INSTANCE.a() : new e(i10, i11 - 1);
    }
}
