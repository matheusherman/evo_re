package o1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import k1.k;
import m1.l;
import x1.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends com.google.android.gms.common.internal.c {
    private final l I;

    @Override // com.google.android.gms.common.internal.b
    protected final boolean G() {
        return true;
    }

    public e(Context context, Looper looper, m1.c cVar, l lVar, k1.d dVar, k kVar) {
        super(context, looper, 270, cVar, dVar, kVar);
        this.I = lVar;
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final String C() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final String D() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.b
    @Nullable
    protected final /* synthetic */ IInterface q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    public final Feature[] t() {
        return f.f20536b;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle y() {
        return this.I.b();
    }

    @Override // com.google.android.gms.common.internal.b
    public final int j() {
        return 203400000;
    }
}
