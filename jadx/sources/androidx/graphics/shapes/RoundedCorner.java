package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b \b\u0002\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJf\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JJ\u0010\u001f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u001c\u001a\u00060\u0002j\u0002`\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000bH\u0007¢\u0006\u0004\b#\u0010$R!\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'R!\u0010\u0005\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010'R!\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010'R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010,R!\u0010\u001c\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b-\u0010'R!\u0010.\u001a\u00060\u0002j\u0002`\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b.\u0010%\u001a\u0004\b/\u0010'R\u0017\u00100\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00104\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u0017\u00106\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u0017\u00108\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u0017\u0010:\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b:\u00101\u001a\u0004\b;\u00103R,\u0010<\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b<\u0010%\u001a\u0004\b=\u0010'\"\u0004\b>\u0010?R\u0011\u0010A\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b@\u00103\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/graphics/shapes/RoundedCorner;", "", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "p0", "p1", "p2", "Landroidx/graphics/shapes/CornerRounding;", "rounding", "<init>", "(JJJLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/g;)V", "", "allowedCut", "calculateActualSmoothingValue", "(F)F", "actualRoundCut", "actualSmoothingValues", "corner", "sideStart", "circleSegmentIntersection", "otherCircleSegmentIntersection", "circleCenter", "actualR", "Landroidx/graphics/shapes/Cubic;", "computeFlankingCurve-oAJzIJU", "(FFJJJJJF)Landroidx/graphics/shapes/Cubic;", "computeFlankingCurve", "d0", "d1", "lineIntersection-CBFvKDc", "(JJJJ)Landroidx/collection/FloatFloatPair;", "lineIntersection", "allowedCut0", "allowedCut1", "", "getCubics", "(FF)Ljava/util/List;", "J", "getP0-1ufDz9w", "()J", "getP1-1ufDz9w", "getP2-1ufDz9w", "Landroidx/graphics/shapes/CornerRounding;", "getRounding", "()Landroidx/graphics/shapes/CornerRounding;", "getD1-1ufDz9w", "d2", "getD2-1ufDz9w", "cornerRadius", "F", "getCornerRadius", "()F", "smoothing", "getSmoothing", "cosAngle", "getCosAngle", "sinAngle", "getSinAngle", "expectedRoundCut", "getExpectedRoundCut", "center", "getCenter-1ufDz9w", "setCenter-DnnuFBc", "(J)V", "getExpectedCut", "expectedCut", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;
    private final long d1;
    private final long d2;
    private final float expectedRoundCut;
    private final long p0;
    private final long p1;
    private final long p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    public /* synthetic */ RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding, g gVar) {
        this(j10, j11, j12, cornerRounding);
    }

    public final List<Cubic> getCubics(float f10) {
        return getCubics$default(this, f10, 0.0f, 2, null);
    }

    public final float getExpectedCut() {
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    private RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding) {
        this.p0 = j10;
        this.p1 = j11;
        this.p2 = j12;
        this.rounding = cornerRounding;
        long jM48getDirectionDnnuFBc = PointKt.m48getDirectionDnnuFBc(PointKt.m54minusybeJwSQ(j10, j11));
        this.d1 = jM48getDirectionDnnuFBc;
        long jM48getDirectionDnnuFBc2 = PointKt.m48getDirectionDnnuFBc(PointKt.m54minusybeJwSQ(j12, j11));
        this.d2 = jM48getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float fM47dotProductybeJwSQ = PointKt.m47dotProductybeJwSQ(jM48getDirectionDnnuFBc, jM48getDirectionDnnuFBc2);
        this.cosAngle = fM47dotProductybeJwSQ;
        float f10 = 1;
        float fSqrt = (float) Math.sqrt(f10 - Utils.square(fM47dotProductybeJwSQ));
        this.sinAngle = fSqrt;
        this.expectedRoundCut = ((double) fSqrt) > 0.001d ? (radius * (fM47dotProductybeJwSQ + f10)) / fSqrt : 0.0f;
        this.center = FloatFloatPair.m3constructorimpl(0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m61computeFlankingCurveoAJzIJU(float actualRoundCut, float actualSmoothingValues, long corner, long sideStart, long circleSegmentIntersection, long otherCircleSegmentIntersection, long circleCenter, float actualR) {
        long jM48getDirectionDnnuFBc = PointKt.m48getDirectionDnnuFBc(PointKt.m54minusybeJwSQ(sideStart, corner));
        long jM55plusybeJwSQ = PointKt.m55plusybeJwSQ(corner, PointKt.m57timesso9K2fw(PointKt.m57timesso9K2fw(jM48getDirectionDnnuFBc, actualRoundCut), 1 + actualSmoothingValues));
        long packedValue = circleSegmentIntersection;
        long jM53interpolatedLqxh1s = PointKt.m53interpolatedLqxh1s(packedValue, PointKt.m45divso9K2fw(PointKt.m55plusybeJwSQ(circleSegmentIntersection, otherCircleSegmentIntersection), 2.0f), actualSmoothingValues);
        long jM55plusybeJwSQ2 = PointKt.m55plusybeJwSQ(circleCenter, PointKt.m57timesso9K2fw(Utils.directionVector(PointKt.m51getXDnnuFBc(jM53interpolatedLqxh1s) - PointKt.m51getXDnnuFBc(circleCenter), PointKt.m52getYDnnuFBc(jM53interpolatedLqxh1s) - PointKt.m52getYDnnuFBc(circleCenter)), actualR));
        FloatFloatPair floatFloatPairM62lineIntersectionCBFvKDc = m62lineIntersectionCBFvKDc(sideStart, jM48getDirectionDnnuFBc, jM55plusybeJwSQ2, Utils.m72rotate90DnnuFBc(PointKt.m54minusybeJwSQ(jM55plusybeJwSQ2, circleCenter)));
        if (floatFloatPairM62lineIntersectionCBFvKDc != null) {
            packedValue = floatFloatPairM62lineIntersectionCBFvKDc.getPackedValue();
        }
        return new Cubic(jM55plusybeJwSQ, PointKt.m45divso9K2fw(PointKt.m55plusybeJwSQ(jM55plusybeJwSQ, PointKt.m57timesso9K2fw(packedValue, 2.0f)), 3.0f), packedValue, jM55plusybeJwSQ2, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = f10;
        }
        return roundedCorner.getCubics(f10, f11);
    }

    /* JADX INFO: renamed from: getCenter-1ufDz9w, reason: not valid java name and from getter */
    public final long getCenter() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float allowedCut0, float allowedCut1) {
        float fMin = Math.min(allowedCut0, allowedCut1);
        float f10 = this.expectedRoundCut;
        if (f10 < 1.0E-4f || fMin < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j10 = this.p1;
            this.center = j10;
            return r.e(Cubic.INSTANCE.straightLine(PointKt.m51getXDnnuFBc(j10), PointKt.m52getYDnnuFBc(this.p1), PointKt.m51getXDnnuFBc(this.p1), PointKt.m52getYDnnuFBc(this.p1)));
        }
        float fMin2 = Math.min(fMin, f10);
        float fCalculateActualSmoothingValue = calculateActualSmoothingValue(allowedCut0);
        float fCalculateActualSmoothingValue2 = calculateActualSmoothingValue(allowedCut1);
        float f11 = (this.cornerRadius * fMin2) / this.expectedRoundCut;
        this.center = PointKt.m55plusybeJwSQ(this.p1, PointKt.m57timesso9K2fw(PointKt.m48getDirectionDnnuFBc(PointKt.m45divso9K2fw(PointKt.m55plusybeJwSQ(this.d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(f11) + Utils.square(fMin2))));
        long jM55plusybeJwSQ = PointKt.m55plusybeJwSQ(this.p1, PointKt.m57timesso9K2fw(this.d1, fMin2));
        long jM55plusybeJwSQ2 = PointKt.m55plusybeJwSQ(this.p1, PointKt.m57timesso9K2fw(this.d2, fMin2));
        Cubic cubicM61computeFlankingCurveoAJzIJU = m61computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue, this.p1, this.p0, jM55plusybeJwSQ, jM55plusybeJwSQ2, this.center, f11);
        Cubic cubicReverse = m61computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue2, this.p1, this.p2, jM55plusybeJwSQ2, jM55plusybeJwSQ, this.center, f11).reverse();
        return r.o(cubicM61computeFlankingCurveoAJzIJU, Cubic.INSTANCE.circularArc(PointKt.m51getXDnnuFBc(this.center), PointKt.m52getYDnnuFBc(this.center), cubicM61computeFlankingCurveoAJzIJU.getAnchor1X(), cubicM61computeFlankingCurveoAJzIJU.getAnchor1Y(), cubicReverse.getAnchor0X(), cubicReverse.getAnchor0Y()), cubicReverse);
    }

    /* JADX INFO: renamed from: getD1-1ufDz9w, reason: not valid java name and from getter */
    public final long getD1() {
        return this.d1;
    }

    /* JADX INFO: renamed from: getD2-1ufDz9w, reason: not valid java name and from getter */
    public final long getD2() {
        return this.d2;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* JADX INFO: renamed from: getP0-1ufDz9w, reason: not valid java name and from getter */
    public final long getP0() {
        return this.p0;
    }

    /* JADX INFO: renamed from: getP1-1ufDz9w, reason: not valid java name and from getter */
    public final long getP1() {
        return this.p1;
    }

    /* JADX INFO: renamed from: getP2-1ufDz9w, reason: not valid java name and from getter */
    public final long getP2() {
        return this.p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* JADX INFO: renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m69setCenterDnnuFBc(long j10) {
        this.center = j10;
    }

    private final float calculateActualSmoothingValue(float allowedCut) {
        if (allowedCut > getExpectedCut()) {
            return this.smoothing;
        }
        float f10 = this.expectedRoundCut;
        if (allowedCut > f10) {
            return (this.smoothing * (allowedCut - f10)) / (getExpectedCut() - this.expectedRoundCut);
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m62lineIntersectionCBFvKDc(long p10, long d10, long p11, long d11) {
        long jM72rotate90DnnuFBc = Utils.m72rotate90DnnuFBc(d11);
        float fM47dotProductybeJwSQ = PointKt.m47dotProductybeJwSQ(d10, jM72rotate90DnnuFBc);
        if (Math.abs(fM47dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float fM47dotProductybeJwSQ2 = PointKt.m47dotProductybeJwSQ(PointKt.m54minusybeJwSQ(p11, p10), jM72rotate90DnnuFBc);
        if (Math.abs(fM47dotProductybeJwSQ) < Math.abs(fM47dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m0boximpl(PointKt.m55plusybeJwSQ(p10, PointKt.m57timesso9K2fw(d10, fM47dotProductybeJwSQ2 / fM47dotProductybeJwSQ)));
    }

    public /* synthetic */ RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding, int i10, g gVar) {
        this(j10, j11, j12, (i10 & 8) != 0 ? null : cornerRounding, null);
    }
}
