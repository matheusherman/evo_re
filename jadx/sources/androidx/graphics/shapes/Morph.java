package androidx.graphics.shapes;

import c9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.p;
import r8.v;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00180\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001cR&\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR,\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001d0\u00118@X\u0081\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2 = {"Landroidx/graphics/shapes/Morph;", "", "Landroidx/graphics/shapes/RoundedPolygon;", "start", "end", "<init>", "(Landroidx/graphics/shapes/RoundedPolygon;Landroidx/graphics/shapes/RoundedPolygon;)V", "", "bounds", "", "approximate", "calculateBounds", "([FZ)[F", "calculateMaxBounds", "([F)[F", "", "progress", "", "Landroidx/graphics/shapes/Cubic;", "asCubics", "(F)Ljava/util/List;", "Landroidx/graphics/shapes/MutableCubic;", "mutableCubic", "Lkotlin/Function1;", "Lr8/z;", "callback", "forEachCubic", "(FLandroidx/graphics/shapes/MutableCubic;Lc9/l;)V", "Landroidx/graphics/shapes/RoundedPolygon;", "Lr8/p;", "_morphMatch", "Ljava/util/List;", "getMorphMatch", "()Ljava/util/List;", "getMorphMatch$annotations", "()V", "morphMatch", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Morph {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<p<Cubic, Cubic>> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Morph$Companion;", "", "<init>", "()V", "Landroidx/graphics/shapes/RoundedPolygon;", "p1", "p2", "", "Lr8/p;", "Landroidx/graphics/shapes/Cubic;", "match$graphics_shapes_release", "(Landroidx/graphics/shapes/RoundedPolygon;Landroidx/graphics/shapes/RoundedPolygon;)Ljava/util/List;", "match", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public final List<p<Cubic, Cubic>> match$graphics_shapes_release(RoundedPolygon p10, RoundedPolygon p11) {
            p<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pVarA;
            p<MeasuredPolygon.MeasuredCubic, MeasuredPolygon.MeasuredCubic> pVarA2;
            m.f(p10, "p1");
            m.f(p11, "p2");
            MeasuredPolygon.Companion companion = MeasuredPolygon.INSTANCE;
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p10.getCenterX(), p10.getCenterY()), p10);
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release2 = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p11.getCenterX(), p11.getCenterY()), p11);
            DoubleMapper doubleMapperFeatureMapper = FeatureMappingKt.featureMapper(measuredPolygonMeasurePolygon$graphics_shapes_release.getFeatures(), measuredPolygonMeasurePolygon$graphics_shapes_release2.getFeatures());
            float map = doubleMapperFeatureMapper.map(0.0f);
            String unused = MorphKt.LOG_TAG;
            MeasuredPolygon measuredPolygonCutAndShift = measuredPolygonMeasurePolygon$graphics_shapes_release2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon.MeasuredCubic measuredCubicB = (MeasuredPolygon.MeasuredCubic) r.j0(measuredPolygonMeasurePolygon$graphics_shapes_release, 0);
            MeasuredPolygon.MeasuredCubic measuredCubicB2 = (MeasuredPolygon.MeasuredCubic) r.j0(measuredPolygonCutAndShift, 0);
            int i10 = 1;
            int i11 = 1;
            while (measuredCubicB != null && measuredCubicB2 != null) {
                float endOutlineProgress = i10 == measuredPolygonMeasurePolygon$graphics_shapes_release.size() ? 1.0f : measuredCubicB.getEndOutlineProgress();
                float fMapBack = i11 == measuredPolygonCutAndShift.size() ? 1.0f : doubleMapperFeatureMapper.mapBack(Utils.positiveModulo(measuredCubicB2.getEndOutlineProgress() + map, 1.0f));
                float fMin = Math.min(endOutlineProgress, fMapBack);
                String unused2 = MorphKt.LOG_TAG;
                float f10 = 1.0E-6f + fMin;
                if (endOutlineProgress > f10) {
                    String unused3 = MorphKt.LOG_TAG;
                    pVarA = measuredCubicB.cutAtProgress(fMin);
                } else {
                    pVarA = v.a(measuredCubicB, r.j0(measuredPolygonMeasurePolygon$graphics_shapes_release, i10));
                    i10++;
                }
                MeasuredPolygon.MeasuredCubic measuredCubicA = pVarA.a();
                measuredCubicB = pVarA.b();
                if (fMapBack > f10) {
                    String unused4 = MorphKt.LOG_TAG;
                    pVarA2 = measuredCubicB2.cutAtProgress(Utils.positiveModulo(doubleMapperFeatureMapper.map(fMin) - map, 1.0f));
                } else {
                    pVarA2 = v.a(measuredCubicB2, r.j0(measuredPolygonCutAndShift, i11));
                    i11++;
                }
                MeasuredPolygon.MeasuredCubic measuredCubicA2 = pVarA2.a();
                measuredCubicB2 = pVarA2.b();
                String unused5 = MorphKt.LOG_TAG;
                arrayList.add(v.a(measuredCubicA.getCubic(), measuredCubicA2.getCubic()));
            }
            if (measuredCubicB == null && measuredCubicB2 == null) {
                return arrayList;
            }
            throw new IllegalArgumentException("Expected both Polygon's Cubic to be fully matched");
        }
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final void forEachCubic(float progress, MutableCubic mutableCubic, l<? super MutableCubic, z> callback) {
        m.f(mutableCubic, "mutableCubic");
        m.f(callback, "callback");
        int size = getMorphMatch().size();
        for (int i10 = 0; i10 < size; i10++) {
            mutableCubic.interpolate(getMorphMatch().get(i10).c(), getMorphMatch().get(i10).d(), progress);
            callback.invoke(mutableCubic);
        }
    }

    public Morph(RoundedPolygon start, RoundedPolygon end) {
        m.f(start, "start");
        m.f(end, "end");
        this.start = start;
        this.end = end;
        this._morphMatch = INSTANCE.match$graphics_shapes_release(start, end);
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return morph.calculateBounds(fArr, z10);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public static /* synthetic */ void forEachCubic$default(Morph morph, float f10, MutableCubic mutableCubic, l callback, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        m.f(mutableCubic, "mutableCubic");
        m.f(callback, "callback");
        int size = morph.getMorphMatch().size();
        for (int i11 = 0; i11 < size; i11++) {
            mutableCubic.interpolate(morph.getMorphMatch().get(i11).c(), morph.getMorphMatch().get(i11).d(), f10);
            callback.invoke(mutableCubic);
        }
    }

    public final List<Cubic> asCubics(float progress) {
        List listC = r.c();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i10 = 0;
        while (i10 < size) {
            float[] fArr = new float[8];
            for (int i11 = 0; i11 < 8; i11++) {
                fArr[i11] = Utils.interpolate(this._morphMatch.get(i10).c().getPoints()[i11], this._morphMatch.get(i10).d().getPoints()[i11], progress);
            }
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                listC.add(cubic);
            }
            i10++;
            cubic = cubic3;
        }
        if (cubic != null && cubic2 != null) {
            listC.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return r.a(listC);
    }

    public final float[] calculateBounds(float[] bounds) {
        m.f(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        m.f(bounds, "bounds");
        this.start.calculateMaxBounds(bounds);
        float f10 = bounds[0];
        float f11 = bounds[1];
        float f12 = bounds[2];
        float f13 = bounds[3];
        this.end.calculateMaxBounds(bounds);
        bounds[0] = Math.min(f10, bounds[0]);
        bounds[1] = Math.min(f11, bounds[1]);
        bounds[2] = Math.max(f12, bounds[2]);
        bounds[3] = Math.max(f13, bounds[3]);
        return bounds;
    }

    public final List<p<Cubic, Cubic>> getMorphMatch() {
        return this._morphMatch;
    }

    public final float[] calculateBounds(float[] bounds, boolean approximate) {
        m.f(bounds, "bounds");
        this.start.calculateBounds(bounds, approximate);
        float f10 = bounds[0];
        float f11 = bounds[1];
        float f12 = bounds[2];
        float f13 = bounds[3];
        this.end.calculateBounds(bounds, approximate);
        bounds[0] = Math.min(f10, bounds[0]);
        bounds[1] = Math.min(f11, bounds[1]);
        bounds[2] = Math.max(f12, bounds[2]);
        bounds[3] = Math.max(f13, bounds[3]);
        return bounds;
    }

    public final void forEachCubic(float f10, l<? super MutableCubic, z> callback) {
        m.f(callback, "callback");
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i10 = 0; i10 < size; i10++) {
            mutableCubic.interpolate(getMorphMatch().get(i10).c(), getMorphMatch().get(i10).d(), f10);
            callback.invoke(mutableCubic);
        }
    }

    public static /* synthetic */ void getMorphMatch$annotations() {
    }
}
