package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 M2\u00020\u0001:\u0001MB\u0013\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B9\b\u0010\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\t\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0004\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0012\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u001f2\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010#J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b(\u0010)J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020*H\u0086\u0002¢\u0006\u0004\b(\u0010+J\u0018\u0010,\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b,\u0010)J\u0018\u0010,\u001a\u00020\u00002\u0006\u0010'\u001a\u00020*H\u0086\u0002¢\u0006\u0004\b,\u0010+J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u001a\u00101\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020*H\u0016¢\u0006\u0004\b7\u00108R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010;R\u0011\u0010>\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010@\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0011\u0010B\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bA\u0010=R\u0011\u0010D\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bC\u0010=R\u0011\u0010F\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bE\u0010=R\u0011\u0010H\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bG\u0010=R\u0011\u0010J\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bI\u0010=R\u0011\u0010L\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bK\u0010=\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006N"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "", "points", "<init>", "([F)V", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "anchor0", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/g;)V", "", "value", "", "zeroIsh", "(F)Z", "t", "pointOnCurve-OOQOV4g$graphics_shapes_release", "(F)J", "pointOnCurve", "zeroLength$graphics_shapes_release", "()Z", "zeroLength", "bounds", "approximate", "Lr8/z;", "calculateBounds$graphics_shapes_release", "([FZ)V", "calculateBounds", "Lr8/p;", "split", "(F)Lr8/p;", "reverse", "()Landroidx/graphics/shapes/Cubic;", "o", "plus", "(Landroidx/graphics/shapes/Cubic;)Landroidx/graphics/shapes/Cubic;", "x", "times", "(F)Landroidx/graphics/shapes/Cubic;", "", "(I)Landroidx/graphics/shapes/Cubic;", "div", "", "toString", "()Ljava/lang/String;", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Landroidx/graphics/shapes/PointTransformer;", "f", "transformed", "(Landroidx/graphics/shapes/PointTransformer;)Landroidx/graphics/shapes/Cubic;", "hashCode", "()I", "[F", "getPoints$graphics_shapes_release", "()[F", "getAnchor0X", "()F", "anchor0X", "getAnchor0Y", "anchor0Y", "getControl0X", "control0X", "getControl0Y", "control0Y", "getControl1X", "control1X", "getControl1Y", "control1Y", "getAnchor1X", "anchor1X", "getAnchor1Y", "anchor1Y", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Cubic {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float[] points;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "()V", "circularArc", "Landroidx/graphics/shapes/Cubic;", "centerX", "", "centerY", "x0", "y0", "x1", "y1", "straightLine", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public final Cubic circularArc(float centerX, float centerY, float x10, float y10, float x11, float y11) {
            float f10 = x10 - centerX;
            float f11 = y10 - centerY;
            long jDirectionVector = Utils.directionVector(f10, f11);
            float f12 = x11 - centerX;
            float f13 = y11 - centerY;
            long jDirectionVector2 = Utils.directionVector(f12, f13);
            long jM72rotate90DnnuFBc = Utils.m72rotate90DnnuFBc(jDirectionVector);
            long jM72rotate90DnnuFBc2 = Utils.m72rotate90DnnuFBc(jDirectionVector2);
            boolean z10 = PointKt.m46dotProduct5P9i7ZU(jM72rotate90DnnuFBc, f12, f13) >= 0.0f;
            float fM47dotProductybeJwSQ = PointKt.m47dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM47dotProductybeJwSQ > 0.999f) {
                return straightLine(x10, y10, x11, y11);
            }
            float f14 = 1;
            float f15 = f14 - fM47dotProductybeJwSQ;
            float fDistance = ((((Utils.distance(f10, f11) * 4.0f) / 3.0f) * (((float) Math.sqrt(2 * f15)) - ((float) Math.sqrt(f14 - (fM47dotProductybeJwSQ * fM47dotProductybeJwSQ))))) / f15) * (z10 ? 1.0f : -1.0f);
            return CubicKt.Cubic(x10, y10, x10 + (PointKt.m51getXDnnuFBc(jM72rotate90DnnuFBc) * fDistance), y10 + (PointKt.m52getYDnnuFBc(jM72rotate90DnnuFBc) * fDistance), x11 - (PointKt.m51getXDnnuFBc(jM72rotate90DnnuFBc2) * fDistance), y11 - (PointKt.m52getYDnnuFBc(jM72rotate90DnnuFBc2) * fDistance), x11, y11);
        }

        public final Cubic straightLine(float x10, float y10, float x11, float y11) {
            return CubicKt.Cubic(x10, y10, Utils.interpolate(x10, x11, 0.33333334f), Utils.interpolate(y10, y11, 0.33333334f), Utils.interpolate(x10, x11, 0.6666667f), Utils.interpolate(y10, y11, 0.6666667f), x11, y11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final Cubic div(float x10) {
        return times(1.0f / x10);
    }

    /* JADX INFO: renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m39pointOnCurveOOQOV4g$graphics_shapes_release(float t10) {
        float f10 = 1 - t10;
        float f11 = f10 * f10 * f10;
        float f12 = 3 * t10;
        float f13 = f12 * f10 * f10;
        float f14 = f12 * t10 * f10;
        float f15 = t10 * t10 * t10;
        return FloatFloatPair.m3constructorimpl((getAnchor0X() * f11) + (getControl0X() * f13) + (getControl1X() * f14) + (getAnchor1X() * f15), (getAnchor0Y() * f11) + (getControl0Y() * f13) + (getControl1Y() * f14) + (getAnchor1Y() * f15));
    }

    public final p<Cubic, Cubic> split(float t10) {
        float f10 = 1 - t10;
        long jM39pointOnCurveOOQOV4g$graphics_shapes_release = m39pointOnCurveOOQOV4g$graphics_shapes_release(t10);
        float f11 = f10 * f10;
        float f12 = 2 * f10 * t10;
        float f13 = t10 * t10;
        return v.a(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f10) + (getControl0X() * t10), (getAnchor0Y() * f10) + (getControl0Y() * t10), (getAnchor0X() * f11) + (getControl0X() * f12) + (getControl1X() * f13), (getAnchor0Y() * f11) + (getControl0Y() * f12) + (getControl1Y() * f13), PointKt.m51getXDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m52getYDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m51getXDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m52getYDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release), (getControl0X() * f11) + (getControl1X() * f12) + (getAnchor1X() * f13), (getControl0Y() * f11) + (getControl1Y() * f12) + (getAnchor1Y() * f13), (getControl1X() * f10) + (getAnchor1X() * t10), (getControl1Y() * f10) + (getAnchor1Y() * t10), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float x10) {
        float[] fArr = new float[8];
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = this.points[i10] * x10;
        }
        return new Cubic(fArr);
    }

    public /* synthetic */ Cubic(long j10, long j11, long j12, long j13, g gVar) {
        this(j10, j11, j12, j13);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z10);
    }

    public static final Cubic circularArc(float f10, float f11, float f12, float f13, float f14, float f15) {
        return INSTANCE.circularArc(f10, f11, f12, f13, f14, f15);
    }

    public static final Cubic straightLine(float f10, float f11, float f12, float f13) {
        return INSTANCE.straightLine(f10, f11, f12, f13);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:53:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x01d8 A[PHI: r3 r7
      0x01d8: PHI (r3v15 float) = (r3v12 float), (r3v21 float) binds: [B:85:0x022a, B:62:0x01d6] A[DONT_GENERATE, DONT_INLINE]
      0x01d8: PHI (r7v14 float) = (r7v10 float), (r7v16 float) binds: [B:85:0x022a, B:62:0x01d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x01da  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:72:0x0204  */
    /* JADX WARN: Code duplicated, block: B:75:0x0209  */
    /* JADX WARN: Code duplicated, block: B:87:0x022d A[PHI: r9 r15
      0x022d: PHI (r9v5 float) = (r9v2 float), (r9v3 float), (r9v3 float), (r9v2 float), (r9v2 float), (r9v2 float) binds: [B:65:0x01e3, B:77:0x0213, B:79:0x0217, B:51:0x01b3, B:54:0x01bf, B:56:0x01c3] A[DONT_GENERATE, DONT_INLINE]
      0x022d: PHI (r15v13 float) = (r15v9 float), (r15v10 float), (r15v10 float), (r15v9 float), (r15v9 float), (r15v9 float) binds: [B:65:0x01e3, B:77:0x0213, B:79:0x0217, B:51:0x01b3, B:54:0x01bf, B:56:0x01c3] A[DONT_GENERATE, DONT_INLINE]] */
    public final void calculateBounds$graphics_shapes_release(float[] bounds, boolean approximate) {
        char c10;
        char c11;
        float f10;
        char c12;
        float control0Y;
        float anchor0Y;
        float control0Y2;
        float f11;
        float fSqrt;
        float fSqrt2;
        float fM52getYDnnuFBc;
        float f12;
        float fM52getYDnnuFBc2;
        float f13;
        m.f(bounds, "bounds");
        if (zeroLength$graphics_shapes_release()) {
            bounds[0] = getAnchor0X();
            bounds[1] = getAnchor0Y();
            bounds[2] = getAnchor0X();
            bounds[3] = getAnchor0Y();
            return;
        }
        float fMin = Math.min(getAnchor0X(), getAnchor1X());
        float fMin2 = Math.min(getAnchor0Y(), getAnchor1Y());
        float fMax = Math.max(getAnchor0X(), getAnchor1X());
        float fMax2 = Math.max(getAnchor0Y(), getAnchor1Y());
        if (approximate) {
            bounds[0] = Math.min(fMin, Math.min(getControl0X(), getControl1X()));
            bounds[1] = Math.min(fMin2, Math.min(getControl0Y(), getControl1Y()));
            bounds[2] = Math.max(fMax, Math.max(getControl0X(), getControl1X()));
            bounds[3] = Math.max(fMax2, Math.max(getControl0Y(), getControl1Y()));
            return;
        }
        float f14 = 3;
        float control0X = (((-getAnchor0X()) + (getControl0X() * f14)) - (getControl1X() * f14)) + getAnchor1X();
        float f15 = 2;
        float f16 = 4;
        float anchor0X = ((getAnchor0X() * f15) - (getControl0X() * f16)) + (getControl1X() * f15);
        float control0X2 = (-getAnchor0X()) + getControl0X();
        if (!zeroIsh(control0X)) {
            float f17 = (anchor0X * anchor0X) - ((f16 * control0X) * control0X2);
            if (f17 >= 0.0f) {
                float f18 = -anchor0X;
                c10 = 3;
                c11 = 0;
                double d10 = f17;
                f10 = fMin2;
                c12 = 2;
                float f19 = control0X * f15;
                float fSqrt3 = (((float) Math.sqrt(d10)) + f18) / f19;
                if (0.0f <= fSqrt3 && fSqrt3 <= 1.0f) {
                    float fM51getXDnnuFBc = PointKt.m51getXDnnuFBc(m39pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt3));
                    if (fM51getXDnnuFBc < fMin) {
                        fMin = fM51getXDnnuFBc;
                    }
                    if (fM51getXDnnuFBc > fMax) {
                        fMax = fM51getXDnnuFBc;
                    }
                }
                float fSqrt4 = (f18 - ((float) Math.sqrt(d10))) / f19;
                if (0.0f <= fSqrt4 && fSqrt4 <= 1.0f) {
                    float fM51getXDnnuFBc2 = PointKt.m51getXDnnuFBc(m39pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt4));
                    if (fM51getXDnnuFBc2 < fMin) {
                        fMin = fM51getXDnnuFBc2;
                    }
                    if (fM51getXDnnuFBc2 > fMax) {
                        fMax = fM51getXDnnuFBc2;
                    }
                }
            }
            control0Y = (((-getAnchor0Y()) + (getControl0Y() * f14)) - (f14 * getControl1Y())) + getAnchor1Y();
            anchor0Y = ((getAnchor0Y() * f15) - (getControl0Y() * f16)) + (getControl1Y() * f15);
            control0Y2 = (-getAnchor0Y()) + getControl0Y();
            if (zeroIsh(control0Y)) {
                f11 = (anchor0Y * anchor0Y) - ((f16 * control0Y) * control0Y2);
                if (f11 >= 0.0f) {
                    float f20 = -anchor0Y;
                    double d11 = f11;
                    float f21 = f15 * control0Y;
                    fSqrt = (((float) Math.sqrt(d11)) + f20) / f21;
                    if (0.0f <= fSqrt && fSqrt <= 1.0f) {
                        fM52getYDnnuFBc2 = PointKt.m52getYDnnuFBc(m39pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt));
                        if (fM52getYDnnuFBc2 < f10) {
                            f10 = fM52getYDnnuFBc2;
                        }
                        if (fM52getYDnnuFBc2 > fMax2) {
                            fMax2 = fM52getYDnnuFBc2;
                        }
                    }
                    fSqrt2 = (f20 - ((float) Math.sqrt(d11))) / f21;
                    if (0.0f <= fSqrt2 || fSqrt2 > 1.0f) {
                        f12 = f10;
                    } else {
                        fM52getYDnnuFBc = PointKt.m52getYDnnuFBc(m39pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt2));
                        f12 = fM52getYDnnuFBc < f10 ? fM52getYDnnuFBc : f10;
                        if (fM52getYDnnuFBc > fMax2) {
                            fMax2 = fM52getYDnnuFBc;
                        }
                    }
                } else {
                    f12 = f10;
                }
            } else if (anchor0Y == 0.0f) {
                f12 = f10;
            } else {
                f13 = (f15 * control0Y2) / ((-2) * anchor0Y);
                if (0.0f <= f13 || f13 > 1.0f) {
                    f12 = f10;
                } else {
                    fM52getYDnnuFBc = PointKt.m52getYDnnuFBc(m39pointOnCurveOOQOV4g$graphics_shapes_release(f13));
                    f12 = fM52getYDnnuFBc < f10 ? fM52getYDnnuFBc : f10;
                    if (fM52getYDnnuFBc > fMax2) {
                        fMax2 = fM52getYDnnuFBc;
                    }
                }
            }
            bounds[c11] = fMin;
            bounds[1] = f12;
            bounds[c12] = fMax;
            bounds[c10] = fMax2;
        }
        if (anchor0X != 0.0f) {
            float f22 = (control0X2 * f15) / ((-2) * anchor0X);
            if (0.0f <= f22 && f22 <= 1.0f) {
                float fM51getXDnnuFBc3 = PointKt.m51getXDnnuFBc(m39pointOnCurveOOQOV4g$graphics_shapes_release(f22));
                if (fM51getXDnnuFBc3 < fMin) {
                    fMin = fM51getXDnnuFBc3;
                }
                if (fM51getXDnnuFBc3 > fMax) {
                    fMax = fM51getXDnnuFBc3;
                }
            }
        }
        f10 = fMin2;
        c10 = 3;
        c11 = 0;
        c12 = 2;
        control0Y = (((-getAnchor0Y()) + (getControl0Y() * f14)) - (f14 * getControl1Y())) + getAnchor1Y();
        anchor0Y = ((getAnchor0Y() * f15) - (getControl0Y() * f16)) + (getControl1Y() * f15);
        control0Y2 = (-getAnchor0Y()) + getControl0Y();
        if (zeroIsh(control0Y)) {
            f11 = (anchor0Y * anchor0Y) - ((f16 * control0Y) * control0Y2);
            if (f11 >= 0.0f) {
                float f23 = -anchor0Y;
                double d12 = f11;
                float f24 = f15 * control0Y;
                fSqrt = (((float) Math.sqrt(d12)) + f23) / f24;
                if (0.0f <= fSqrt) {
                    fM52getYDnnuFBc2 = PointKt.m52getYDnnuFBc(m39pointOnCurveOOQOV4g$graphics_shapes_release(fSqrt));
                    if (fM52getYDnnuFBc2 < f10) {
                        f10 = fM52getYDnnuFBc2;
                    }
                    if (fM52getYDnnuFBc2 > fMax2) {
                        fMax2 = fM52getYDnnuFBc2;
                    }
                }
                fSqrt2 = (f23 - ((float) Math.sqrt(d12))) / f24;
                if (0.0f <= fSqrt2) {
                    f12 = f10;
                } else {
                    f12 = f10;
                }
            } else {
                f12 = f10;
            }
        } else if (anchor0Y == 0.0f) {
            f12 = f10;
        } else {
            f13 = (f15 * control0Y2) / ((-2) * anchor0Y);
            if (0.0f <= f13) {
                f12 = f10;
            } else {
                f12 = f10;
            }
        }
        bounds[c11] = fMin;
        bounds[1] = f12;
        bounds[c12] = fMax;
        bounds[c10] = fMax2;
    }

    public final Cubic div(int x10) {
        return div(x10);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) other).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    /* JADX INFO: renamed from: getPoints$graphics_shapes_release, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic o10) {
        m.f(o10, "o");
        float[] fArr = new float[8];
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = this.points[i10] + o10.points[i10];
        }
        return new Cubic(fArr);
    }

    public final Cubic times(int x10) {
        return times(x10);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer f10) {
        m.f(f10, "f");
        MutableCubic mutableCubic = new MutableCubic();
        j.k(this.points, mutableCubic.getPoints(), 0, 0, 0, 14, null);
        mutableCubic.transform(f10);
        return mutableCubic;
    }

    public Cubic(float[] points) {
        m.f(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8");
        }
    }

    private final boolean zeroIsh(float value) {
        if (Math.abs(value) < 1.0E-4f) {
            return true;
        }
        return false;
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final boolean zeroLength$graphics_shapes_release() {
        if (Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f) {
            return true;
        }
        return false;
    }

    public /* synthetic */ Cubic(float[] fArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? new float[8] : fArr);
    }

    private Cubic(long j10, long j11, long j12, long j13) {
        this(new float[]{PointKt.m51getXDnnuFBc(j10), PointKt.m52getYDnnuFBc(j10), PointKt.m51getXDnnuFBc(j11), PointKt.m52getYDnnuFBc(j11), PointKt.m51getXDnnuFBc(j12), PointKt.m52getYDnnuFBc(j12), PointKt.m51getXDnnuFBc(j13), PointKt.m52getYDnnuFBc(j13)});
    }
}
