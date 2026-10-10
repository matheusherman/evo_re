package k1;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
abstract class r0 extends g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final e2.h f12070b;

    protected abstract void h(z zVar);

    @Override // k1.u0
    public final void a(@NonNull Status status) {
        this.f12070b.d(new com.google.android.gms.common.api.b(status));
    }

    @Override // k1.u0
    public final void b(@NonNull Exception exc) {
        this.f12070b.d(exc);
    }

    public r0(int i10, e2.h hVar) {
        super(i10);
        this.f12070b = hVar;
    }

    @Override // k1.u0
    public final void c(z zVar) throws DeadObjectException {
        try {
            h(zVar);
        } catch (DeadObjectException e10) {
            a(u0.e(e10));
            throw e10;
        } catch (RemoteException e11) {
            a(u0.e(e11));
        } catch (RuntimeException e12) {
            this.f12070b.d(e12);
        }
    }
}
