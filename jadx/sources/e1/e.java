package e1;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f9825e = new e(0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k0.a<e> f9826f = new k0.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IntRange(from = 0)
    public final int f9827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @IntRange(from = 0)
    public final int f9828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @IntRange(from = 0, to = 359)
    public final int f9829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float f9830d;

    public e(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11) {
        this(i10, i11, 0, 1.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f9827a == eVar.f9827a && this.f9828b == eVar.f9828b && this.f9829c == eVar.f9829c && this.f9830d == eVar.f9830d) {
                return true;
            }
        }
        return false;
    }

    public e(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0, to = 359) int i12, @FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        this.f9827a = i10;
        this.f9828b = i11;
        this.f9829c = i12;
        this.f9830d = f10;
    }

    public int hashCode() {
        return ((((((217 + this.f9827a) * 31) + this.f9828b) * 31) + this.f9829c) * 31) + Float.floatToRawIntBits(this.f9830d);
    }
}
