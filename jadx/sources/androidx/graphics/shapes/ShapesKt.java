package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import com.google.android.material.color.utilities.Contrast;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import h9.e;
import h9.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a0\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a4\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001a>\u0010\u0012\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001a\u0084\u0001\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001aN\u0010\u001b\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u001ad\u0010\u001c\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007¨\u0006\u001d"}, d2 = {"pillStarVerticesFromNumVerts", "", "numVerticesPerRadius", "", "width", "", "height", "innerRadius", "vertexSpacing", "startLocation", "centerX", "centerY", "starVerticesFromNumVerts", "radius", "circle", "Landroidx/graphics/shapes/RoundedPolygon;", "Landroidx/graphics/shapes/RoundedPolygon$Companion;", "numVertices", "pill", "smoothing", "pillStar", "innerRadiusRatio", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "innerRounding", "perVertexRounding", "", "rectangle", "star", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShapesKt {
    public static final RoundedPolygon circle(RoundedPolygon.Companion companion) {
        m.f(companion, "<this>");
        return circle$default(companion, 0, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion) {
        m.f(companion, "<this>");
        return pill$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion) {
        m.f(companion, "<this>");
        return pillStar$default(companion, 0.0f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2047, null);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f10, float f11, int i10, float f12, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f13, float f14, float f15, float f16, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f10 = 2.0f;
        }
        if ((i11 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            i10 = 8;
        }
        if ((i11 & 8) != 0) {
            f12 = 0.5f;
        }
        if ((i11 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i11 & 32) != 0) {
            cornerRounding2 = null;
        }
        if ((i11 & 64) != 0) {
            list = null;
        }
        if ((i11 & 128) != 0) {
            f13 = 0.5f;
        }
        if ((i11 & 256) != 0) {
            f14 = 0.0f;
        }
        if ((i11 & 512) != 0) {
            f15 = 0.0f;
        }
        return pillStar(companion, f10, f11, i10, f12, cornerRounding, cornerRounding2, list, f13, f14, f15, (i11 & 1024) != 0 ? 0.0f : f16);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10) {
        m.f(companion, "<this>");
        return star$default(companion, i10, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, 254, null);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i10, float f10, float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f12, float f13, int i11, Object obj) {
        return star(companion, i10, (i11 & 2) != 0 ? 1.0f : f10, (i11 & 4) != 0 ? 0.5f : f11, (i11 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding, (i11 & 16) != 0 ? null : cornerRounding2, (i11 & 32) == 0 ? list : null, (i11 & 64) != 0 ? 0.0f : f12, (i11 & 128) != 0 ? 0.0f : f13);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10) {
        m.f(companion, "<this>");
        return circle$default(companion, i10, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i10, float f10, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8;
        }
        if ((i11 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            f12 = 0.0f;
        }
        return circle(companion, i10, f10, f11, f12);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f10) {
        m.f(companion, "<this>");
        return pill$default(companion, f10, 0.0f, 0.0f, 0.0f, 0.0f, 30, null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f10, float f11, float f12, float f13, float f14, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 2.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        return pill(companion, f10, f11, f12, f13, (i10 & 16) != 0 ? 0.0f : f14);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10) {
        m.f(companion, "<this>");
        return pillStar$default(companion, f10, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2046, null);
    }

    private static final float[] pillStarVerticesFromNumVerts(int i10, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        float f17;
        float f18;
        long jM3constructorimpl;
        float fMin = Math.min(f10, f11);
        float fB = f.b(f11 - f10, 0.0f);
        float fB2 = f.b(f10 - f11, 0.0f);
        float f19 = 2;
        float f20 = fB / f19;
        float f21 = fB2 / f19;
        float twoPi = Utils.getTwoPi() * fMin * Utils.interpolate(f12, 1.0f, f13);
        float f22 = (f19 * fB2) + (f19 * fB) + twoPi;
        float f23 = twoPi / 4;
        float f24 = f20 + f23;
        float f25 = f24 + fB2;
        float f26 = f25 + f23;
        float f27 = f26 + fB;
        float f28 = f27 + f23;
        float f29 = f28 + fB2;
        float f30 = f29 + f23;
        float[] fArr = {0.0f, f20, f24, f25, f26, f27, f28, f29, f30, f30 + f20, f22};
        int i11 = i10 * 2;
        float f31 = f22 / i11;
        float f32 = f14 * f22;
        float[] fArr2 = new float[i10 * 4];
        long jM3constructorimpl2 = FloatFloatPair.m3constructorimpl(f21, f20);
        float f33 = -f21;
        long jM3constructorimpl3 = FloatFloatPair.m3constructorimpl(f33, f20);
        float f34 = -f20;
        long jM3constructorimpl4 = FloatFloatPair.m3constructorimpl(f33, f34);
        long jM3constructorimpl5 = FloatFloatPair.m3constructorimpl(f21, f34);
        float f35 = f20;
        int i12 = 0;
        float f36 = 0.0f;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i11) {
            float f37 = f32 % f22;
            if (f37 < f36) {
                i13 = 0;
            }
            while (true) {
                int i15 = (i13 + 1) % 11;
                float f38 = fArr[i15];
                if (f37 >= f38) {
                    f35 = fArr[(i15 + 1) % 11];
                    i13 = i15;
                    f36 = f38;
                } else {
                    float f39 = (f37 - f36) / (f35 - f36);
                    float f40 = z10 ? fMin * f12 : fMin;
                    switch (i13) {
                        case 0:
                            f17 = f20;
                            float f41 = f40;
                            f18 = f21;
                            jM3constructorimpl = FloatFloatPair.m3constructorimpl(f41, f39 * f17);
                            break;
                        case 1:
                            f17 = f20;
                            float f42 = f40;
                            f18 = f21;
                            jM3constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f42, (f39 * Utils.getFloatPi()) / f19, 0L, 4, null), jM3constructorimpl2);
                            break;
                        case 2:
                            f17 = f20;
                            float f43 = f40;
                            f18 = f21;
                            jM3constructorimpl = FloatFloatPair.m3constructorimpl(f18 - (f39 * fB2), f43);
                            break;
                        case 3:
                            f17 = f20;
                            float f44 = f40;
                            f18 = f21;
                            jM3constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f44, (Utils.getFloatPi() / f19) + ((f39 * Utils.getFloatPi()) / f19), 0L, 4, null), jM3constructorimpl3);
                            break;
                        case 4:
                            f17 = f20;
                            float f45 = f40;
                            f18 = f21;
                            jM3constructorimpl = FloatFloatPair.m3constructorimpl(-f45, f17 - (f39 * fB));
                            break;
                        case 5:
                            f17 = f20;
                            float f46 = f40;
                            f18 = f21;
                            jM3constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f46, Utils.getFloatPi() + ((f39 * Utils.getFloatPi()) / f19), 0L, 4, null), jM3constructorimpl4);
                            break;
                        case 6:
                            f17 = f20;
                            float f47 = f40;
                            f18 = f21;
                            jM3constructorimpl = FloatFloatPair.m3constructorimpl(f33 + (f39 * fB2), -f47);
                            break;
                        case 7:
                            f17 = f20;
                            float f48 = f40;
                            f18 = f21;
                            jM3constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f48, (Utils.getFloatPi() * 1.5f) + ((f39 * Utils.getFloatPi()) / f19), 0L, 4, null), jM3constructorimpl5);
                            break;
                        default:
                            f17 = f20;
                            jM3constructorimpl = FloatFloatPair.m3constructorimpl(f40, f34 + (f39 * f20));
                            f18 = f21;
                            break;
                    }
                    int i16 = i14 + 1;
                    fArr2[i14] = PointKt.m51getXDnnuFBc(jM3constructorimpl) + f15;
                    i14 += 2;
                    fArr2[i16] = PointKt.m52getYDnnuFBc(jM3constructorimpl) + f16;
                    f32 += f31;
                    z10 = !z10;
                    f21 = f18;
                    i12++;
                    f20 = f17;
                }
            }
        }
        return fArr2;
    }

    public static final RoundedPolygon rectangle(RoundedPolygon.Companion companion, float f10, float f11, CornerRounding rounding, List<CornerRounding> list, float f12, float f13) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        float f14 = 2;
        float f15 = f10 / f14;
        float f16 = f12 - f15;
        float f17 = f11 / f14;
        float f18 = f13 - f17;
        float f19 = f15 + f12;
        float f20 = f17 + f13;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f19, f20, f16, f20, f16, f18, f19, f18}, rounding, list, f12, f13);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f10, float f11, CornerRounding cornerRounding, List list, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 2.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 2.0f;
        }
        if ((i10 & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i10 & 8) != 0) {
            list = null;
        }
        if ((i10 & 16) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 32) != 0) {
            f13 = 0.0f;
        }
        return rectangle(companion, f10, f11, cornerRounding, list, f12, f13);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f10) {
        m.f(companion, "<this>");
        return star$default(companion, i10, f10, 0.0f, null, null, null, 0.0f, 0.0f, 252, null);
    }

    private static final float[] starVerticesFromNumVerts(int i10, float f10, float f11, float f12, float f13) {
        float[] fArr = new float[i10 * 4];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f14 = i10;
            long jM71radialToCartesianL6JJ3z0$default = Utils.m71radialToCartesianL6JJ3z0$default(f10, (Utils.getFloatPi() / f14) * 2 * i12, 0L, 4, null);
            fArr[i11] = PointKt.m51getXDnnuFBc(jM71radialToCartesianL6JJ3z0$default) + f12;
            fArr[i11 + 1] = PointKt.m52getYDnnuFBc(jM71radialToCartesianL6JJ3z0$default) + f13;
            long jM71radialToCartesianL6JJ3z0$default2 = Utils.m71radialToCartesianL6JJ3z0$default(f11, (Utils.getFloatPi() / f14) * ((i12 * 2) + 1), 0L, 4, null);
            int i13 = i11 + 3;
            fArr[i11 + 2] = PointKt.m51getXDnnuFBc(jM71radialToCartesianL6JJ3z0$default2) + f12;
            i11 += 4;
            fArr[i13] = PointKt.m52getYDnnuFBc(jM71radialToCartesianL6JJ3z0$default2) + f13;
        }
        return fArr;
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f10) {
        m.f(companion, "<this>");
        return circle$default(companion, i10, f10, 0.0f, 0.0f, 12, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f10, float f11) {
        m.f(companion, "<this>");
        return pill$default(companion, f10, f11, 0.0f, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11) {
        m.f(companion, "<this>");
        return pillStar$default(companion, f10, f11, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2044, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f10, float f11) {
        m.f(companion, "<this>");
        return star$default(companion, i10, f10, f11, null, null, null, 0.0f, 0.0f, 248, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f10, float f11) {
        m.f(companion, "<this>");
        return circle$default(companion, i10, f10, f11, 0.0f, 8, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f10, float f11, float f12) {
        m.f(companion, "<this>");
        return pill$default(companion, f10, f11, f12, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10) {
        m.f(companion, "<this>");
        return pillStar$default(companion, f10, f11, i10, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2040, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f10, float f11, CornerRounding rounding) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, null, null, 0.0f, 0.0f, 240, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f10, float f11, float f12) {
        m.f(companion, "<this>");
        if (i10 >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i10, f10 / ((float) Math.cos(Utils.getFloatPi() / i10)), f11, f12, new CornerRounding(f10, 0.0f, 2, null), null, 32, null);
        }
        throw new IllegalArgumentException("Circle must have at least three vertices");
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f10, float f11, float f12, float f13) {
        m.f(companion, "<this>");
        return pill$default(companion, f10, f11, f12, f13, 0.0f, 16, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12) {
        m.f(companion, "<this>");
        return pillStar$default(companion, f10, f11, i10, f12, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2032, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f10, float f11, CornerRounding rounding, CornerRounding cornerRounding) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, cornerRounding, null, 0.0f, 0.0f, 224, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f10, float f11, float f12, float f13, float f14) {
        m.f(companion, "<this>");
        if (f10 > 0.0f && f11 > 0.0f) {
            float f15 = 2;
            float f16 = f10 / f15;
            float f17 = f11 / f15;
            float f18 = f16 + f13;
            float f19 = f17 + f14;
            float f20 = (-f16) + f13;
            float f21 = (-f17) + f14;
            return RoundedPolygonKt.RoundedPolygon$default(new float[]{f18, f19, f20, f19, f20, f21, f18, f21}, new CornerRounding(Math.min(f16, f17), f12), null, f13, f14, 4, null);
        }
        throw new IllegalArgumentException("Pill shapes must have positive width and height");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12, CornerRounding rounding) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2016, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f10, float f11, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, cornerRounding, list, 0.0f, 0.0f, RsaOaep.DerParser.PRIVATE, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12, CornerRounding rounding, CornerRounding cornerRounding) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, null, 0.0f, 0.0f, 0.0f, 0.0f, 1984, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f10, float f11, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f12) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, cornerRounding, list, f12, 0.0f, 128, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, 0.0f, 0.0f, 0.0f, 0.0f, 1920, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i10, float f10, float f11, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f12, float f13) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        if (f10 <= 0.0f || f11 <= 0.0f) {
            throw new IllegalArgumentException("Star radii must both be greater than 0");
        }
        if (f11 < f10) {
            if (list == null && cornerRounding != null) {
                e eVarM = f.m(0, i10);
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = eVarM.iterator();
                while (it.hasNext()) {
                    ((k0) it).nextInt();
                    r.C(arrayList, r.o(rounding, cornerRounding));
                }
                list = arrayList;
            }
            return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i10, f10, f11, f12, f13), rounding, list, f12, f13);
        }
        throw new IllegalArgumentException("innerRadius must be less than radius");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f13) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, f13, 0.0f, 0.0f, 0.0f, 1792, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f13, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f14) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, f13, f14, 0.0f, 0.0f, 1536, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f13, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f14, float f15) {
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, f13, f14, f15, 0.0f, 1024, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f12, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f13, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f14, float f15, float f16) {
        List<CornerRounding> arrayList;
        m.f(companion, "<this>");
        m.f(rounding, "rounding");
        if (f10 <= 0.0f || f11 <= 0.0f) {
            throw new IllegalArgumentException("Pill shapes must have positive width and height");
        }
        if (f12 > 0.0f && f12 <= 1.0f) {
            if (list != null || cornerRounding == null) {
                arrayList = list;
            } else {
                e eVarM = f.m(0, i10);
                arrayList = new ArrayList<>();
                Iterator<Integer> it = eVarM.iterator();
                while (it.hasNext()) {
                    ((k0) it).nextInt();
                    r.C(arrayList, r.o(rounding, cornerRounding));
                }
            }
            return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i10, f10, f11, f12, f13, f14, f15, f16), rounding, arrayList, f15, f16);
        }
        throw new IllegalArgumentException("innerRadius must be between 0 and 1");
    }
}
