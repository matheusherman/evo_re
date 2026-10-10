package k1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class t0 extends r0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f12076c;

    public t0(i iVar, e2.h hVar) {
        super(4, hVar);
        this.f12076c = iVar;
    }

    @Override // k1.g0
    public final boolean f(z zVar) {
        if (((k0) zVar.y().get(this.f12076c)) == null) {
            return false;
        }
        throw null;
    }

    @Override // k1.g0
    @Nullable
    public final Feature[] g(z zVar) {
        if (((k0) zVar.y().get(this.f12076c)) == null) {
            return null;
        }
        throw null;
    }

    @Override // k1.r0
    public final void h(z zVar) {
        if (((k0) zVar.y().remove(this.f12076c)) == null) {
            this.f12070b.e(Boolean.FALSE);
        } else {
            zVar.w();
            throw null;
        }
    }

    @Override // k1.u0
    public final /* bridge */ /* synthetic */ void d(@NonNull p pVar, boolean z10) {
    }
}
