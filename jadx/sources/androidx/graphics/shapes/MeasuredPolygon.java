package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import com.google.android.material.color.utilities.Contrast;
import h9.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.d;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.p;
import r8.v;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u0000 \u001d2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB5\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001e\u0010\t\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon;", "Lkotlin/collections/d;", "Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "Landroidx/graphics/shapes/Measurer;", "measurer", "", "Landroidx/graphics/shapes/ProgressableFeature;", "features", "Landroidx/graphics/shapes/Cubic;", "cubics", "Landroidx/collection/FloatList;", "outlineProgress", "<init>", "(Landroidx/graphics/shapes/Measurer;Ljava/util/List;Ljava/util/List;Landroidx/collection/FloatList;)V", "", "cuttingPoint", "cutAndShift", "(F)Landroidx/graphics/shapes/MeasuredPolygon;", "", "index", "get", "(I)Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "Landroidx/graphics/shapes/Measurer;", "Ljava/util/List;", "getFeatures", "()Ljava/util/List;", "getSize", "()I", "size", "Companion", "MeasuredCubic", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MeasuredPolygon extends d<MeasuredCubic> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<MeasuredCubic> cubics;
    private final List<ProgressableFeature> features;
    private final Measurer measurer;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$Companion;", "", "()V", "measurePolygon", "Landroidx/graphics/shapes/MeasuredPolygon;", "measurer", "Landroidx/graphics/shapes/Measurer;", "polygon", "Landroidx/graphics/shapes/RoundedPolygon;", "measurePolygon$graphics_shapes_release", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public final MeasuredPolygon measurePolygon$graphics_shapes_release(Measurer measurer, RoundedPolygon polygon) {
            List listE;
            m.f(measurer, "measurer");
            m.f(polygon, "polygon");
            ArrayList<Cubic> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = polygon.getFeatures$graphics_shapes_release().size();
            for (int i10 = 0; i10 < size; i10++) {
                Feature feature = polygon.getFeatures$graphics_shapes_release().get(i10);
                int size2 = feature.getCubics().size();
                for (int i11 = 0; i11 < size2; i11++) {
                    if ((feature instanceof Feature.Corner) && i11 == feature.getCubics().size() / 2) {
                        arrayList2.add(v.a(feature, Integer.valueOf(arrayList.size())));
                    }
                    arrayList.add(feature.getCubics().get(i11));
                }
            }
            Float fValueOf = Float.valueOf(0.0f);
            int iW = r.w(arrayList, 9);
            if (iW == 0) {
                listE = r.e(fValueOf);
            } else {
                ArrayList arrayList3 = new ArrayList(iW + 1);
                arrayList3.add(fValueOf);
                for (Cubic cubic : arrayList) {
                    float fFloatValue = fValueOf.floatValue();
                    float fMeasureCubic = measurer.measureCubic(cubic);
                    if (fMeasureCubic < 0.0f) {
                        throw new IllegalArgumentException("Measured cubic is expected to be greater or equal to zero");
                    }
                    z zVar = z.f17874a;
                    fValueOf = Float.valueOf(fFloatValue + fMeasureCubic);
                    arrayList3.add(fValueOf);
                }
                listE = arrayList3;
            }
            float fFloatValue2 = ((Number) r.s0(listE)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(listE.size());
            int size3 = listE.size();
            for (int i12 = 0; i12 < size3; i12++) {
                mutableFloatList.add(((Number) listE.get(i12)).floatValue() / fFloatValue2);
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            List listC = r.c();
            int size4 = arrayList2.size();
            for (int i13 = 0; i13 < size4; i13++) {
                int iIntValue = ((Number) ((p) arrayList2.get(i13)).d()).intValue();
                listC.add(new ProgressableFeature((mutableFloatList.get(iIntValue) + mutableFloatList.get(iIntValue + 1)) / 2, (Feature) ((p) arrayList2.get(i13)).c()));
            }
            return new MeasuredPolygon(measurer, r.a(listC), arrayList, mutableFloatList, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0000R\u00020\u000f\u0012\b\u0012\u00060\u0000R\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR$\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "", "Landroidx/graphics/shapes/Cubic;", "cubic", "", "startOutlineProgress", "endOutlineProgress", "<init>", "(Landroidx/graphics/shapes/MeasuredPolygon;Landroidx/graphics/shapes/Cubic;FF)V", "Lr8/z;", "updateProgressRange$graphics_shapes_release", "(FF)V", "updateProgressRange", "cutOutlineProgress", "Lr8/p;", "Landroidx/graphics/shapes/MeasuredPolygon;", "cutAtProgress", "(F)Lr8/p;", "", "toString", "()Ljava/lang/String;", "Landroidx/graphics/shapes/Cubic;", "getCubic", "()Landroidx/graphics/shapes/Cubic;", "measuredSize", "F", "getMeasuredSize", "()F", "<set-?>", "getStartOutlineProgress", "getEndOutlineProgress", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MeasuredCubic {
        private final Cubic cubic;
        private float endOutlineProgress;

        /* JADX INFO: renamed from: measuredSize, reason: from kotlin metadata and from toString */
        private final float size;

        /* JADX INFO: renamed from: startOutlineProgress, reason: from kotlin metadata and from toString */
        private float outlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(MeasuredPolygon measuredPolygon, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) Cubic cubic, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10, float f11) {
            m.f(cubic, "cubic");
            this.this$0 = measuredPolygon;
            this.cubic = cubic;
            if (f11 < f10) {
                throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            }
            this.size = measuredPolygon.measurer.measureCubic(cubic);
            this.outlineProgress = f10;
            this.endOutlineProgress = f11;
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes_release$default(MeasuredCubic measuredCubic, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = measuredCubic.outlineProgress;
            }
            if ((i10 & 2) != 0) {
                f11 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes_release(f10, f11);
        }

        public final p<MeasuredCubic, MeasuredCubic> cutAtProgress(float cutOutlineProgress) {
            float fG = f.g(cutOutlineProgress, this.outlineProgress, this.endOutlineProgress);
            float f10 = this.endOutlineProgress;
            float f11 = this.outlineProgress;
            float fFindCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((fG - f11) / (f10 - f11)) * this.size);
            if (0.0f > fFindCubicCutPoint || fFindCubicCutPoint > 1.0f) {
                throw new IllegalArgumentException("Cubic cut point is expected to be between 0 and 1");
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            p<Cubic, Cubic> pVarSplit = this.cubic.split(fFindCubicCutPoint);
            return v.a(new MeasuredCubic(this.this$0, pVarSplit.a(), this.outlineProgress, fG), new MeasuredCubic(this.this$0, pVarSplit.b(), fG, this.endOutlineProgress));
        }

        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        /* JADX INFO: renamed from: getMeasuredSize, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: getStartOutlineProgress, reason: from getter */
        public final float getOutlineProgress() {
            return this.outlineProgress;
        }

        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.outlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.size + ", cubic=" + this.cubic + ')';
        }

        public final void updateProgressRange$graphics_shapes_release(float startOutlineProgress, float endOutlineProgress) {
            if (endOutlineProgress < startOutlineProgress) {
                throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            }
            this.outlineProgress = startOutlineProgress;
            this.endOutlineProgress = endOutlineProgress;
        }
    }

    public /* synthetic */ MeasuredPolygon(Measurer measurer, List list, List list2, FloatList floatList, g gVar) {
        this(measurer, list, list2, floatList);
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains((Object) measuredCubic);
    }

    public final MeasuredPolygon cutAndShift(float cuttingPoint) {
        if (0.0f > cuttingPoint || cuttingPoint > 1.0f) {
            throw new IllegalArgumentException("Cutting point is expected to be between 0 and 1");
        }
        if (cuttingPoint < 1.0E-4f) {
            return this;
        }
        Iterator<MeasuredCubic> it = this.cubics.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            MeasuredCubic next = it.next();
            float outlineProgress = next.getOutlineProgress();
            if (cuttingPoint <= next.getEndOutlineProgress() && outlineProgress <= cuttingPoint) {
                break;
            }
            i10++;
        }
        p<MeasuredCubic, MeasuredCubic> pVarCutAtProgress = this.cubics.get(i10).cutAtProgress(cuttingPoint);
        MeasuredCubic measuredCubicA = pVarCutAtProgress.a();
        MeasuredCubic measuredCubicB = pVarCutAtProgress.b();
        String unused = PolygonMeasureKt.LOG_TAG;
        List listR = r.r(measuredCubicB.getCubic());
        int size = this.cubics.size();
        for (int i11 = 1; i11 < size; i11++) {
            List<MeasuredCubic> list = this.cubics;
            listR.add(list.get((i11 + i10) % list.size()).getCubic());
        }
        listR.add(measuredCubicA.getCubic());
        MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
        int size2 = this.cubics.size() + 2;
        int i12 = 0;
        while (i12 < size2) {
            mutableFloatList.add(i12 == 0 ? 0.0f : i12 == this.cubics.size() + 1 ? 1.0f : Utils.positiveModulo(this.cubics.get(((i10 + i12) - 1) % this.cubics.size()).getEndOutlineProgress() - cuttingPoint, 1.0f));
            i12++;
        }
        List listC = r.c();
        int size3 = this.features.size();
        for (int i13 = 0; i13 < size3; i13++) {
            listC.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i13).getProgress() - cuttingPoint, 1.0f), this.features.get(i13).getFeature()));
        }
        return new MeasuredPolygon(this.measurer, r.a(listC), listR, mutableFloatList);
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf((Object) measuredCubic);
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf((Object) measuredCubic);
    }

    private MeasuredPolygon(Measurer measurer, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList.getSize() != list2.size() + 1) {
            throw new IllegalArgumentException("Outline progress size is expected to be the cubics size + 1");
        }
        if (floatList.first() != 0.0f) {
            throw new IllegalArgumentException("First outline progress value is expected to be zero");
        }
        if (floatList.last() != 1.0f) {
            throw new IllegalArgumentException("Last outline progress value is expected to be one");
        }
        this.measurer = measurer;
        this.features = list;
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int i10 = 0;
        float f10 = 0.0f;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (floatList.get(i11) - floatList.get(i10) > 1.0E-4f) {
                arrayList.add(new MeasuredCubic(this, list2.get(i10), f10, floatList.get(i11)));
                f10 = floatList.get(i11);
            }
            i10 = i11;
        }
        MeasuredCubic.updateProgressRange$graphics_shapes_release$default((MeasuredCubic) arrayList.get(r.n(arrayList)), 0.0f, 1.0f, 1, null);
        this.cubics = arrayList;
    }

    @Override // kotlin.collections.b, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return contains((MeasuredCubic) obj);
        }
        return false;
    }

    @Override // kotlin.collections.d, java.util.List
    public MeasuredCubic get(int index) {
        return this.cubics.get(index);
    }

    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    /* JADX INFO: renamed from: getSize */
    public int get_size() {
        return this.cubics.size();
    }

    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return indexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return lastIndexOf((MeasuredCubic) obj);
        }
        return -1;
    }
}
