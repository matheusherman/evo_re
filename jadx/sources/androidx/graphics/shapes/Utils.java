package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a#\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\u0004\u001a4\u0010\u0011\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0014\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u0004\u001a1\u0010$\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"H\u0000¢\u0006\u0004\b$\u0010%\u001a)\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020&0(H\u0080\bø\u0001\u0001¢\u0006\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b/\u0010.\"\u001e\u00100\u001a\u00060\u0006j\u0002`\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u001a\u00104\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u00106\"\u001a\u00107\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00106\"\u0014\u0010:\u001a\u0002098\u0000X\u0080T¢\u0006\u0006\n\u0004\b:\u0010;\u0082\u0002\u000e\n\u0005\b¡\u001e0\u0001\n\u0005\b\u009920\u0001¨\u0006<"}, d2 = {"", "x", "y", "distance", "(FF)F", "distanceSquared", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "directionVector", "(FF)J", "angleRadians", "(F)J", "angle", "radius", "center", "radialToCartesian-L6JJ3z0", "(FFJ)J", "radialToCartesian", "rotate90-DnnuFBc", "(J)J", "rotate90", "square", "(F)F", "start", "stop", "fraction", "interpolate", "(FFF)F", "num", "mod", "positiveModulo", "v0", "v1", "tolerance", "Landroidx/graphics/shapes/FindMinimumFunction;", "f", "findMinimum", "(FFFLandroidx/graphics/shapes/FindMinimumFunction;)F", "", "tag", "Lkotlin/Function0;", "messageFactory", "Lr8/z;", "debugLog", "(Ljava/lang/String;Lc9/a;)V", "DistanceEpsilon", "F", "AngleEpsilon", "Zero", "J", "getZero", "()J", "FloatPi", "getFloatPi", "()F", "TwoPi", "getTwoPi", "", "DEBUG", "Z", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Utils {
    public static final float AngleEpsilon = 1.0E-6f;
    public static final boolean DEBUG = false;
    public static final float DistanceEpsilon = 1.0E-4f;
    private static final long Zero = FloatFloatPair.m3constructorimpl(0.0f, 0.0f);
    private static final float FloatPi = 3.1415927f;
    private static final float TwoPi = 6.2831855f;

    public static final float angle(float f10, float f11) {
        float fAtan2 = (float) Math.atan2(f11, f10);
        float f12 = TwoPi;
        return (fAtan2 + f12) % f12;
    }

    public static final long directionVector(float f10, float f11) {
        float fDistance = distance(f10, f11);
        if (fDistance > 0.0f) {
            return FloatFloatPair.m3constructorimpl(f10 / fDistance, f11 / fDistance);
        }
        throw new IllegalArgumentException("Required distance greater than zero");
    }

    public static final float interpolate(float f10, float f11, float f12) {
        return ((1 - f12) * f10) + (f12 * f11);
    }

    public static final float positiveModulo(float f10, float f11) {
        return ((f10 % f11) + f11) % f11;
    }

    public static final void debugLog(String tag, c9.a<String> messageFactory) {
        m.f(tag, "tag");
        m.f(messageFactory, "messageFactory");
    }

    public static final float distance(float f10, float f11) {
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    public static final float distanceSquared(float f10, float f11) {
        return (f10 * f10) + (f11 * f11);
    }

    public static final float findMinimum(float f10, float f11, float f12, FindMinimumFunction f13) {
        m.f(f13, "f");
        while (f11 - f10 > f12) {
            float f14 = 2;
            float f15 = 3;
            float f16 = ((f14 * f10) + f11) / f15;
            float f17 = ((f14 * f11) + f10) / f15;
            if (f13.invoke(f16) < f13.invoke(f17)) {
                f11 = f17;
            } else {
                f10 = f16;
            }
        }
        return (f10 + f11) / 2;
    }

    public static /* synthetic */ float findMinimum$default(float f10, float f11, float f12, FindMinimumFunction findMinimumFunction, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f12 = 0.001f;
        }
        return findMinimum(f10, f11, f12, findMinimumFunction);
    }

    public static final float getFloatPi() {
        return FloatPi;
    }

    public static final float getTwoPi() {
        return TwoPi;
    }

    public static final long getZero() {
        return Zero;
    }

    /* JADX INFO: renamed from: radialToCartesian-L6JJ3z0$default, reason: not valid java name */
    public static /* synthetic */ long m71radialToCartesianL6JJ3z0$default(float f10, float f11, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = Zero;
        }
        return m70radialToCartesianL6JJ3z0(f10, f11, j10);
    }

    public static final float square(float f10) {
        return f10 * f10;
    }

    /* JADX INFO: renamed from: radialToCartesian-L6JJ3z0, reason: not valid java name */
    public static final long m70radialToCartesianL6JJ3z0(float f10, float f11, long j10) {
        return PointKt.m55plusybeJwSQ(PointKt.m57timesso9K2fw(directionVector(f11), f10), j10);
    }

    /* JADX INFO: renamed from: rotate90-DnnuFBc, reason: not valid java name */
    public static final long m72rotate90DnnuFBc(long j10) {
        return FloatFloatPair.m3constructorimpl(-PointKt.m52getYDnnuFBc(j10), PointKt.m51getXDnnuFBc(j10));
    }

    public static final long directionVector(float f10) {
        double d10 = f10;
        return FloatFloatPair.m3constructorimpl((float) Math.cos(d10), (float) Math.sin(d10));
    }
}
