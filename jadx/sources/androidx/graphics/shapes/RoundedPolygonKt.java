package androidx.graphics.shapes;

import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import h9.e;
import h9.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007\u001a\u0019\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"RoundedPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", "source", "vertices", "", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "perVertexRounding", "", "centerX", "", "centerY", "numVertices", "", "radius", "calculateCenter", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "([F)J", "verticesFromNumVerts", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10) {
        return RoundedPolygon$default(i10, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i10, float f10, float f11, float f12, CornerRounding cornerRounding, List list, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 8) != 0) {
            f12 = 0.0f;
        }
        if ((i11 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i11 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        float f13 = f12;
        return RoundedPolygon(i10, f10, f11, f13, cornerRounding, list2);
    }

    private static final long calculateCenter(float[] fArr) {
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i10 = 0;
        while (i10 < fArr.length) {
            int i11 = i10 + 1;
            f10 += fArr[i10];
            i10 += 2;
            f11 += fArr[i11];
        }
        float f12 = 2;
        return FloatFloatPair.m3constructorimpl((f10 / fArr.length) / f12, (f11 / fArr.length) / f12);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10) {
        return RoundedPolygon$default(i10, f10, 0.0f, 0.0f, null, null, 60, null);
    }

    private static final float[] verticesFromNumVerts(int i10, float f10, float f11, float f12) {
        float[] fArr = new float[i10 * 2];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            float f13 = f10;
            long jM55plusybeJwSQ = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f13, (Utils.getFloatPi() / i10) * 2 * i11, 0L, 4, null), FloatFloatPair.m3constructorimpl(f11, f12));
            int i13 = i12 + 1;
            fArr[i12] = PointKt.m51getXDnnuFBc(jM55plusybeJwSQ);
            i12 += 2;
            fArr[i13] = PointKt.m52getYDnnuFBc(jM55plusybeJwSQ);
            i11++;
            f10 = f13;
        }
        return fArr;
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11) {
        return RoundedPolygon$default(i10, f10, f11, 0.0f, null, null, 56, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i10 & 4) != 0) {
            list = null;
        }
        if ((i10 & 8) != 0) {
            f10 = Float.MIN_VALUE;
        }
        if ((i10 & 16) != 0) {
            f11 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f10, f11);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11, float f12) {
        return RoundedPolygon$default(i10, f10, f11, f12, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11, float f12, CornerRounding rounding) {
        m.f(rounding, "rounding");
        return RoundedPolygon$default(i10, f10, f11, f12, rounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices) {
        m.f(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding) {
        m.f(vertices, "vertices");
        m.f(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list) {
        m.f(vertices, "vertices");
        m.f(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f10) {
        m.f(vertices, "vertices");
        m.f(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f10, 0.0f, 16, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11, float f12, CornerRounding rounding, List<CornerRounding> list) {
        m.f(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i10, f10, f11, f12), rounding, list, f11, f12);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon source) {
        m.f(source, "source");
        return new RoundedPolygon(source.getFeatures$graphics_shapes_release(), source.getCenterX(), source.getCenterY());
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f10, float f11) {
        long jCalculateCenter;
        p pVarA;
        CornerRounding cornerRounding;
        Float fValueOf = Float.valueOf(1.0f);
        m.f(vertices, "vertices");
        m.f(rounding, "rounding");
        if (vertices.length >= 6) {
            int i10 = 1;
            if (vertices.length % 2 != 1) {
                if (list != null && list.size() * 2 != vertices.length) {
                    throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
                }
                ArrayList arrayList = new ArrayList();
                int length = vertices.length / 2;
                ArrayList arrayList2 = new ArrayList();
                int i11 = 0;
                int i12 = 0;
                while (i12 < length) {
                    CornerRounding cornerRounding2 = (list == null || (cornerRounding = list.get(i12)) == null) ? rounding : cornerRounding;
                    int i13 = (((i12 + length) - i10) % length) * 2;
                    int i14 = i12 + 1;
                    int i15 = (i14 % length) * 2;
                    int i16 = i12 * 2;
                    arrayList2.add(new RoundedCorner(FloatFloatPair.m3constructorimpl(vertices[i13], vertices[i13 + i10]), FloatFloatPair.m3constructorimpl(vertices[i16], vertices[i16 + i10]), FloatFloatPair.m3constructorimpl(vertices[i15], vertices[i15 + 1]), cornerRounding2, null));
                    i12 = i14;
                    i10 = 1;
                }
                e eVarM = f.m(0, length);
                ArrayList arrayList3 = new ArrayList(r.w(eVarM, 10));
                Iterator<Integer> it = eVarM.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((k0) it).nextInt();
                    int i17 = (iNextInt + 1) % length;
                    float expectedRoundCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i17)).getExpectedRoundCut();
                    float expectedCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i17)).getExpectedCut();
                    int i18 = iNextInt * 2;
                    int i19 = i17 * 2;
                    float fDistance = Utils.distance(vertices[i18] - vertices[i19], vertices[i18 + 1] - vertices[i19 + 1]);
                    if (expectedRoundCut > fDistance) {
                        pVarA = v.a(Float.valueOf(fDistance / expectedRoundCut), Float.valueOf(0.0f));
                    } else if (expectedCut > fDistance) {
                        pVarA = v.a(fValueOf, Float.valueOf((fDistance - expectedRoundCut) / (expectedCut - expectedRoundCut)));
                    } else {
                        pVarA = v.a(fValueOf, fValueOf);
                    }
                    arrayList3.add(pVarA);
                }
                for (int i20 = 0; i20 < length; i20++) {
                    MutableFloatList mutableFloatList = new MutableFloatList(2);
                    for (int i21 = 0; i21 < 2; i21++) {
                        p pVar = (p) arrayList3.get((((i20 + length) - 1) + i21) % length);
                        mutableFloatList.add((((RoundedCorner) arrayList2.get(i20)).getExpectedRoundCut() * ((Number) pVar.a()).floatValue()) + ((((RoundedCorner) arrayList2.get(i20)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i20)).getExpectedRoundCut()) * ((Number) pVar.b()).floatValue()));
                    }
                    arrayList.add(((RoundedCorner) arrayList2.get(i20)).getCubics(mutableFloatList.get(0), mutableFloatList.get(1)));
                }
                ArrayList arrayList4 = new ArrayList();
                while (i11 < length) {
                    int i22 = i11 + 1;
                    int i23 = i22 % length;
                    int i24 = i11 * 2;
                    long jM3constructorimpl = FloatFloatPair.m3constructorimpl(vertices[i24], vertices[i24 + 1]);
                    int i25 = (((i11 + length) - 1) % length) * 2;
                    long jM3constructorimpl2 = FloatFloatPair.m3constructorimpl(vertices[i25], vertices[i25 + 1]);
                    int i26 = i23 * 2;
                    arrayList4.add(new Feature.Corner((List) arrayList.get(i11), jM3constructorimpl, ((RoundedCorner) arrayList2.get(i11)).getCenter(), PointKt.m42clockwiseybeJwSQ(PointKt.m54minusybeJwSQ(jM3constructorimpl, jM3constructorimpl2), PointKt.m54minusybeJwSQ(FloatFloatPair.m3constructorimpl(vertices[i26], vertices[i26 + 1]), jM3constructorimpl)), null));
                    arrayList4.add(new Feature.Edge(r.e(Cubic.INSTANCE.straightLine(((Cubic) r.s0((List) arrayList.get(i11))).getAnchor1X(), ((Cubic) r.s0((List) arrayList.get(i11))).getAnchor1Y(), ((Cubic) r.g0((List) arrayList.get(i23))).getAnchor0X(), ((Cubic) r.g0((List) arrayList.get(i23))).getAnchor0Y()))));
                    i11 = i22;
                }
                if (f10 == Float.MIN_VALUE || f11 == Float.MIN_VALUE) {
                    jCalculateCenter = calculateCenter(vertices);
                } else {
                    jCalculateCenter = FloatFloatPair.m3constructorimpl(f10, f11);
                }
                return new RoundedPolygon(arrayList4, Float.intBitsToFloat((int) (jCalculateCenter >> 32)), Float.intBitsToFloat((int) (jCalculateCenter & 4294967295L)));
            }
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        throw new IllegalArgumentException("Polygons must have at least 3 vertices");
    }
}
