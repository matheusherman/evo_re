package k1;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class s0 extends g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f12072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e2.h f12073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f12074d;

    @Override // k1.u0
    public final void a(@NonNull Status status) {
        this.f12073c.d(this.f12074d.a(status));
    }

    @Override // k1.u0
    public final void b(@NonNull Exception exc) {
        this.f12073c.d(exc);
    }

    @Override // k1.u0
    public final void c(z zVar) throws DeadObjectException {
        try {
            this.f12072b.b(zVar.w(), this.f12073c);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            a(u0.e(e11));
        } catch (RuntimeException e12) {
            this.f12073c.d(e12);
        }
    }

    @Override // k1.u0
    public final void d(@NonNull p pVar, boolean z10) {
        pVar.b(this.f12073c, z10);
    }

    @Override // k1.g0
    public final boolean f(z zVar) {
        return this.f12072b.c();
    }

    @Override // k1.g0
    @Nullable
    public final Feature[] g(z zVar) {
        return this.f12072b.e();
    }

    public s0(int i10, n nVar, e2.h hVar, m mVar) {
        super(i10);
        this.f12073c = hVar;
        this.f12072b = nVar;
        this.f12074d = mVar;
        if (i10 == 2 && nVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }
}
