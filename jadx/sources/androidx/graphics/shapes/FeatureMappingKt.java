package androidx.graphics.shapes;

import h9.e;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.k0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0000\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0000\u001a,\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u000f\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0010"}, d2 = {"LOG_TAG", "", "doMapping", "", "Landroidx/graphics/shapes/ProgressableFeature;", "Landroidx/graphics/shapes/MeasuredFeatures;", "f1", "f2", "featureDistSquared", "", "Landroidx/graphics/shapes/Feature;", "featureMapper", "Landroidx/graphics/shapes/DoubleMapper;", "features1", "features2", "MeasuredFeatures", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FeatureMappingKt {
    private static final String LOG_TAG = "FeatureMapping";

    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> f10, List<ProgressableFeature> f11) {
        m.f(f10, "f1");
        m.f(f11, "f2");
        Iterator<Integer> it = r.m(f11).iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        k0 k0Var = (k0) it;
        int iNextInt = k0Var.nextInt();
        if (it.hasNext()) {
            float fFeatureDistSquared = featureDistSquared(f10.get(0).getFeature(), f11.get(iNextInt).getFeature());
            do {
                int iNextInt2 = k0Var.nextInt();
                float fFeatureDistSquared2 = featureDistSquared(f10.get(0).getFeature(), f11.get(iNextInt2).getFeature());
                if (Float.compare(fFeatureDistSquared, fFeatureDistSquared2) > 0) {
                    iNextInt = iNextInt2;
                    fFeatureDistSquared = fFeatureDistSquared2;
                }
            } while (it.hasNext());
        }
        int size = f10.size();
        int size2 = f11.size();
        List<ProgressableFeature> listR = r.r(f11.get(iNextInt));
        int i10 = iNextInt;
        for (int i11 = 1; i11 < size; i11++) {
            int i12 = iNextInt - (size - i11);
            if (i12 <= i10) {
                i12 += size2;
            }
            Iterator<Integer> it2 = new e(i10 + 1, i12).iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            k0 k0Var2 = (k0) it2;
            int iNextInt3 = k0Var2.nextInt();
            if (it2.hasNext()) {
                float fFeatureDistSquared3 = featureDistSquared(f10.get(i11).getFeature(), f11.get(iNextInt3 % size2).getFeature());
                do {
                    int iNextInt4 = k0Var2.nextInt();
                    float fFeatureDistSquared4 = featureDistSquared(f10.get(i11).getFeature(), f11.get(iNextInt4 % size2).getFeature());
                    if (Float.compare(fFeatureDistSquared3, fFeatureDistSquared4) > 0) {
                        iNextInt3 = iNextInt4;
                        fFeatureDistSquared3 = fFeatureDistSquared4;
                    }
                } while (it2.hasNext());
            }
            i10 = iNextInt3;
            listR.add(f11.get(i10 % size2));
        }
        return listR;
    }

    public static final float featureDistSquared(Feature f10, Feature f11) {
        m.f(f10, "f1");
        m.f(f11, "f2");
        if ((f10 instanceof Feature.Corner) && (f11 instanceof Feature.Corner) && ((Feature.Corner) f10).getConvex() != ((Feature.Corner) f11).getConvex()) {
            return Float.MAX_VALUE;
        }
        float anchor0X = (((Cubic) r.g0(f10.getCubics())).getAnchor0X() + ((Cubic) r.s0(f10.getCubics())).getAnchor1X()) / 2.0f;
        float anchor0Y = (((Cubic) r.g0(f10.getCubics())).getAnchor0Y() + ((Cubic) r.s0(f10.getCubics())).getAnchor1Y()) / 2.0f;
        float anchor0X2 = anchor0X - ((((Cubic) r.g0(f11.getCubics())).getAnchor0X() + ((Cubic) r.s0(f11.getCubics())).getAnchor1X()) / 2.0f);
        float anchor0Y2 = anchor0Y - ((((Cubic) r.g0(f11.getCubics())).getAnchor0Y() + ((Cubic) r.s0(f11.getCubics())).getAnchor1Y()) / 2.0f);
        return (anchor0X2 * anchor0X2) + (anchor0Y2 * anchor0Y2);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> features1, List<ProgressableFeature> features2) {
        m.f(features1, "features1");
        m.f(features2, "features2");
        List listC = r.c();
        int size = features1.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (features1.get(i10).getFeature() instanceof Feature.Corner) {
                listC.add(features1.get(i10));
            }
        }
        List listA = r.a(listC);
        List listC2 = r.c();
        int size2 = features2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (features2.get(i11).getFeature() instanceof Feature.Corner) {
                listC2.add(features2.get(i11));
            }
        }
        List listA2 = r.a(listC2);
        p pVarA = listA.size() > listA2.size() ? v.a(doMapping(listA2, listA), listA2) : v.a(listA, doMapping(listA, listA2));
        List list = (List) pVarA.a();
        List list2 = (List) pVarA.b();
        List listC3 = r.c();
        int size3 = list.size();
        for (int i12 = 0; i12 < size3 && i12 != list2.size(); i12++) {
            listC3.add(v.a(Float.valueOf(((ProgressableFeature) list.get(i12)).getProgress()), Float.valueOf(((ProgressableFeature) list2.get(i12)).getProgress())));
        }
        p[] pVarArr = (p[]) r.a(listC3).toArray(new p[0]);
        return new DoubleMapper((p[]) Arrays.copyOf(pVarArr, pVarArr.length));
    }
}
