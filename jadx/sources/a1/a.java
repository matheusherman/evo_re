package a1;

import androidx.annotation.Nullable;
import java.util.Arrays;
import k0.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k0.a<a> f95e = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f96a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f97b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f98c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f99d;

    public a(int i10, int... iArr) {
        this(i10, iArr, 0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f96a == aVar.f96a && Arrays.equals(this.f97b, aVar.f97b) && this.f99d == aVar.f99d) {
                return true;
            }
        }
        return false;
    }

    public a(int i10, int[] iArr, int i11) {
        this.f96a = i10;
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        this.f97b = iArrCopyOf;
        this.f98c = iArr.length;
        this.f99d = i11;
        Arrays.sort(iArrCopyOf);
    }

    public boolean a(int i10) {
        for (int i11 : this.f97b) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f96a * 31) + Arrays.hashCode(this.f97b)) * 31) + this.f99d;
    }
}
