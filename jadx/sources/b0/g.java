package b0;

import androidx.annotation.NonNull;
import e0.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Deprecated
public abstract class g<Z> extends a<Z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f615c;

    public g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public g(int i10, int i11) {
        this.f614b = i10;
        this.f615c = i11;
    }

    @Override // b0.i
    public final void j(@NonNull h hVar) {
        if (l.u(this.f614b, this.f615c)) {
            hVar.e(this.f614b, this.f615c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f614b + " and height: " + this.f615c + ", either provide dimensions in the constructor or call override()");
    }

    @Override // b0.i
    public void a(@NonNull h hVar) {
    }
}
