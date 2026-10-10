package r0;

import androidx.annotation.Nullable;
import com.google.common.collect.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f17787d = new d(new c[0]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k0.a<d> f17788e = new k0.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p<c> f17790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17791c;

    private void b() {
        int i10 = 0;
        while (i10 < this.f17790b.size()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f17790b.size(); i12++) {
                if (this.f17790b.get(i10).equals(this.f17790b.get(i12))) {
                    d1.d.c("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i10 = i11;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f17789a == dVar.f17789a && this.f17790b.equals(dVar.f17790b)) {
                return true;
            }
        }
        return false;
    }

    public c a(int i10) {
        return this.f17790b.get(i10);
    }

    public int hashCode() {
        if (this.f17791c == 0) {
            this.f17791c = this.f17790b.hashCode();
        }
        return this.f17791c;
    }

    public d(c... cVarArr) {
        this.f17790b = p.t(cVarArr);
        this.f17789a = cVarArr.length;
        b();
    }
}
