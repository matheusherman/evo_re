package androidx.graphics.shapes;

import androidx.collection.MutableFloatList;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.p;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B3\u0012*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/graphics/shapes/DoubleMapper;", "", "", "Lr8/p;", "", "mappings", "<init>", "([Lr8/p;)V", "x", "map", "(F)F", "mapBack", "Landroidx/collection/MutableFloatList;", "sourceValues", "Landroidx/collection/MutableFloatList;", "targetValues", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DoubleMapper {
    public static final DoubleMapper Identity;
    private final MutableFloatList sourceValues;
    private final MutableFloatList targetValues;

    static {
        Float fValueOf = Float.valueOf(0.0f);
        p pVarA = v.a(fValueOf, fValueOf);
        Float fValueOf2 = Float.valueOf(0.5f);
        Identity = new DoubleMapper(pVarA, v.a(fValueOf2, fValueOf2));
    }

    public DoubleMapper(p<Float, Float>... mappings) {
        m.f(mappings, "mappings");
        this.sourceValues = new MutableFloatList(mappings.length);
        this.targetValues = new MutableFloatList(mappings.length);
        int length = mappings.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.sourceValues.add(mappings[i10].c().floatValue());
            this.targetValues.add(mappings[i10].d().floatValue());
        }
        FloatMappingKt.validateProgress(this.sourceValues);
        FloatMappingKt.validateProgress(this.targetValues);
    }

    public final float map(float x10) {
        return FloatMappingKt.linearMap(this.sourceValues, this.targetValues, x10);
    }

    public final float mapBack(float x10) {
        return FloatMappingKt.linearMap(this.targetValues, this.sourceValues, x10);
    }
}
