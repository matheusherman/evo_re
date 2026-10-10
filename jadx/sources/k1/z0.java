package k1;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class z0 extends g implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected volatile boolean f12108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AtomicReference f12109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f12110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.google.android.gms.common.a f12111e;

    protected abstract void m(ConnectionResult connectionResult, int i10);

    protected abstract void n();

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(ConnectionResult connectionResult, int i10) {
        this.f12109c.set(null);
        m(connectionResult, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.f12109c.set(null);
        n();
    }

    private static final int p(@Nullable w0 w0Var) {
        if (w0Var == null) {
            return -1;
        }
        return w0Var.a();
    }

    @Override // k1.g
    public final void e(int i10, int i11, Intent intent) {
        w0 w0Var = (w0) this.f12109c.get();
        if (i10 != 1) {
            if (i10 == 2) {
                int iG = this.f12111e.g(b());
                if (iG == 0) {
                    o();
                    return;
                } else {
                    if (w0Var == null) {
                        return;
                    }
                    if (w0Var.b().J() == 18 && iG == 18) {
                        return;
                    }
                }
            }
        } else if (i11 == -1) {
            o();
            return;
        } else if (i11 == 0) {
            if (w0Var != null) {
                l(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, w0Var.b().toString()), p(w0Var));
                return;
            }
            return;
        }
        if (w0Var != null) {
            l(w0Var.b(), w0Var.a());
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        l(new ConnectionResult(13, null), p((w0) this.f12109c.get()));
    }

    public final void s(ConnectionResult connectionResult, int i10) {
        AtomicReference atomicReference;
        w0 w0Var = new w0(connectionResult, i10);
        do {
            atomicReference = this.f12109c;
            if (androidx.p000lifecycle.h.a(atomicReference, null, w0Var)) {
                this.f12110d.post(new y0(this, w0Var));
                return;
            }
        } while (atomicReference.get() == null);
    }

    @VisibleForTesting
    z0(h hVar, com.google.android.gms.common.a aVar) {
        super(hVar);
        this.f12109c = new AtomicReference(null);
        this.f12110d = new x1.l(Looper.getMainLooper());
        this.f12111e = aVar;
    }

    @Override // k1.g
    public final void f(@Nullable Bundle bundle) {
        w0 w0Var;
        super.f(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.f12109c;
            if (bundle.getBoolean("resolving_error", false)) {
                w0Var = new w0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                w0Var = null;
            }
            atomicReference.set(w0Var);
        }
    }

    @Override // k1.g
    public final void i(Bundle bundle) {
        super.i(bundle);
        w0 w0Var = (w0) this.f12109c.get();
        if (w0Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", w0Var.a());
        bundle.putInt("failed_status", w0Var.b().J());
        bundle.putParcelable("failed_resolution", w0Var.b().P());
    }

    @Override // k1.g
    public void j() {
        super.j();
        this.f12108b = true;
    }

    @Override // k1.g
    public void k() {
        super.k();
        this.f12108b = false;
    }
}
